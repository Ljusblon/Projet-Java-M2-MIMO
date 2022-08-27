package tec;

/**
 * Réalisation d'une jauge sur un intervalle d'entiers.
 * Une instance de Jauge définit une position par rapport à un intervalle 
 * de référence [0, n].

 * L'état d'une jauge correspond à sa position par rapport à l'intervalle
 * de référence [0, n].
 * Une jauge définit deux états :
 * - rouge position de la jauge supérieure à l'intervalle,
 * - vert position de la jauge dans l'intervalle,
 */

class Jauge { 
  private int valeur;
  private final int MAX;

  /**
   * Construit une instance en précisant la valeur max de l'intervalle 
   * [0, n] et la position de départ de la Jauge.
   * La position de départ n'est pas forcément dans l'intervalle 
   * [0, n].
   * @param n valeur maximale > 0 de l'intervalle.
   * @param depart   position de départ de la Jauge.
   */
    public Jauge(int max, int depart){
      if(max < 0)
	  throw new IllegalArgumentException(max + "est une valeur max négative dans une Jauge");
      valeur = depart;
      MAX = max;
  }

  /**
   * La position de la jauge est-elle au-dessus de l'intervalle ?
   * @return vrai si niveau >=  n.
   */
  public boolean estRouge() {
    return valeur >= MAX;
  }

  /**
   * La position de la jauge est-elle dans l'intervalle ?
   * @return vrai si niveau appartient à [0, n].
   */
  public boolean estVert() {
    return valeur >= 0 && valeur < MAX;
  }

  /**
   * Incrémente la position de la jauge.
   * La position peut devenir supérieur à n.
   */
  public void incrementer() {
    valeur++;
  }

  /**
   * Décrémente la position de la jauge.
   */
  public void decrementer() {
      valeur--;
  }

  /**
   * Cette méthode est héritée de la classe {@link java.lang.Object}.
   * Elle fournit une chaîne de caractères correspondant à l'état d'un objet.
   */
  @Override
  public String toString() {
    return String.valueOf(MAX - valeur);
  }
}
