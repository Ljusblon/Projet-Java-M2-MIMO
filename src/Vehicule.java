package tec;

    /**
     * Cette classe abstraite définit et spécifie les services
     * d'un véhicule qui accepte des passagers.
     * Le client déclenche le trajet vers un nouvel arrêt par la méthode allerArretSuivant().
     *
     * Un véhicule a un nombre déterminé de places assises et de places debout.
     * Le nombre de places, tant assises que debout, est fixé à l'instanciation de la classe.
     * Un véhicule autorise un passager à monter pour occuper soit une place debout,
     * soit une place assise. Si l'entrée est acceptée le véhicule déclenche les modificateurs de passager,
     * soit le changement de la position du passager.
     * Le véhicule prévient ses passagers de chaque nouvel arrêt par appel à la méthode
     * nouvelArret() de chaque passager.
     *
     * À chaque arrêt, un véhicule permet aux passagers soit de sortir, soit de changer de place.
     * Si la demande est acceptée, le véhicule déclenche les méthodes de modification de l'état du passager.
     */
abstract class Vehicule {

    /**
    * @return vrai si le nombre max de places assises n'est pas atteint.
    */
    abstract boolean aPlaceAssise();

    /**
     * @return vrai si le nombre max de places debout n'est pas atteint.
     */
    abstract boolean aPlaceDebout();

    /**
     * Le passager entre dans le véhicule en demandant une place assise.
     * la position du passager est forcément dehors.
     * Cette méthode est appelée par un passager.
     * @param p le passager qui demande à montée.
     */
    abstract void monteeDemanderAssis(Passager p);

    /**
     * Le passager entre dans le véhicule en demandant une place debout.
     * la position du passager est forcément dehors.
     * Cette méthode est appelée par un passager.
     * @param p le passager qui demande à montée.
     */
    abstract void monteeDemanderDebout(Passager p);

    /**
     * Change un passager d'une place assise vers une place debout
     * pour un passager déjà dans le véhicule.
     * @param p le passager avec une position assis dans le véhicule.
     */
    abstract void arretDemanderDebout(Passager p);

    /**
     * Change un passager d'une place debout vers une place assise
     * pour un passager déjà dans le véhicule.
     * @param p le passager avec une position debout dans le véhicule.
     */
    abstract void arretDemanderAssis(Passager p);

    /**
     * Fait sortir un passager du véhicule.
     * @param p le passager avec une position soit assise soit debout 
     * dans le véhicule.
     */
    abstract void arretDemanderSortie(Passager p);
}
