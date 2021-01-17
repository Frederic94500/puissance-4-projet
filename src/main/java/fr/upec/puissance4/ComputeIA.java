package fr.upec.puissance4;

/**
 * Classe ComputeIA du puissance 4 - Calcul des noeuds par l'IA
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
     * @param depth La profondeur
     */
    public static void computeMinMaxScore(Node node, int depth){ //depth: paire = max, impaire = min (gauche)
        if(depth == 0 || node != null){
            if((depth % 2) == 0){
                computeMinMaxScore(node.getLeft(), depth - 1);
                node.setScore(computeMaxScore(node, 0));
            } else {
                computeMinMaxScore(node.getLeft(), depth);
                node.setScore(computeMinScore(node, Integer.MAX_VALUE));
            }
            computeMinMaxScore(node.getRight(), depth);
        }
    }
    /**
     * Récupère le noeud ayant la plus faible valeur et stock sur le noeud désigné
     * @param node Le noeud 
     * @param min Le score minimum
     * @return Retourne le score min
     */
    private static int computeMinScore(Node node, int min) {
        if(node != null){
            if(node.getScore() < min){
                return computeMinScore(node.getRight(), node.getScore());
            }
            return computeMinScore(node.getRight(), min);
        }
        return min;
    }
    /**
     * Récupère le noeud ayant la plus grande valeur et stock sur le noeud désigné
     * @param node Le noeud
     * @param max Le score maximum
     * @return Retourne le score max
     */
    private static int computeMaxScore(Node node, int max) {
        if(node != null){
            if(node.getScore() > max){
                return computeMaxScore(node.getRight(), node.getScore());
            }
            return computeMaxScore(node.getRight(), max);
        }
        return max;
    }
}
