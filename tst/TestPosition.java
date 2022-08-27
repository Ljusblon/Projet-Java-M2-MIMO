package tec;


/**
 * Nous avons commencé par tester si la création d’une nouvelle Position (pos), 
 * avec la méthode position(), créait bien une position dehors 
 * avec les méthodes estDehors, estAssis, estDebout et estInterieur.
 * De la même façon, nous avons testé si les méthodes debout(), assis() 
 * et dehors() initialisaient bien la Position à respectivement debout, 
 * assis et dehors. Chaque fonction de test contient donc 4 assert.
 */
class TestPosition {

    public void testInstanciation(){
        Position pos = Position.initialisationPosition();
        assert pos.estAssis() == false : "Nouveau ne devrait pas être assis";
        assert pos.estDebout() == false : "Nouveau ne devrait pas être debout";
        assert pos.estDehors() == true : "Nouveau devrait être dehors";
        assert pos.estInterieur() == false : "Nouveau ne devrait pas être à l'intérieur";
    }

    public void testAssis(){
        Position pos = Position.initialisationPosition();
        pos = pos.assis();
        assert pos.estAssis() == true : "Assis devrait être assis";
        assert pos.estDebout() == false : "Assis ne devrait pas être debout";
        assert pos.estDehors() == false : "Assis ne devrait pas être dehors";
        assert pos.estInterieur() == true : "Assis devrait être à l'intérieur";
    }

    public void testDebout(){
        Position pos = Position.initialisationPosition();
        pos = pos.debout();
        assert pos.estAssis() == false : "Debout ne devrait pas être assis";
        assert pos.estDebout() == true : "Debout devrait re debout";
        assert pos.estDehors() == false : "Debout ne devrait pas être dehors";
        assert pos.estInterieur() == true : "Debout devrait être à l'intérieur";
    }

    public void testDehors(){
        Position pos = Position.initialisationPosition();
        pos = pos.dehors();
        assert pos.estAssis() == false : "Dehors ne devrait pas être assis";
        assert pos.estDebout() == false : "Dehors ne devrait pas être debout";
        assert pos.estDehors() == true : "Dehors devrait être dehors";
        assert pos.estInterieur() == false : "Dehors ne devrait pas être à l'intérieur";
    }
}
