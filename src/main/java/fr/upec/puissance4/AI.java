package fr.upec.puissance4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe IA/AI du puissance 4 - Gère le joueur ordinateur
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */
public class AI {
    private int type;

    /**
     * Constructeur de IA
     * @param type Le type de IA (0 = Bogo, 1 = Min/Max)
     */
    public AI(int type){
        this.type = type;
    }

    /**
     * Crée le joueur IA avec son type de IA
     * @param scanner Scanner d'entrée
     * @return Retourne le type d'IA
     */
    public static AI createAI(Scanner scanner){
        while(true){
            System.out.println("Le type de IA?\n0 = BogoIA (Naif), 1 = Min/Max, 2 = Custom?");
            int integer = Game.isInteger(scanner);
            if(integer >= 0 && integer <= 2){
                return new AI(integer);
            } else {
                System.out.println(Main.os.getError() + "Veuillez entrer un nombre entre 0 et 2" + Main.os.getReset());
            }
        }
    }

    /**
     * Execute l'IA lors de son tour en fonction de son type
     * @param game Le jeu
     * @param disk Le disque du IA
     */
    public void executeAI(Game game, Coin disk){
        switch (type) {
            case 0:
                bogo(game, disk);
                break;
            case 1:
                minMax(game, disk);
                break;
            case 2:
                customIA(game, disk);
                break;
        }
        game.getGrid().decrementNbCoin();
    }

    /**
     * Annonce où l'IA a placé son disque
     * @param game Le jeu
     * @param disk Le disque du IA
     * @param index La colonne choisie par l'IA
     */
    private void printPlace(Game game, Coin disk, int index, String score){
        String s = "";
        switch (disk.getDisk()) {
            case YELLOW:
                s += Main.os.getYellow() + "L'IA a placé sur la colonne " + (index + 1) + " " + score + Main.os.getReset();
                break;
            case RED:
                s += Main.os.getRed() + "L'IA a placé sur la colonne " + (index + 1) + " " + score + Main.os.getReset();
                break;
            case VOID:
                break;
        }
        System.out.println(s);
    }

    /**
     * L'IA place l'aléatoirement un disque sur une colonne
     * @param game Le jeu
     * @param disk Le disque de l'IA
     */
    private void bogo(Game game, Coin disk) {
        while(true){
            int random = (int)(Math.random() * game.getGrid().getWidth());
            if(!game.isFull(random)){
                game.place(random, disk);
                printPlace(game, disk, random, "");
                break;
            }
        }
    }

    private void minMax(Game game, Coin disk){
        int index;

        Tree tree = Tree.createTreePossib(game, disk, true);
        ComputeIA.computeMinMaxScore(tree.getRoot(), game.getGrid().getWidth() - 1, 2);
        index = tree.bestScoreMax(tree.getRoot(), game.getGrid().getWidth() - 1, 0, 100);

        game.place(index, disk);
        printPlace(game, disk, index, "(score: "+ Integer.toString(tree.searchIndexScore(tree.getRoot(), game.getGrid().getWidth() - 1, index)) + ")");
    }

    /**
     * L'IA place un disque en fonction de l'arbre de possibilités.
     * @param game Le jeu
     * @param disk le disque de l'IA
     */
    private void customIA(Game game, Coin disk) {
        int index;

        Tree tree = Tree.createTreePossib(game, disk, false);
        ComputeIA.computeCustomScore(tree.getRoot());
        
        if (tree.isBestScoreMax(tree.getRoot())){ //Vérifie s'il y a un score > 0
            index = tree.bestScoreMax(tree.getRoot(), game.getGrid().getWidth() - 1, 0, 100);
        } /*else if (tree.isWorstScoreMin(tree.getRoot())){ //Vérifie s'il y a un score < 0 //Ne fonctionne pas
            index = tree.worstScoreMin(tree.getRoot(), game.getGrid().getWidth() - 1, 1000, 100);
        }*/ else {
            ArrayList<Integer> indexListZero = tree.listAllZero(tree.getRoot(), game.getGrid().getWidth() - 1, new ArrayList<Integer>());
            while(true){
                index = indexListZero.get((int)(Math.random() * (indexListZero.size())));
                if(!game.isFull(index)){
                    break;
                }
            }
        }
        game.place(index, disk);
        printPlace(game, disk, index, "(score: "+ Integer.toString(tree.searchIndexScore(tree.getRoot(), game.getGrid().getWidth() - 1, index)) + ")");
    }
}
