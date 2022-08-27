package tec;

class TestCollecteTableau {

    // Vérifier que le tableau est bien vide à l’initialisation, pour les entrées et sorties
    public void testInstanciation(){
        CollecteTableau col = new CollecteTableau();
        assert col.getTableEntrees().size() == 0 : "Liste des entrées non vide";
        assert col.getTableSorties().size() == 0 : "Liste des entrées non vide";
    }

    // Vérifier que les entrées sont bien toutes comptées dans le tableau, au début du trajet et à la fin
    // Vérifier que les entrées sont bien comptées dans le tableau, avec l’arrêt correspondant
    public void testEntree(){
        CollecteTableau col = new CollecteTableau();
        col.uneEntree();
        col.uneEntree();
        col.changerArret();
        col.changerArret();
        col.uneEntree();
        col.changerArret();
        assert col.getTableEntrees().get(0) == 2 : "Les premieres entrées ne sont pas comptées";
        assert col.getTableEntrees().get(1) == 0 : "Des entrées sont comptées au mauvais endroit";
        assert col.getTableEntrees().get(2) == 1 : "La derniere entrée n'est pas comptée";
    }

    // Vérifier que les sorties sont bien toutes comptées dans le tableau, au début du trajet et à la fin
    // Vérifier que les sorties sont bien comptées dans le tableau, avec l’arrêt correspondant
    public void testSortie(){
        CollecteTableau col = new CollecteTableau();
        col.uneSortie();
        col.changerArret();
        col.changerArret();
        col.uneSortie();
        col.uneSortie();
        col.changerArret();
        assert col.getTableSorties().get(0) == 1 : "La premiere sortie n'est pas comptée";
        assert col.getTableSorties().get(1) == 0 : "Des sorties sont comptées au mauvais endroit";
        assert col.getTableSorties().get(2) == 2 : "Les dernieres sorties ne sont pas comptées";
    }
}
