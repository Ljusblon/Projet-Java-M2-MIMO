package tec;

// On vérifie qu’un passager avec une montée et une sortie correcte, 
// ne peut pas atteindre une destination hors des limites. 
// Dans ce cas de test, le numéro de l’arrêt est négatif. 
class TestPassagerAbstrait {
    public void testCasLimite() {
	try {
	    MonteeSportif m = new MonteeSportif("yyy", -10, ArretNerveux.ARRET);
	} catch (IllegalArgumentException e) { return; }
	assert false: "destination négative";
    }
}