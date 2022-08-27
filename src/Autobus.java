package tec;

import java.util.LinkedList;

public class Autobus extends Vehicule implements Transport {
    //Les attributs propres à cette classe
    private int nbPlaceAssise;
    private int nbPlaceDebout;
    private Jauge assisJauge;
    private Jauge deboutJauge;
    private int numeroArret;
    private LinkedList<Passager> tableauPassager;
    private int nbPassager;

    //Constructeur
    public Autobus(int nbPlaceAssise, int nbPlaceDebout){
        if (nbPlaceAssise < 0 || nbPlaceDebout < 0)
            throw new IllegalArgumentException("Nombre de place est négatif");
		this.nbPlaceAssise = nbPlaceAssise;
		this.nbPlaceDebout = nbPlaceDebout;
		assisJauge = new Jauge(nbPlaceAssise,0);
		deboutJauge = new Jauge(nbPlaceDebout,0);
		numeroArret = 0;
		nbPassager = 0;
		tableauPassager = new LinkedList<Passager>();
    }

    private int chercherEmplacementVide(){
	return nbPassager;
    }

    private void ajouterPassager(Passager p) {
	tableauPassager.add(chercherEmplacementVide(), p);
	nbPassager++;
    }

    private int chercherPassager(Passager p) {
	return tableauPassager.indexOf(p);
    }

    /**
     * Méthode qui indique au véhicule l'arrêt suivant en déclenche sur chaque passager
     * la méthode arretSuivant().
     */
    public void allerArretSuivant() {
    	numeroArret ++;
		for (int i = 0; i < nbPassager; i++) {
		    (tableauPassager.get(i)).nouvelArret(this, numeroArret);
		}
    }

    /**
     * Indique s'il reste des places assises libres.
     * @return vrai si nombre max de places assises n'est pas atteinte. 
     */
    boolean aPlaceAssise(){
	return assisJauge.estVert();
    }

    /**
     * Indique s'il des places debout libres.
     * @return vrai si nombre max de places debout n'est pas atteinte. 
     */
    boolean aPlaceDebout(){
	return deboutJauge.estVert();
    }

    /**
     * Le passager entre dans le véhicule en demandant une place assise.
     * la position du passager est forcément dehors.
     * Cette méthode est appelée par un passager.
     * @param p le passager qui demande à montée.
     */
    void monteeDemanderAssis(Passager p){
        if ( chercherPassager(p) >= 0 )
	    throw new IllegalStateException(p.nom() + "est dedans");
	if (assisJauge.estVert()) {
	    assisJauge.incrementer();
	    p.changerEnAssis();
	    ajouterPassager(p);
	}
    }

    /**
     * Le passager entre dans le véhicule en demandant une place debout.
     * la position du passager est forcément dehors.
     * Cette méthode est appelée par un passager.
     * @param p le passager qui demande à montée.
     */
    void monteeDemanderDebout(Passager p){
	if ( chercherPassager(p) >= 0 )
            throw new IllegalStateException(p.nom() + "est dedans");
		if (deboutJauge.estVert()) {
	    	deboutJauge.incrementer();
	    	p.changerEnDebout();
	        ajouterPassager(p);
		}
    }

    /**
     * Change un passager d'une place assise vers une place debout
     * pour un passager déjà dans le véhicule.
     * @param p le passager avec une position assis dans le véhicule.
     */
    void arretDemanderDebout(Passager p){
        if (deboutJauge.estVert()) {
            deboutJauge.incrementer();
            assisJauge.decrementer();
            p.changerEnDebout();
        }
    }

    /**
     * Change un passager d'une place debout vers une place assise
     * pour un passager déjà dans le véhicule.
     * @param p le passager avec une position debout dans le véhicule.
     */
    void arretDemanderAssis(Passager p) {
        if (assisJauge.estVert()) {
            assisJauge.incrementer();
            deboutJauge.decrementer();
            p.changerEnAssis();
        }
    }

    /**
     * Fait sortir un passager du véhicule.
     * @param p le passager avec une position soit assise soit debout 
     *          dans le véhicule. 
     */
    void arretDemanderSortie(Passager p) {
		if (p.estDebout()){
	    	deboutJauge.decrementer();
		}
		else {
	    	assisJauge.decrementer();
		}
		p.changerEnDehors();
		tableauPassager.set(chercherPassager(p), tableauPassager.get(nbPassager - 1));
		nbPassager--;
    }

    public String toString() {
		return "[arret " + numeroArret +"] assis<" + assisJauge.toString()  + "> debout<"+ deboutJauge.toString() + ">";
    }
}
