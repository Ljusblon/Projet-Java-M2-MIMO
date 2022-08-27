package tec;

public class ArretCalme extends Arret {

    final public static Arret ARRET = new ArretCalme();

    private ArretCalme() {}

    // Le passager reste sur place pendant toute la durée du trajet.
    final void choixPlaceArret(Passager p, Vehicule v, int arret) {}
}