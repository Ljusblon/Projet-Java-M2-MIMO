package tec;

import java.io.Writer;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CollecteFichier extends Collecte {
    private String fileName;
    FileWriter file;

    public CollecteFichier(String name) {
        super();
        fileName = name;

        // Créer ou réinitialiser le fichier
        try {
            file = new FileWriter(fileName + ".txt");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                file.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Méthode pour enregistrer les informations dans le fichier data.txt
    final void enregistrerData(){
        try {
            file = new FileWriter(fileName + ".txt", true);
            PrintWriter p = new PrintWriter(file);
    
            p.println("Arrêt " + getArret() + " : " +
                        getEntrees() + " Entrées, " +
                        getSorties() + " Sorties");
    
            p.flush();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                file.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}