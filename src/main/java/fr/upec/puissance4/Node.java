package fr.upec.puissance4;

/**
 * Classe Node du puissance 4 - Représente un noeud de l'arbre
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */
public class Node {
    private Game game;
    private int score;
    private Node right; //Droite = les possibilités
    private Node left; //Gauche = le choix de l'autre joueur (profondeur)

    /**
     * Constructeur de Node
     * @param game Le jeu
     */
    public Node(Game game){
        this.game = game;
        this.score = -1;
        this.right = null;
        this.left = null;
    }

    /**
     * Retourne le jeu simulé
     * @return Retourne le jeu
     */
    public Game getGame() {
        return game;
    }
    /**
     * Retourne le noeud droite
     * @return Retourne le noeud droite
     */
    public Node getRight() {
        return right;
    }
    /**
     * Retourne le noeud gauche
     * @return Retourne le noeud gauche
     */
    public Node getLeft() {
        return left;
    }
    /**
     * Retourne le score du noeud
     * @return Retourne le score
     */
    public int getScore() {
        return score;
    }

    /**
     * Modifie le noeud gauche
     * @param left Nouveau noeud gauche
     */
    public void setLeft(Node left) {
        this.left = left;
    }
    /**
     * Modifie le noeud droite
     * @param right Nouveau noeud droite
     */
    public void setRight(Node right) {
        this.right = right;
    }
    /**
     * Modifie le score du noeud
     * @param score Nouveau score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Calcul le score en fonction du joueur et en fonction du résultat de verify()
     * @param player
     * @see fr.upec.puissance4.Game#verify()
     */
    public void computeScore(boolean player){
        if(player){
            switch (game.verify()) {
                case 0:
                    score = 0;
                    break;
                case 1:
                    score = 100;
                    break;
                case 2:
                    score = -10;
                    break;
            }
        } else {
            switch (game.verify()) {
                case 0:
                    score = 0;
                    break;
                case 1:
                    score = -10;
                    break;
                case 2:
                    score = 100;
                    break;
            }
        }
    }
}
