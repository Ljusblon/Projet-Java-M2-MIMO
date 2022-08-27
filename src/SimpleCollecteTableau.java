import tec.*;

import java.util.*;

class SimpleCollecteTableau {

    /**
     * Affiche l'état des deux instances passées en paramètre.
     */
    static private void deboguerEtat (Transport t, Usager p) {
        System.out.println(p);
        System.out.println(t);
    }

    static public void main (String[] args) throws TecException{
        System.out.println("\nCollecte Tableau\n");

        CollecteTableau coll = new CollecteTableau();
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
        
        ArrayList<Integer> Entrees = coll.getTableEntrees();
        ArrayList<Integer> Sorties = coll.getTableSorties();
        for (int i=0; i<6; i++){
            System.out.println("Arrêt " + i + " : " + Entrees.get(i) + " Entrées, " + Sorties.get(i) + " Sorties");
        }
        //System.out.println("Entrees : " + Entrees.get(0) + Entrees.get(1) + Entrees.get(2) + Entrees.get(3) + Entrees.get(4) + Entrees.get(5));
        //System.out.println("Sorties : " + Sorties.get(0) + Sorties.get(1) + Sorties.get(2) + Sorties.get(3) + Sorties.get(4) + Sorties.get(5));
    }
}