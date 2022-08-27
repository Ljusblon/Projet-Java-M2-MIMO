package tec;

/**
 * On teste ici ici les différents cas de figure 
 * pour la jauge minimale et maximale de l'autobus.
 * On teste tous les cas de figures qui tendent vers les extrêmes.
 */
class TestJauge {

    public void testDansIntervalle() {
	Jauge jauge = new Jauge(67899,100);
	assert jauge.estVert() : "le test dans l'intervalle de estVert() a échoué";
	assert jauge.estRouge() == false : "le test dans l'intervalle de estRouge() a échoué";
    }

    public void testHorsIntervalle() {
	Jauge jauge = new Jauge(50,100);
	assert jauge.estVert() == false : "le test hors intervalle de estVert() a échoué"; //Error
	assert jauge.estRouge() : "le test hors intervalle de estRouge() a échoué";
    }

    public void testIncrementer() {
	Jauge jauge = new Jauge(100,98);
	jauge.incrementer();
	assert jauge.estVert() : "le test dans l'intervalle pour une incrémentation de estVert() a échoué"; //Error
	assert jauge.estRouge() == false: "le test dans l'intervalle pour une incrémentation de estRouge() a échoué";
	jauge.incrementer();
	assert jauge.estVert() == false: "le test hors l'intervalle pour deux incrémentation de estVert() a échoué";
	assert jauge.estRouge() : "le test hors l'intervalle pour deux incrémentation de estRouge() a échoué"; //Error
    }
    
    public void testDecrementer() {
	Jauge jauge = new Jauge (100, 101);
	jauge.decrementer();
	assert jauge.estVert() == false: "le test hors intervalle pour une décrémentation de estVert() a échoué";
	assert jauge.estRouge() : "le test hors intervalle pour une décrémentation de estRouge() a échoué"; //Error
	jauge.decrementer();
	assert jauge.estVert() : "le test dans l'intervalle pour deux décrémentation de estVert() a échoué"; //Error
	assert jauge.estRouge() == false: "le test dans l'intervalle pour deux décrémentation de estRouge() a échoué";
    }

    public void testCasLimite() {
        try {
            Jauge jauge = new Jauge (-42, 10);
        } 
        catch (IllegalArgumentException e) { return; }
        assert false: "Exception non levee";
    }
}
