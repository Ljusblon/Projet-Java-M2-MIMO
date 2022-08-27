package tec;

public class ArretPoli extends Arret {

    final public static ArretPoli ARRET = new ArretPoli();

    private ArretPoli() {}

    // Si tous les sièges sont occupés et que le passager est assis, il se met debout.
    final void choixPlaceArret(Passager p, Vehicule v, int arret) {
        if (!v.aPlaceAssise() && p.estAssis()) {
            v.arretDemanderDebout(p);
        }
    }
}