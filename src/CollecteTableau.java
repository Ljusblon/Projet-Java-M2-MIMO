package tec;

import java.util.*;

// Classe pour enregistrer les informations dans un tableau
public class CollecteTableau extends Collecte{
    // Les attributs propres à cette classe
    private ArrayList<Integer> Entrees;
    private ArrayList<Integer> Sorties;

    public ArrayList<Integer> getTableEntrees(){
        return Entrees;
    }

    public ArrayList<Integer> getTableSorties(){
        return Sorties;
    }

    // Constructeur
    public CollecteTableau(){
        super();
        Entrees = new ArrayList<Integer>();
        Sorties = new ArrayList<Integer>();
    }

    final void enregistrerData(){ 
        Entrees.add(getEntrees());
        Sorties.add(getSorties());
    }
}