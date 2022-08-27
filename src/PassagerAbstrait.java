package tec;

abstract class PassagerAbstrait extends Passager implements Usager{

    // Variables
    final private String nom;
    final private int destination;
    private Position maPosition;
    final private Arret comportementArret;

    // Constructeur
    public PassagerAbstrait(String name, int dest, Arret arret){
        maPosition = Position.initialisationPosition();
        if (dest < 0)
            throw new IllegalArgumentException(dest + "est négatif");
        destination = dest;
        nom = name;
        comportementArret = arret;

    }
    
    /**
     * fournit le nom de du passager.
     */
    String nom(){
        return nom;
    }

    /**
     * @return vrai si la position du passager est dehors.
     */
    boolean estDehors(){
        return maPosition.estDehors();
    }

    /**
     * @return vrai si la position du passager est assis.
     */
    boolean estAssis(){
        return maPosition.estAssis();
    }

    /**
     * @return vrai si la position du passager est debout.
     */
    boolean estDebout(){
        return maPosition.estDebout();
    }

    /**
     * Change la position du passager en dehors.
     * Cette méthode est appélee par un véhicule.
     */
    void changerEnDehors(){
        maPosition = maPosition.dehors();
    }

    /**
     * Change la position du passager en assis.
     * Cette méthode est appélee par un véhicule.
     */
    void changerEnAssis(){
        maPosition = maPosition.assis();
    }

    /**
     * Change la position du passager en debout.
     * Cette méthode est appélee par un véhicule.
     */
    void changerEnDebout(){
        maPosition = maPosition.debout();
    }

    final int getDistance(int numeroArret) {
        if (destination > numeroArret) {
            return destination - numeroArret;
        } else {
            return 0;
        }
    }

    final protected Arret getArret() {
        return comportementArret;
    }

    abstract protected void choixPlaceMontee(Vehicule v);

    /**
     * Cette méthode réalise le caractère du passager lors de sa montée dans le véhicule.
     * @param v le véhicule dans lequel va monter le passager.
     */
    final public void monterDans(Transport t) throws TecException {
        if (!(t instanceof Vehicule)) {
            throw new TecException("The Transport is not a Vehicule");
        }
        Vehicule v = (Vehicule) t;
        try { choixPlaceMontee(v); }
	    catch (java.lang.IllegalStateException e) {
	        throw new TecException(e);
	    }
    }

    /**
     * Cette méthode réalise le caractère du passager lors d'un arrêt.
     * Elle est appelée par le véhicule dans lequel est monté le passager.
     * @param v le vehicule dans lequel se trouve le passager.
     * @param numeroArret numéro de l'arrêt courant.
     */
    void nouvelArret(Vehicule v, int numeroArret) {
        if (destination == numeroArret) {
            v.arretDemanderSortie((Passager)this);
        } 
        else {
            comportementArret.choixPlaceArret(this, v, numeroArret);
        }
    }

    public String toString(){
	return nom + " " + maPosition.toString();
    }
}
