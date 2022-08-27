package tec;

public class ArretPrudent extends Arret {

    final public static ArretPrudent ARRET = new ArretPrudent();

    private ArretPrudent() {}

    // Si la distance entre sa destination et l'arrêt actuel est inférieure à 3 arrêts.
    final void choixPlaceArret(Passager p, Vehicule v, int arret) {
        if (p.getDistance(arret) <= 3 && p.estAssis() && v.aPlaceDebout()) {
            v.arretDemanderDebout(p);
        }
    }
}