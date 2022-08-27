package tec;

/**
 * Cette classe faussaire ne déclenche pas l’appel aux méthodes de la classe Passager.
 * Elle ne change pas son état. 
 * C'est le test qui change directement la valeur de cette variable. 
 * Elle enregistre l'appel aux méthodes qui doivent modifier son état.
 */

class FauxVehicule extends Vehicule implements Transport {
  static final byte VIDE = 0;
  static final byte DEBOUT  = 1;
  static final byte ASSIS = 2;
  static final byte PLEIN = 4;
  byte status;

  final java.util.List<String> logs = new java.util.LinkedList<String>();

  FauxVehicule() {
    this(VIDE);
  }

  FauxVehicule(byte init) {
    status = init;
  }

  public boolean aPlaceAssise() {
    return status == ASSIS 
      || status == VIDE;
  }

  public boolean aPlaceDebout() {
    return status == DEBOUT 
      || status == VIDE;
  }

  // Enregistrements des appels effectués par PassagerStandard.
  public void monteeDemanderAssis(Passager p) {
    logs.add("monteeDemanderAssis");
  }

  public void monteeDemanderDebout(Passager p) {
    logs.add("monteeDemanderDebout");
  }

  public void arretDemanderDebout(Passager p) {
    logs.add("arretDemanderDebout");
  }
  
  public void arretDemanderAssis(Passager p) {
    logs.add("arretDemanderAssis");
  }

  public void arretDemanderSortie(Passager p) {
    logs.add("arretDemanderSortie");    
  }

  // PassagerStandard n'utilise pas cette méthode.
  public void allerArretSuivant() { 
  }

  String getLastLog() {
    return this.logs.get(this.logs.size() -1);
  }
}
