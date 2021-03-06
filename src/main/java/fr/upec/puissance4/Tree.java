package fr.upec.puissance4;

import java.util.ArrayList;

import com.google.gson.Gson;

/**
 * Classe Tree du puissance 4 - Représente l'arbre
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */
public class Tree {
    private Node root;

    /**
     * Constructeur de Tree
     * @param root
     */
    public Tree(Node root) {
        this.root = root;
    }

    /**
     * Retourne la racine de l'arbre
     * @return Retourne la racine
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Créer l'arbre de possibilité et là retourne
     * @param game Le jeu
     * @param disk Le disque de l'IA
     * @return Retourne l'arbre
     */
    public static Tree createTreePossib(Game game, Coin disk, boolean minmax) {
        Gson gson = new Gson();
        String gameJSON = gson.toJson(game); //Traduction du jeu en JSON pour la copie
        Tree tree = new Tree(createTreePossibRec(gson, gameJSON, disk, game.getTurn(), minmax, game.getGrid().getWidth() - 1, 4)); //4 en left car 4 profondeurs (IA -> Joueur -> IA -> Joueur -> IA)
        return tree;
    }
    /**
     * Créer l'arbre avec chaque noeud une copie du jeu et calcul le score
     * @param gson Gson (pour la copie)
     * @param gameJSON Traduction du jeu en JSON
     * @param disk Le disque de l'IA
     * @param player Le joueur concerné par l'arbre
     * @param minmax Si le MinMax est activé
     * @param right Les possibilités sur une profondeur
     * @param left La profondeur
     * @return Le noeud créé
     */
    private static Node createTreePossibRec(Gson gson, String gameJSON, Coin disk, boolean player, boolean minmax, int right, int left) {
        Node node = new Node(gson.fromJson(gameJSON, Game.class)); //Copie via gson
        if(!node.getGame().isFull(right)){
            node.getGame().place(right, disk); //Simule un placement
        }
        if(minmax){
            node.computeMinMaxScore(node, disk);;
        } else {
            node.computeCustomScore(player);
        }

        if(right == 0){
            return node;
        } else if (left == 0){
            node.setRight(createTreePossibRec(gson, gameJSON, disk, player, minmax, right - 1, 0));
        } else {
            node.setLeft(createTreePossibRec(gson, gson.toJson(node.getGame()), Coin.invert(disk), player, minmax, node.getGame().getGrid().getWidth() - 1, left - 1));
            node.setRight(createTreePossibRec(gson, gameJSON, disk, player, minmax, right - 1, left));
        }
        return node;
    }

    /**
     * Vérifie s'il y a un score supérieur à 0 et renvoie un booléen
     * @param node Le noeud
     * @return Retourne un booléen
     */
    public boolean isBestScoreMax(Node node){
        if(node != null){
            if(node.getScore() > 0){
                return true;
            } else {
                return isBestScoreMax(node.getRight());
            }
        }
        return false;
    }

    /**
     * Trouve et retourne l'index du score le plus haut
     * @param node Le noeud
     * @param index L'index
     * @param max Le maximum atteint
     * @param indexMax L'index où le maximum a été atteint
     * @return Retourne l'index où le maximum a été atteint
     */
    public int bestScoreMax(Node node, int index, int max, int indexMax){
        if(node != null){
            if(node.getScore() > max){
                max = node.getScore();
                indexMax = index;
            }
            return bestScoreMax(node.getRight(), index - 1, max, indexMax);
        }
        return indexMax;
    }

    /**
     * Vérifie s'il y a un score inférieur à 0 et renvoie un booléen
     * @param node Le noeud
     * @return Retourne un booléen
     * @deprecated N'est pas utilisé à cause d'un bug où il se bloque lorsque l'IA perd (score négatif)
     */
    public boolean isWorstScoreMin(Node node){
        if(node != null){
            if(node.getScore() < 0){
                return true;
            } else {
                return isWorstScoreMin(node.getRight());
            }
        }
        return false;
    }

    /**
     * Trouve et retourne l'index du score le plus bas
     * @param node Le noeud
     * @param index L'index
     * @param min Le minimum atteint
     * @param indexMin L'index où le minimum a été atteint
     * @return Retourne l'index où le minimum a été atteint
     * @deprecated N'est pas utilisé à cause d'un bug où il se bloque lorsque l'IA perd (score négatif)
     */
    public int worstScoreMin(Node node, int index, int min, int indexMin){
        if(node != null){
            if(node.getScore() <= min){
                min = node.getScore();
                indexMin = index;
            }
            return worstScoreMin(node.getRight(), index - 1, min, indexMin);
        }
        return indexMin;
    }

    /**
     * Liste et renvoie la liste d'index des noeuds ayant pour score 0
     * @param node Le noeud
     * @param index L'index
     * @param list La liste d'index
     * @return Retourne la liste d'index
     */
    public ArrayList<Integer> listAllZero(Node node, int index, ArrayList<Integer> list){
        if(node != null){
            if(node.getScore() == 0){
                list.add(index);
                return listAllZero(node.getRight(), index - 1, list);
            }
            return listAllZero(node.getRight(), index - 1, list);
        }
        return list;
    }

    /**
     * Recherche le score d'un index
     * @param node Le noeud
     * @param index L'index
     * @param indexTBF L'index a trouver
     * @return Retourne le score
     */
    public int searchIndexScore(Node node, int index, int indexTBF){ //TBF = To Be Found
        if(index == indexTBF){
            return node.getScore();
        }
        return searchIndexScore(node.getRight(), index - 1, indexTBF);
    }
}
