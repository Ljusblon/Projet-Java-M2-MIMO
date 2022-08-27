package tec;

// On vérifie que l’usager monte et choisit une place debout peu importe 
// le statut de l’autobus ou des places au sein de ce dernier. 
class TestMonteeTetu {

    public void testInteractionMonteeVehiculeVide() {
        MonteeTetu m = new MonteeTetu("yyy", 5, ArretNerveux.ARRET);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.VIDE);

        m.choixPlaceMontee(fauxVehicule);

        assert "monteeDemanderDebout" == fauxVehicule.getLastLog() : "N'a pas demandé de place debout";
    }

    public void testInteractionMonteePlaceDebout() {
        MonteeTetu m = new MonteeTetu("yyy", 5, ArretPoli.ARRET);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.DEBOUT);

        m.choixPlaceMontee(fauxVehicule);

        assert "monteeDemanderDebout" == fauxVehicule.getLastLog() : "N'a pas demandé de place debout";
    }

    public void testInteractionMonteePlaceAssise() {
        MonteeTetu m = new MonteeTetu("yyy", 5, ArretNerveux.ARRET);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.ASSIS);

        m.choixPlaceMontee(fauxVehicule);

        assert "monteeDemanderDebout" == fauxVehicule.getLastLog() : "N'a pas demandé de place debout";
    }

    public void testInteractionMonteeVehiculePlein() {
        MonteeTetu m = new MonteeTetu("yyy", 5, ArretCalme.ARRET);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.PLEIN);

        m.choixPlaceMontee(fauxVehicule);

        assert "monteeDemanderDebout" == fauxVehicule.getLastLog() : "N'a pas demandé de place debout";
    }
}

