package fr.upec.puissance4;

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
     * @param type Le type de IA (0 = Bogo, 1 = Min/Max, 2 - α/β)
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
            System.out.println("0 = BogoIA (Naif), 1 = Min/Max, 2 = α/β (Alpha/Beta)?");
            int integer = Game.isInteger(scanner);
            if(integer >= 0 && integer <= 2){
                return new AI(integer);
            } else {
                System.out.println(Main.os.getError() + "Veuillez entrer un nombre entre 0 et 2" + Main.os.getReset());
            }
        }
    }

    /**
     * Execute l'IA lors de son tour
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
                alphaBeta(game, disk);
                break;
        }
    }

    /**
     * Annonce où l'IA a placé son disque
     * @param game Le jeu
     * @param disk Le disque du IA
     * @param index La colonne choisie par l'IA
     */
    private void printPlace(Game game, Coin disk, int index){
        String s = "";
        switch (disk.getDisk()) {
            case YELLOW:
                s += Main.os.getYellow() + "L'IA a placé sur la colonne " + (index + 1) + Main.os.getReset();
                break;
            case RED:
                s += Main.os.getRed() + "L'IA a placé sur la colonne " + (index + 1) + Main.os.getReset();
                break;
            case VOID:
                break;
        }
        System.out.println(s);
    }

    /**
     * L'IA place l'aléatoirement un disque sur une colonne
     * @param game Le jeu
     * @param disk Le disque du IA
     */
    private void bogo(Game game, Coin disk) {
        while(true){
            int random = (int)(Math.random() * game.getGrid().getWidth());
            if(!game.isFull(random)){
                game.place(random, disk);
                game.getGrid().decrementNbCoin();
                printPlace(game, disk, random);
                break;
            }
        }
    }

    /**
     * WIP
     * @param game
     * @param disk
     */
    public void minMax(Game game, Coin disk) {

    }

    /**
     * WIP
     * @param game
     * @param disk
     */
    public void alphaBeta(Game game, Coin disk) {

    }
}
