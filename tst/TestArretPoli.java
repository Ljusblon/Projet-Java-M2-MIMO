package tec;

/**
 * Cette classe permet de vérifier que l’usager demande à être debout 
 * lorsqu’il n’y a plus de place assise, 
 * de même il faut vérifier que l’usager ne demande pas à être 
 * assis lorsqu’il est debout. 
 */
class TestArretPoli {

    public void testInteractionArretAssis(){
        Arret a = ArretPoli.ARRET;
        Passager p = new FauxPassagerAbstrait("yyy", 5);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.DEBOUT);

        p.changerEnAssis();
        a.choixPlaceArret(p, fauxVehicule,3);
        assert "arretDemanderDebout" == fauxVehicule.getLastLog() : "N'a pas demandé à changer de place";
    }

    public void testInteractionArretVehiculeVide(){
        Arret a = ArretPoli.ARRET;
        Passager p = new FauxPassagerAbstrait("yyy", 5);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.VIDE);

        p.changerEnDebout();
        a.choixPlaceArret(p, fauxVehicule,3);
        assert 0 == fauxVehicule.logs.size() : "A essayer de changer de place alors qu'il est debout ";
    }
}

