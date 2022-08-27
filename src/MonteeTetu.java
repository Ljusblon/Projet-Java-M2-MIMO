package tec;

public class MonteeTetu extends PassagerAbstrait {

    public MonteeTetu(String name, int dest, Arret typeArret){

        super(name, dest, typeArret);
    }

    // Le passager souhaite monter dans l’autobus, peu importe le type de place disponible.
    protected void choixPlaceMontee(Vehicule v) {

        v.monteeDemanderDebout(this);
    }
}