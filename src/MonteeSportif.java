package tec;

public class MonteeSportif extends PassagerAbstrait {

    public MonteeSportif(String name, int dest, Arret typeArret){

        super(name, dest, typeArret);
    }

    // Le passager prend une place debout par défaut.
    protected void choixPlaceMontee(Vehicule v) {
        if (v.aPlaceDebout()) {
            v.monteeDemanderDebout(this);
        }
    }
}