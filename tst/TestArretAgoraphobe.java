package tec;

/**
 * Cette classe permet de vérifier que l’usager ne souhaite 
 * descendre que lorsque l’autobus est plein et non avant. 
 * Elle permet aussi de vérifier que l’usager demande bien à sortir 
 * lorsque l’autobus est plein. 
 */

class TestArretAgoraphobe {

    public void testInteractionArretPlaceRestante(){
        Arret a = ArretAgoraphobe.ARRET;
        Passager p = new FauxPassagerAbstrait("yyy", 5);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.DEBOUT);

        a.choixPlaceArret(p, fauxVehicule,3);
        assert 0 == fauxVehicule.logs.size() : "AA essayer de sortir alors qu'il restait de la place";
    }

    public void testInteractionArretVehiculePlein(){
        Arret a = ArretAgoraphobe.ARRET;
        Passager p = new FauxPassagerAbstrait("yyy", 5);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.PLEIN);

        a.choixPlaceArret(p, fauxVehicule,3);
        assert "arretDemanderSortie" == fauxVehicule.getLastLog() : "N'a pas demandé à sortir";
    }
}

