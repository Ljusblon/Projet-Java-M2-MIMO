package tec;

/**
 * Cette classe représente la position d'un passager dans le véhicule.
 * Une position a trois états possibles : assis dans un transport, 
 * debout dans un transport et dehors d'un transport.
 * Les instances de cette classe sont des objets constants.
 **/
class Position {

    final private static Position DEHORS = new Position();
    final private static Position ASSIS = new Position();
    final private static Position DEBOUT = new Position();

    /**
     * Construit une instance en précisant une des positions du passager.
     * @param e valeur d'une des positions.
     */
    private Position() {
    }

    public static Position initialisationPosition() {
	return DEHORS;
    }
    /**
     * @return vrai si l'état de l'instance est dehors;
     */
    public boolean estDehors() {
	return this == DEHORS;
    }

    /**
     * @return vrai si l'état de l'instance est assis;
     */
    public boolean estAssis() {
	return this == ASSIS;
    }

    /**
     * @return vrai si l'état de l'instance est debout;
     */
    public boolean estDebout() {
	return this == DEBOUT;
    }

    /**
     * @return vrai la position est assis ou debout.
     */
    public boolean estInterieur() {
	return this != DEHORS;
    }


    /**
     * Retourne une instance de Position assis.
     * @return instance dans l'état assis.
     */
    public Position assis() {
	return ASSIS; 
    }

    /**
     * Retourne une instance de Position debout.
     * @return instance dans l'état debout.
     */
    public Position debout() {
	return DEBOUT;
    }

    /**
     * Retourne une instance de Position dehors.
     * @return instance dans l'état dehors.
     */
    public Position dehors() {
	return DEHORS;
    }

    /**
     * Cette méthode est héritée de la classe {@link java.lang.Object}.
     * Elle permet de fournir une chaîne de caractères correspondant à l'état d'un objet.
     */
    @Override
    public String toString() {
	String nom = null;
	if (this == DEHORS){
	    nom = "en dehors";
	}
	if (this == ASSIS){
	    nom = "assis";
	}
	if (this == DEBOUT){
	    nom = "debout";
	}
	return "<" + nom + ">";
    }
}
