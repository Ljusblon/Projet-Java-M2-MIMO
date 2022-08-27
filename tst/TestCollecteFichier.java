package tec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class TestCollecteFichier {


    // Vérifier que le fichier est bien vide à l’initialisation
    public void testInstanciation(){
        CollecteFichier col = new CollecteFichier("build/data1");

	    BufferedReader buf = null;
        String line = "";

	    try{ 
		    buf = new BufferedReader(new FileReader("build/data1.txt") );
            line = buf.readLine();
        } catch (Exception e) {
        }
        assert line == null : "Le fichier n'est pas vide à l'initialisation";
    }


    // Vérifier que les entrées sont bien toutes comptées dans le fichier, au début du trajet et à la fin
    // Vérifier que les entrées sont bien comptées dans le fichier, avec l’arrêt correspondant
    public void testEntree(){
        CollecteFichier col = new CollecteFichier("build/data2");
        col.uneEntree();
        col.uneEntree();
        col.changerArret();
        col.changerArret();
        col.uneEntree();
        col.changerArret();

	    BufferedReader buf = null;
        String line = "";
        
        try{
            buf = new BufferedReader(new FileReader("build/data2.txt") );
            line = buf.readLine();
            } catch (Exception e) {
        }
        assert line.equals("Arrêt 0 : 2 Entrées, 0 Sorties") : "Les premieres entrées ne sont pas comptées";
        
        try{
            line = buf.readLine();
            } catch (Exception e) {
        }
        assert line.equals("Arrêt 1 : 0 Entrées, 0 Sorties") : "Des entrées sont comptées au mauvais endroit";
        
        try{
            line = buf.readLine();
            } catch (Exception e) {
        }
        assert line.equals("Arrêt 2 : 1 Entrées, 0 Sorties") : "La derniere entrée n'est pas comptée";
        
    }

    // Vérifier que les sorties sont bien toutes comptées dans le fichier, au début du trajet et à la fin
    // Vérifier que les sorties sont bien comptées dans le fichier, avec l’arrêt correspondant
    public void testSortie(){
        CollecteFichier col = new CollecteFichier("build/data3");
        col.uneSortie();
        col.changerArret();
        col.changerArret();
        col.uneSortie();
        col.uneSortie();
        col.changerArret();

        BufferedReader buf = null;
        String line = "";
        
        try{
            buf = new BufferedReader(new FileReader("build/data3.txt") );
            line = buf.readLine();
            } catch (Exception e) {
        }
        assert line.equals("Arrêt 0 : 0 Entrées, 1 Sorties") : "La premiere sortie n'est pas comptée";
        
        try{
            line = buf.readLine();
            } catch (Exception e) {
        }
        assert line.equals("Arrêt 1 : 0 Entrées, 0 Sorties") : "Des sorties sont comptées au mauvais endroit";
        
        try{
            line = buf.readLine();
            } catch (Exception e) {
        }
        assert line.equals("Arrêt 2 : 0 Entrées, 2 Sorties") : "Les dernieres sorties ne sont pas comptées";
        
    }
}
