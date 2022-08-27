package tec;

// Cette classe permet de vérifier que l’usager ne demande pas d’arrêt 
//avant la fin du trajet. 

class TestArretCalme {

    public void testInteractionArret(){
        Arret a = ArretCalme.ARRET;
        Passager p = new FauxPassagerAbstrait("yyy", 5);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.VIDE);

        a.choixPlaceArret(p, fauxVehicule,3);
        assert 0 == fauxVehicule.logs.size() : "A demandé à changer de place";
    }
}

