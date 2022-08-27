package tec;

public class ArretNerveux extends Arret {

    final public static ArretNerveux ARRET = new ArretNerveux();

    private ArretNerveux() {}

    // Le passager change de place à chaque arrêt
    final void choixPlaceArret(Passager p, Vehicule v, int arret) {
        if (v.aPlaceDebout() && p.estAssis()) {
            v.arretDemanderDebout(p);
        } else {
            if (v.aPlaceAssise() && p.estDebout()) {
                v.arretDemanderAssis(p);
            }
        }
    }
}