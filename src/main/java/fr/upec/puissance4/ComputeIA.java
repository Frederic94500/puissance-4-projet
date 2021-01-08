package fr.upec.puissance4;

/**
 * Classe ComputeIA du puissance 4 - Calcul des noeuds
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */
public class ComputeIA {
    /**
     * Calcul le score d'un noeud et de ces sous-jacents puis enregistre le total dans le noeud 
     * @param node Le noeud
     */
    public static void computeCustomScore(Node node){
        if(node != null){
            node.setScore(node.getScore() + computeCustomScoreRec(node.getLeft()));
            computeCustomScore(node.getRight()); // Calcul pour le prochain droite
        }
    }
    /**
     * Calcul le score d'un noeud et retourne le score
     * @param node Le noeud
     * @return Retourne le score
     */
    private static int computeCustomScoreRec(Node node) {
        if (node != null) {
            return node.getScore() + computeCustomScoreRec(node.getLeft()) + computeCustomScoreRec(node.getRight());
        }
        return 0;
    }

    /**
     * Récupère les scores des noeuds sous-jacents puis enregistre dans le noeud du profondeur 0
     * @param node Le noeud
     * @param right Le noeud droite
     * @param left Le noeud gauche
     */
    public static void computeMinMaxScore(Node node, int right, int left){ //right: 2 = max, 1 = min
        if(node != null){
            if(left == 2){
                computeMinMaxScore(node.getLeft(), right, left - 1);
                computeMaxScore(node);
                computeMinMaxScore(node.getRight(), right - 1, left);
            } else if(left == 1) {
                computeMinScore(node);
                computeMinMaxScore(node.getRight(), right - 1, left);
            }
        }
    }
    /**
     * Récupère le noeud ayant la plus faible valeur et stock sur le noeud désigné
     * @param node Le noeud 
     */
    private static void computeMinScore(Node node) {
        int min = 100;
        Node nodeGet = node.getLeft();
        while(nodeGet != null){
            if(nodeGet.getScore() < min){
                min = nodeGet.getScore();
            }
            nodeGet = nodeGet.getRight();
        }
        node.setScore(min);
    }
    /**
     * Récupère le noeud ayant la plus grande valeur et stock sur le noeud désigné
     * @param node Le noeud
     */
    private static void computeMaxScore(Node node) {
        int max = 0;
        Node nodeGet = node.getLeft();
        while(nodeGet != null){
            if(nodeGet.getScore() > max){
                max = nodeGet.getScore();
            }
            nodeGet = nodeGet.getRight();
        }
        node.setScore(max);
    }
}
