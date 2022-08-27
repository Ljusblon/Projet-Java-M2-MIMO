import tec.*;

class Simple {

    /**
     * Affiche l'état des deux instances passées en paramètre.
     */
    static private void deboguerEtat (Transport t, Usager p) {
        System.out.println(p);
        System.out.println(t);
    }

    static public void main (String[] args) throws TecException{
        Transport bus_mimo = new Autobus(2, 4);

        Usager pierre = new MonteeFatigue("Pierre", 4, ArretPrudent.ARRET);
        Usager thomas = new MonteeSportif("Thomas", 4, ArretNerveux.ARRET);
        Usager jeanne = new MonteeRepos("Jeanne", 5, ArretCalme.ARRET);

        //Départ de l'autobus
        System.out.println(bus_mimo);

        bus_mimo.allerArretSuivant();

        //1 arrêt
        pierre.monterDans(bus_mimo);

        System.out.println(bus_mimo);
        System.out.println(pierre);

        bus_mimo.allerArretSuivant();

        //2 arrêt
        thomas.monterDans(bus_mimo);

        System.out.println(bus_mimo);
        System.out.println(pierre);
        System.out.println(thomas);

        bus_mimo.allerArretSuivant();

        //3 arrêt
        jeanne.monterDans(bus_mimo);

        System.out.println(bus_mimo);
        System.out.println(pierre);
        System.out.println(thomas);
        System.out.println(jeanne);

        bus_mimo.allerArretSuivant();

        //4 arrêt
        System.out.println(bus_mimo);
        System.out.println(pierre);
        System.out.println(thomas);
        System.out.println(jeanne);

        bus_mimo.allerArretSuivant();
        
        //5 arrêt
        System.out.println(bus_mimo);
        System.out.println(pierre);
        System.out.println(thomas);
        System.out.println(jeanne);
    }
}
