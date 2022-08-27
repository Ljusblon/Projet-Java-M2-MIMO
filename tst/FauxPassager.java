package tec;

/**
 * Cette classe faussaire ne déclenche pas d'appel aux méthodes d'Autobus. 
 * Elle ne change pas son état.
 * C'est le test qui change directement la valeur de cette variable.
 * Elle enregistre l'appel aux méthodes qui doivent modifier son état.
 */
class FauxPassager extends Passager implements Usager {
  static final byte DEHORS = 0;
  static final byte ASSIS  = 1;
  static final byte DEBOUT = 2;
  byte status = DEHORS;

  final java.util.List<String> logs = new java.util.LinkedList<String>();

  FauxPassager() {
    this(DEHORS);
  }

  FauxPassager(byte init) {
    status = init;
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
    logs.add("changerEnDehors");
  }

  public void changerEnAssis() {
    logs.add("changerEnAssis");
  }

  public void changerEnDebout() {
    logs.add("changerEnDebout");
  }

  public void nouvelArret(Vehicule bus, int numeroArret) {
    logs.add("nouvelArret");
  }

  // Autobus n'utilise pas cette méthode.
  public void monterDans(Transport t) {
  }
  
  final public int getDistance(int numeroArret) {return 0;}

  String getLastLog() {
    return this.logs.get(this.logs.size() -1);
  }

}
