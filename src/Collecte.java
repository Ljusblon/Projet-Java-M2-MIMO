package tec;

// Classe abstraite pour gérer les fichiers et tableaux
abstract class Collecte {
    private int numArret;
    private int nbEntrees;
    private int nbSorties;

    Collecte(){
        numArret = 0;
        nbEntrees = 0;
        nbSorties = 0;
    }

    final int getEntrees(){
        return nbEntrees;
    }

    final int getSorties(){
        return nbSorties;
    }

    final int getArret(){
        return numArret;
    }

    void uneEntree(){
        nbEntrees++;
    }

    void uneSortie(){
        nbSorties++;
    }

    // Méthode abstraite pour enregistrer les données dans le fichier data.txt
    abstract void enregistrerData();

    void changerArret(){
        enregistrerData();
        nbEntrees = 0;
        nbSorties = 0;
        numArret++;
    }
}
