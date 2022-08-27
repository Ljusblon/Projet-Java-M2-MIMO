package tec;

class TestAutobus {

  //********************************************************
  
  /* Etat apres instanciation
   * Deux cas d'autobus:
   *   - uniquement des places assises.
   *   - uniquement des places debout.
   */

  public void testInstanciation() {
    //*********** Assis ****************************
    Autobus assis = new Autobus(66, 0);

    assert true == assis.aPlaceAssise();
    assert false == assis.aPlaceDebout();

    //************ Debout ***************************
    Autobus debout = new Autobus(0, 99);

    assert false == debout.aPlaceAssise();
    assert true == debout.aPlaceDebout();
  }


  /* Gestion des places a la montee.
   *
   * Remplir toutes les places assises d'un autobus.
   * Remplir toutes les places debout d'un autobus.
   */
  public void testGestionDemander() {
    FauxPassager[] faux = {new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager()}; //10

    Autobus bus = new Autobus(5, 3);

    //********* Assis *******************************
    for (int i = 1; i < 5; i++) { //4
      bus.monteeDemanderAssis(faux[i]);
      assert true == bus.aPlaceAssise() : "demande " + i;	
    }

    bus.monteeDemanderAssis(faux[5]);
    assert false == bus.aPlaceAssise() : "demande 5: fin assis";


    //*********** Debout ******************************
    bus.monteeDemanderDebout(faux[6]);
    assert true == bus.aPlaceDebout() : "demande 1";

    bus.monteeDemanderDebout(faux[7]);
    assert true == bus.aPlaceDebout() : "demande 2";	

    bus.monteeDemanderDebout(faux[8]);
    assert false == bus.aPlaceDebout() : "demande 3: fin debout";
  }

  /* Gestion des places à la sortie d'un passager a un arret. 
   *
   * Remplir toutes les places assises et toutes les places debout.
   * Faire sortir un assis et un debout.
   */
  public void testGestionSortie() {
    FauxPassager[] faux = {new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager()}; // 9

    Autobus bus = new Autobus(3, 4);

    //*************** Remplir **********************
    for (int i = 1; i < 4; i++) { //3
      bus.monteeDemanderAssis(faux[i]);
      faux[i].status = FauxPassager.ASSIS;
    }

    for (int i = 4; i <= 7; i++) { //4
      bus.monteeDemanderDebout(faux[i]);
      faux[i].status = FauxPassager.DEBOUT;
    }

    //***************** Sortir *************************
    bus.arretDemanderSortie(faux[6]);
    assert true == bus.aPlaceDebout() : "sortie debout";

    bus.arretDemanderSortie(faux[2]);
    assert true == bus.aPlaceAssise() : "sortie assis";
  }

  /* Gestion du changement de places à un arrêt.
   *
   * Remplir Autobus max assise et max debout - 1.
   * 
   * Changer un assis en debout
   * et un debout en assis.
   */
  public void testGestionChanger() {
    FauxPassager[] faux = {new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager()}; // 9

    Autobus bus = new Autobus(3, 5);

    //*************** Remplir **********************
    for (int i = 1; i < 4; i++) { //3
      bus.monteeDemanderAssis(faux[i]);
      faux[i].status = FauxPassager.ASSIS;
    }

    for (int i = 4; i <= 7; i++) { //4
      bus.monteeDemanderDebout(faux[i]);
      faux[i].status = FauxPassager.DEBOUT;
    }

    //************** Changer *************************
    bus.arretDemanderDebout(faux[2]);
    assert true == bus.aPlaceAssise() : "assis";
    assert false == bus.aPlaceDebout() : "debout";


    bus.arretDemanderAssis(faux[5]);
    assert false == bus.aPlaceAssise() : "assis";
    assert true == bus.aPlaceDebout() : "debout";
  }


  /* Interaction à la montée.
   *
   * Remplir un autobus debout puis assis.
   */
  public void testInteractionDemander() {
    FauxPassager[] faux = {new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager()}; //10

    Autobus bus = new Autobus(3, 5);

    //*********** Debout ******************************
    for (int i = 1; i < 6; i++) { //5
      bus.monteeDemanderDebout(faux[i]);
      assert 1 == faux[i].logs.size() 
	: "erreur nombre d'appels pour " + i;
      assert "changerEnDebout" == faux[i].getLastLog()
	: "mauvais appel pour " + i;
    }

    //********* Assis *******************************
    for (int i = 6; i < 9; i++) { //3
      bus.monteeDemanderAssis(faux[i]);
      assert 1 == faux[i].logs.size() 
	: "erreur nombre d'appels pour " + i;
      assert "changerEnAssis" == faux[i].getLastLog()
	: "mauvais appel pour " + i;
    }
  }


  /* Interaction pour un changement de place.
   * 
   * Changer un debout en assis puis d'assis à debout.
   */
  public void testInteractionChanger() {
    FauxPassager faux = new FauxPassager();

    Autobus bus = new Autobus(1, 1);

    bus.monteeDemanderDebout(faux);
    faux.status = FauxPassager.DEBOUT;

    bus.arretDemanderAssis(faux);
    assert 2 == faux.logs.size() : "erreur nombre d'appels";
    assert "changerEnAssis" == faux.getLastLog() : "mauvais appel";

    bus.arretDemanderDebout(faux);
    assert 3 == faux.logs.size() : "erreur nombre d'appels";
    assert "changerEnDebout" == faux.getLastLog() : "mauvais appel";
  }

