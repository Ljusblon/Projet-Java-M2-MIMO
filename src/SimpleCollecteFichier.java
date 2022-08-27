import tec.*;

class SimpleCollecteFichier {

    /**
     * Affiche l'état des deux instances passées en paramètre.
     */
    static private void deboguerEtat (Transport t, Usager p) {
        System.out.println(p);
        System.out.println(t);
    }

    static public void main (String[] args) throws TecException{
        CollecteFichier coll = new CollecteFichier("build/data");
        Transport bus_mimo = new Greffon(new Autobus(2, 4), coll);

        Usager pierre = new MonteeFatigue("Pierre", 4, ArretPrudent.ARRET);
        Usager thomas = new MonteeSportif("Thomas", 4, ArretNerveux.ARRET);
        Usager jeanne = new MonteeRepos("Jeanne", 5, ArretCalme.ARRET);

        //0
        //System.out.println(bus_mimo);

        bus_mimo.allerArretSuivant();
        //1
        pierre.monterDans(bus_mimo);

        /*System.out.println(bus_mimo);
        System.out.println(pierre);*/

        bus_mimo.allerArretSuivant();
        //2
        thomas.monterDans(bus_mimo);

        /*System.out.println(bus_mimo);
        System.out.println(pierre);
        System.out.println(thomas);*/

        bus_mimo.allerArretSuivant();
        //3
        jeanne.monterDans(bus_mimo);

        /*System.out.println(bus_mimo);
        System.out.println(pierre);
        System.out.println(thomas);
        System.out.println(jeanne);*/

        bus_mimo.allerArretSuivant();
        //4
        /*System.out.println(bus_mimo);
        System.out.println(pierre);
        System.out.println(thomas);
        System.out.println(jeanne);*/

        bus_mimo.allerArretSuivant();
        //5
        /*System.out.println(bus_mimo);
        System.out.println(pierre);
        System.out.println(thomas);
        System.out.println(jeanne);*/

        bus_mimo.allerArretSuivant();

        System.out.println("\nCollecte Fichier\n");
    }
}