package tec;

public class MonteeFatigue extends PassagerAbstrait {

    public MonteeFatigue(String name, int dest, Arret typeArret){

        super(name, dest, typeArret);
    }

    protected void choixPlaceMontee(Vehicule v) {

        // Le passager essaie de prendre une place assise.
        if (v.aPlaceAssise()) {
            v.monteeDemanderAssis(this);
        }
    }
}