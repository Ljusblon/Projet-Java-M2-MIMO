package tec;

/**
 * Cette classe permet de vérifier que l’usager ne change de place que dans le cadre défini 
 * par son comportement en tant que prudent, 
 * de même il faut vérifier qu’il se met bien debout avant de descendre 
 * à l’arrêt prévu. 
 */

class TestArretPrudent {

    public void testInteractionArret(){
        Arret a = ArretPrudent.ARRET;

        Passager p = new FauxPassagerAbstrait("Marc", 80);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.VIDE);

        a.choixPlaceArret(p, fauxVehicule,25);
        assert 0 == fauxVehicule.logs.size() : "A demandé à changer de place";

        p.changerEnAssis();
        a.choixPlaceArret(p, fauxVehicule,78);
        assert "arretDemanderDebout" == fauxVehicule.getLastLog() : "N'a pas demandé à passer debout";
    }
}

