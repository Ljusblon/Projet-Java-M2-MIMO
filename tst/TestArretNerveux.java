package tec;

/**
 * Cette classe permet de vérifier que l’usage a bien demandé 
 * à changer de place à chaque arrêt. 
 * Elle permet de vérifier qu’il demande bien une place assise lorsque c’est le cas, 
 * ou bien debout lorsque c’est l’autre cas de figure. 
 */

class TestArretNerveux {

    public void testInteractionArretAlterne() {
        Passager p = new FauxPassagerAbstrait("yyy", 5);

        Arret a1 = ArretNerveux.ARRET;
        FauxVehicule fauxVehicule1 = new FauxVehicule(FauxVehicule.VIDE);

        p.changerEnDebout();
        a1.choixPlaceArret(p, fauxVehicule1, 1);
        assert "arretDemanderAssis" == fauxVehicule1.getLastLog() : "N'a pas demandé à changer de place";
        p.changerEnAssis();
        a1.choixPlaceArret(p, fauxVehicule1, 2);
        assert "arretDemanderDebout" == fauxVehicule1.getLastLog() : "N'a pas demandé à changer de place";
        p.changerEnDebout();
    }

    public void testInteractionArretPasPlaceAssise() {
        Passager p = new FauxPassagerAbstrait("yyy", 5);

        Arret a2 = ArretNerveux.ARRET;
        FauxVehicule fauxVehicule2 = new FauxVehicule(FauxVehicule.DEBOUT);

        p.changerEnDebout();
        a2.choixPlaceArret(p, fauxVehicule2, 1);
        assert 0 == fauxVehicule2.logs.size() : "Il a demandé à s'assoir alors qu'il n'y avait pas de place";
        p.changerEnDebout();
    }

    public void testInteractionArretPasDePlaceDebout() {
        Passager p = new FauxPassagerAbstrait("yyy", 5);

        Arret a3 = ArretNerveux.ARRET;
        FauxVehicule fauxVehicule3 = new FauxVehicule(FauxVehicule.ASSIS);

        p.changerEnAssis();
        a3.choixPlaceArret(p, fauxVehicule3, 1);
        assert 0 == fauxVehicule3.logs.size() : "Il a demandé à se mettre debout alors qu'il n'y avait pas de place";
        p.changerEnDebout();
    }
}

