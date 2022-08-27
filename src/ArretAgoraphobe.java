package tec;

public class ArretAgoraphobe extends Arret {

    final public static Arret ARRET = new ArretAgoraphobe();

    private ArretAgoraphobe() {}
    
    // Si le bus est plein, le passager demande à en sortir.
    final void choixPlaceArret(Passager p, Vehicule v, int arret) {
        if (!v.aPlaceDebout() && !v.aPlaceAssise()) {
            v.arretDemanderSortie(p);
        }
    }
}