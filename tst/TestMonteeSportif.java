package tec;

// On vérifie que l’usager choisi par défaut une place debout 
// lorsqu’il monte dans l’autobus. 
// Si ce dernier est plein, il ne monte pas, de même s’il n’y a plus de place debout. 
class TestMonteeSportif {

    public void testInteractionMonteeVehiculeVide() {
        MonteeSportif m = new MonteeSportif("yyy", 5, ArretNerveux.ARRET);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.VIDE);

        m.choixPlaceMontee(fauxVehicule);

        assert "monteeDemanderDebout" == fauxVehicule.getLastLog() : "Il n'a pas demandé à monter debout";
    }

    public void testInteractionMonteePlaceDebout() {
        MonteeSportif m = new MonteeSportif("yyy", 5, ArretNerveux.ARRET);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.DEBOUT);

        m.choixPlaceMontee(fauxVehicule);

        assert "monteeDemanderDebout" == fauxVehicule.getLastLog() : "Il n'a pas demandé à monter debout";
    }

    public void testInteractionMonteePlaceAssise() {
        MonteeSportif m = new MonteeSportif("yyy", 5, ArretCalme.ARRET);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.ASSIS);

        m.choixPlaceMontee(fauxVehicule);

        assert 0 == fauxVehicule.logs.size() : "Il a demandé à monter alors qu'il n'y a pas de places debout";
    }

    public void testInteractionMonteeVehiculePlein() {
        MonteeSportif m = new MonteeSportif("yyy", 5, ArretPoli.ARRET);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.PLEIN);

        m.choixPlaceMontee(fauxVehicule);

        assert 0 == fauxVehicule.logs.size() : "Il a demandé à monter alors que le véhicule est plein";
    }
}

