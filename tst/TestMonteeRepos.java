package tec;

// On vérifie que par défaut, l’usager monte dans l’Autobus et prend une place assise. 
// S’il n’y a plus de place assise, il prend une place debout. 
// Enfin, si l’autobus est plein, il ne monte pas. 
class TestMonteeRepos {

    public void testInteractionMonteeVehiculeVide() {
        MonteeRepos m = new MonteeRepos("yyy", 5, ArretNerveux.ARRET);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.VIDE);

        m.choixPlaceMontee(fauxVehicule);

        assert "monteeDemanderAssis" == fauxVehicule.getLastLog() : "assis";
    }

    public void testInteractionMonteePlaceDebout() {
        MonteeRepos m = new MonteeRepos("yyy", 5, ArretNerveux.ARRET);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.DEBOUT);

        m.choixPlaceMontee(fauxVehicule);

        assert "monteeDemanderDebout" == fauxVehicule.getLastLog() : "debout";
    }

    public void testInteractionMonteeVehiculePlein() {
        MonteeRepos m = new MonteeRepos("yyy", 5, ArretNerveux.ARRET);
        FauxVehicule fauxVehicule = new FauxVehicule(FauxVehicule.PLEIN);

        m.choixPlaceMontee(fauxVehicule);

        assert 0 == fauxVehicule.logs.size() : "pas de place";
    }
}
