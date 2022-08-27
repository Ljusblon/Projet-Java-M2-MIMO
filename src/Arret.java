package tec;

// Classe abstraite Arret
// Comportement du passager à chaque arrêt
abstract class Arret {
    abstract void choixPlaceArret(Passager p, Vehicule v, int arret);
}