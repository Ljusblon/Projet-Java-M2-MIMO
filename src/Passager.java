package tec;

/**
 * Cette interface fixe/définit/spécifie les services d'un passager
 * qui va être pris en charge par un véhicule.
 * Elle précise les interactions avec l'interface Vehicule. 
 *
 * Un passager possède un nom et une destination (un numéro d'arret). 
 * Il possède un comportement à la montée et un comportement à chaque arrêt. 
 * Quand un passager arrive a son arrêt de destination, il sort du véhicule.
 *
 * Dans un véhicule, un passager est forcément soit assis, soit debout. 
 * S'il n'est ni assis, ni debout, il est forcement dehors. 
 * Quand un passager est crée, il est dans la position dehors.
 *
 * Les méthodes changerEnAssis(), changerEnDebout(), accepterSortie() 
 * modifie la position d'un passager. 
 *
 * L'utilisateur déclenche la montée du passager dans un véhicule par la méthode
 * monterDans().Si le véhicule accepte la demande, il déclenche un des
 * méthodes qui modifient la position du passager.
 *
 * À chaque arrêt, la méthode nouvelArret() est appelée par un véhicule.
 * Le passager peut choisir de changer de place ou de sortir du bus.
 * Si le véhicule accepte la demande, il déclenche une des
 * méthodes qui modifie la position du passager.
 */

abstract class Passager {
    /**
     * fournit le nom de du passager.
     */
    abstract String nom();
    /**
     * @return vrai si la position du passager est dehors.
     */
    abstract boolean estDehors();
    
    /**
     * @return vrai si la position du passager est assis.
     */
    abstract boolean estAssis();
    
    /**
     * @return vrai si la position du passager est debout.
     */
    abstract boolean estDebout();
    
    /**
     * Change la position du passager en dehors.
     * Cette méthode est appélee par un véhicule.
     */
    abstract void changerEnDehors();
    
    /**
     * Change la position du passager en assis. 
     * Cette méthode est appélee par un véhicule.
     */
    abstract void changerEnAssis();
    
    /**
     * Change la position du passager en debout.
     * Cette méthode est appélee par un véhicule.
     */
    abstract void changerEnDebout();
    
    /**
     * Cette méthode simule le caractère d'un passage lors d'un arrêt.
     * Elle est appelée par le véhicule dans lequel est monté le passager.
     * @param v le vehicule dans lequel se trouve le passager.
     * @param numeroArret numéro de l'arrêt courant.
     */
    abstract void nouvelArret(Vehicule v, int numeroArret);

    abstract int getDistance(int numeroArret);
}