  /* Interaction la sortie d'un passager.
   *
   * Demander des places assises et debout
   * et faire sortir un assis et un debout.
   */
  public void testInteractionSortie() {
    FauxPassager[] faux = {new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager()}; // 9

    Autobus bus = new Autobus(10, 20);

    //*************** Ajouter **********************
    bus.monteeDemanderAssis(faux[1]);
    faux[1].status = FauxPassager.ASSIS;

    bus.monteeDemanderDebout(faux[2]);
    faux[2].status = FauxPassager.DEBOUT;

    bus.monteeDemanderDebout(faux[3]);
    faux[3].status = FauxPassager.DEBOUT;

    bus.monteeDemanderAssis(faux[4]);
    faux[4].status = FauxPassager.ASSIS;

    bus.monteeDemanderDebout(faux[5]);
    faux[5].status = FauxPassager.DEBOUT;

    bus.monteeDemanderAssis(faux[6]);
    faux[6].status = FauxPassager.ASSIS;

    bus.monteeDemanderAssis(faux[7]);
    faux[7].status = FauxPassager.ASSIS;

    //***************** Sortir *************************
    bus.arretDemanderSortie(faux[6]);
    assert 2 == faux[6].logs.size() : "erreur nombre d'appels";
    assert "changerEnDehors" == faux[6].getLastLog() : "mauvais appel";

    bus.arretDemanderSortie(faux[2]);
    assert 2 == faux[2].logs.size() : "erreur nombre d'appels";
    assert "changerEnDehors" == faux[2].getLastLog() : "mauvais appel";
  }


  //********* Gestion des passagers ***************
  /** Interaction pour indiquer un arrêt au passager
   * L'autobus déclenche la methode nouvelArret
   * sur tous les passagers stockés. 
   * 
   * Ajouter quelques passager assis et debout.
   * Faire sortir des passagers assis et debout.
   */
  public void testArretSuivant() {
    FauxPassager[] faux = {new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager()}; // 9

    Autobus bus = new Autobus(99, 66);

    //********* Ajout des passagers **********
    for (int i = 1; i < 5; i++) {
      bus.monteeDemanderAssis(faux[i]);
      faux[i].status = FauxPassager.ASSIS;
    }

    for (int i = 5; i < 9; i++) {
      bus.monteeDemanderDebout(faux[i]);
      faux[i].status = FauxPassager.DEBOUT;
    }

    /*******************************************/
    bus.allerArretSuivant();
    
    for (int i = 1; i < 9; i++) {
      assert 2 == faux[i].logs.size() 
	: "erreur nombre d'appels pour " + i;
      assert "nouvelArret" == faux[i].getLastLog()
	: "mauvais appel pour " + i;
    }

    //******** Suppression de passagers ******************
    bus.arretDemanderSortie(faux[3]);
    bus.arretDemanderSortie(faux[6]);
    bus.arretDemanderSortie(faux[8]);

    bus.monteeDemanderDebout(faux[0]);
    faux[0].status = FauxPassager.DEBOUT;

    bus.allerArretSuivant();

    assert "nouvelArret" != faux[3].getLastLog()
      : "plus d'appel a nouvelArret:3";
    assert "nouvelArret" != faux[6].getLastLog() 
      : "plus d'appel a nouvelArret:6";
    assert "nouvelArret" != faux[8].getLastLog() 
      : "plus d'appel a nouvelArret:8";

    assert "nouvelArret" == faux[0].getLastLog() 
      : "plus d'appel a nouvelArret:0";

    for (int i = 1; i < 8; i++) {
      if (3 == i || 6 == i)
	continue;
      
      assert 3 == faux[i].logs.size() 
	: "erreur nombre d'appels pour " + i;
      assert "nouvelArret" == faux[i].getLastLog()
	: "mauvais appel pour " + i;
    }
  }


  // Vérifier les limites des places 
  public void testCasLimitePlaces() {
    try {
       Autobus bus1 = new Autobus (-10, 10);
   } catch (IllegalArgumentException e1) {
       try {
       Autobus bus2 = new Autobus (10, -10);
       } catch (IllegalArgumentException e2) {
       try {
           Autobus bus3 = new Autobus (-10, -10);
       } catch (IllegalArgumentException e3) { return; }
       assert false: "Nombre de places assises négatif et de places debout négatif"; }
       assert false: "Nombre de places debouts négatif"; }
   assert false: "Nombre de places assises négatif";
   }

  // Vérifier les positions des passagers
  public void testMonteePassagerPresent() {
   Autobus bus = new Autobus(10, 10);
   try {
       FauxPassager p1 = new FauxPassager();
       bus.monteeDemanderAssis(p1);
       bus.monteeDemanderAssis(p1);
   }
   catch (IllegalStateException e1) {
       try {
       FauxPassager p2 = new FauxPassager();
       bus.monteeDemanderDebout(p2);
       bus.monteeDemanderAssis(p2);
       }
       catch (IllegalStateException e2) {
       try {
           FauxPassager p3 = new FauxPassager();
           bus.monteeDemanderAssis(p3);
           bus.monteeDemanderDebout(p3);
       }
       catch (IllegalStateException e3) {
           try {
           FauxPassager p4 = new FauxPassager();
           bus.monteeDemanderDebout(p4);
           bus.monteeDemanderDebout(p4);
           }
           catch (IllegalStateException e4) { return; }
           assert false: "Un passager déjà debout peut monter et être debout";
       }
       assert false: "Un passager déjà assis peut monter et être debout";
       }
       assert false: "Un passager déjà debout peut monter et s'asseoir";
   }
   assert false: "Un passager déjà assis peut monter et s'asseoir";
   }
}
