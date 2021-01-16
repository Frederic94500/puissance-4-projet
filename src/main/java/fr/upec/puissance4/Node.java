package fr.upec.puissance4;

import java.util.ArrayList;

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
        this.score = 0;
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
    public void computeCustomScore(boolean player){
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

    /**
     * Calcul le score d'un noeud par l'alignement de disque
     * @param node Le noeud
     * @param disk Le disque du joueur
     */
    public void computeMinMaxScore(Node node, Coin disk){
        score = 0;
        //Verticale
        int index = 0;
        for(ArrayList<Coin> vert : game.getGrid().getGrid()){
            if(!node.getGame().isFull(index)){
                int yourDisk = 0;
                for(Coin coin : vert){
                    if(coin == disk){
                        yourDisk++;
                    } else if(coin != disk){
                        if(yourDisk >= 3){
                            score += yourDisk;
                            yourDisk = 0;
                        }
                    }
                }
                if(yourDisk >= 3){
                    score += yourDisk;
                }
            }
            index++;
        }
        //Horizontale
        index = 0;
        for(int i = 0; i < node.getGame().getGrid().getGrid().get(0).size()-1; i++){
            int yourDisk = 0;
            if(!node.getGame().isFull(index)){
                for(int j = 0; j < node.getGame().getGrid().getGrid().size(); j++){
                    if(node.getGame().getGrid().getGrid().get(j).get(i).getDisk() == disk.getDisk()){
                        yourDisk++;
                    } else if(node.getGame().getGrid().getGrid().get(j).get(i).getDisk() == Coin.Disk.VOID){
                        if(yourDisk >= 3){
                            score += yourDisk;
                            yourDisk = 0;
                        }
                    } else {
                        yourDisk = 0;
                    }
                }
                if(yourDisk >= 3){
                    score += yourDisk;
                }
            }
            index++;
        }
        //Diagonale ascendante
        for (int i = 0; i <= node.getGame().getGrid().getGrid().get(i).size()-4; i++) { 
            for (int j = 0; j <= node.getGame().getGrid().getGrid().size()-4; j++) {
                int yourDisk = 0;
                for (int k = 0; k < 4; k++) {
                    if(node.getGame().getGrid().getGrid().get(j+k).get(i+k).getDisk() == disk.getDisk()){
                        yourDisk++;
                    } else if(node.getGame().getGrid().getGrid().get(j+k).get(i+k).getDisk() != disk.getDisk()){
                        if(yourDisk >= 3){
                            score += yourDisk;
                            yourDisk = 0;
                        }
                    }
                }
                if(yourDisk >= 3){
                    score += yourDisk;
                }
            }
        }
        //Diagonale descendante
        for (int i = 3; i < node.getGame().getGrid().getGrid().get(0).size(); i++) { 
            for (int j = 0; j <= node.getGame().getGrid().getGrid().size()-4; j++) {
                int yourDisk = 0;
                for (int k = 0; k < 4; k++) {
                    if(node.getGame().getGrid().getGrid().get(j+k).get(i-k).getDisk() == disk.getDisk()){
                        yourDisk++;
                    }
                    if(node.getGame().getGrid().getGrid().get(j+k).get(i-k).getDisk() != disk.getDisk()){
                        if(yourDisk >= 3){
                            score += yourDisk;
                            yourDisk = 0;
                        }
                    }
                }
                if(yourDisk >= 3){
                    score += yourDisk;
                }
            }
        }
    }
}
