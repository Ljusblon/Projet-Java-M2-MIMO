package tec;

// On vérifie que le passager ne monte dans l’Autobus que 
// s’il n’est pas plein et s’il reste des places assises. 
class TestMonteeFatigue {

    public void testInteractionMonteeVehiculeVide() {
        MonteeFatigue m = new MonteeFatigue("yyy",5, ArretNerveux.ARRET);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.VIDE);

        m.choixPlaceMontee(fauxVehicule);

        assert "monteeDemanderAssis" == fauxVehicule.getLastLog() : "Il n'a pas demandé à monter assis";
    }

    public void testInteractionMonteeVehiculePlein() {
        MonteeFatigue m = new MonteeFatigue("yyy",5, ArretCalme.ARRET);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.PLEIN);

        m.choixPlaceMontee(fauxVehicule);

        assert 0 == fauxVehicule.logs.size() : "Il a demandé à monter alors que le véhicule est plein";
    }
}

