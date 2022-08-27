package tec;

/**
 * Cette classe faussaire ne déclenche pas d'appel aux méthodes d'Autobus.
 * Elle ne change pas son état.
 * C'est le test qui change directement la valeur de cette variable.
 * Elle enregistre l'appel aux méthodes qui doivent modifier son état.
*/
class FauxPassagerAbstrait extends PassagerAbstrait implements Usager {
    static final byte DEHORS = 0;
    static final byte ASSIS  = 1;
    static final byte DEBOUT = 2;
    byte status = DEHORS;

    final java.util.List<String> logs = new java.util.LinkedList<String>();

    FauxPassagerAbstrait(String name, int dest) {
        super(name,dest, ArretCalme.ARRET);
        status = DEHORS;
    }

    public String nom() {
        return null;
    }

    public boolean estDehors() {
        return status == DEHORS;
    }

    public boolean estAssis() {
        return status == ASSIS;
    }

    public boolean estDebout() {
        return status == DEBOUT;
    }

    // Enregistrements des appels effectués par Autobus.
    public void changerEnDehors() {
        status = DEHORS;
        logs.add("changerEnDehors");
    }

    public void changerEnAssis() {
        status = ASSIS;
        logs.add("changerEnAssis");
    }

    public void changerEnDebout() {
        status = DEBOUT;
        logs.add("changerEnDebout");
    }

    public void choixPlaceMontee(Vehicule v) { logs.add("choixPlaceMontee"); }
}