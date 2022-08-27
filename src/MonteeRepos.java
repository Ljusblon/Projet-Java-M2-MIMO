package tec;

public class MonteeRepos extends PassagerAbstrait {

    public MonteeRepos(String name, int dest, Arret typeArret){

        super(name, dest, typeArret);
    }

    protected void choixPlaceMontee(Vehicule v) {

        // Le passager essaie d'abord de s'asseoir.
        if (v.aPlaceAssise()) {
            v.monteeDemanderAssis((Passager)this);
        }

        // Le passager essaie de prendre une place dans le véhicule.
        else {
            if (v.aPlaceDebout()) {
                v.monteeDemanderDebout((Passager)this);
            }
        }
    }
}