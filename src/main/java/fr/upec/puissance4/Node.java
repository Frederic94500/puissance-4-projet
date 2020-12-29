package fr.upec.puissance4;

public class Node {
    private Game game;
    private int score;
    private Node right; //Droite = les possibilités
    private Node left; //Gauche = le choix de l'autre joueur

    public Node(Game game){
        this.game = game;
        this.score = -1;
        this.right = null;
        this.left = null;
    }

    public Game getGame() {
        return game;
    }
    public Node getRight() {
        return right;
    }
    public Node getLeft() {
        return left;
    }
    public int getScore() {
        return score;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
