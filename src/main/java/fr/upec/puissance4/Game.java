package fr.upec.puissance4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Game du puissance 4 - Gérant la partie
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */
public class Game {
    private String fileName;
    private Player player1;
    private Player player2;
    private boolean turn; // A qui le tour? true = player 1 (Jaune), false = player 2 (Rouge)
    private Grid grid;

    /**
     * Constructeur de la partie
     * @param fileName Nom du fichier
     * @param player1 Joueur 1
     * @param player2 Joueur 2
     * @param grid Grille
     */
    public Game(String fileName, Player player1, Player player2, Grid grid) {
        this.fileName = fileName;
        this.player1 = player1;
        this.player2 = player2;
        this.turn = true;
        this.grid = grid;
    }

    /**
     * Constructeur de la partie
     * @see fr.upec.puissance4.File#read(java.nio.file.Path)
     */
    public Game() {
    }

    /**
     * Créée de la partie et renvoie la partie créée
     * @param fileName Nom du fichier si il existe
     * @param scanner Scanner d'entrée
     * @return Retourne la partie créée
     */
    public static Game createGame(Scanner scanner, String fileName) {
        System.out.println("=====Création de la partie=====");

        System.out.println("=====Création de la grille=====\nTaille de la grille, Largeur?");
        int width = isMinFour(scanner);
        System.out.println("Taille de la grille, Hauteur?");
        int height = isMinFour(scanner);
        Grid grid = new Grid(width, height);
        System.out.println("=====Grille créée=====");

        System.out.println("=====Création des joueurs=====");
        System.out.println("Nom du joueur 1? (IA/AI/ia/ai pour ordinateur)");
        String name1 = scanner.next();
        AI ai1 = null;
        if (name1.equals("IA") || name1.equals("AI") || name1.equals("ia") || name1.equals("ai")) {
            ai1 = AI.createAI(scanner);
        }
        Player player1 = new Player(new Coin(Coin.Disk.YELLOW), ai1, name1);

        System.out.println("Nom du joueur 2? (IA/AI/ia/ai pour ordinateur)");
        String name2 = scanner.next();
        AI ai2 = null;
        if (name2.equals("IA") || name2.equals("AI") || name2.equals("ia") || name2.equals("ai")) {
            ai2 = AI.createAI(scanner);
        }
        Player player2 = new Player(new Coin(Coin.Disk.RED), ai2, name2);
        System.out.println("=====Joueurs créés=====");

        System.out.println("=====Partie créée!=====");
        if(fileName.equals("")){
            String name = "partie-" + DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDateTime.now()) + ".json";
            Game game = new Game(name, player1, player2, grid);
            return game;
        } else {
            Game game = new Game(fileName, player1, player2, grid);
            return game;
        }
    }

    /**
     * Retourne la grille de jeu
     * @return Retourne la grille
     */
    public Grid getGrid() {
        return grid;
    }
    /**
     * Retourne la prochaine personne à jouer (le tour est décrit lors de la déclaration des variables)
     * @return Retourne un booléen
     */
    public boolean getTurn(){
        return turn;
    }
    /**
     * Retourne le joueur 1
     * @return Retourne le joueur 1
     */
    public Player getPlayer1() {
        return player1;
    }
    /**
     * Retourne le joueur 2
     * @return Retourne le joueur 2
     */
    public Player getPlayer2() {
        return player2;
    }
    /**
     * Retourne le nom du fichier de jeu
     * @return Retourne le nom
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Vérifie si l'entrée est bien un entier et le retourne
     * @param scanner Scanner d'entrée
     * @return Retourne l'entier
     */
    public static int isInteger(Scanner scanner){
        int integer = 0;
        while(scanner.hasNext()){
            if(scanner.hasNextInt()) {
                integer = scanner.nextInt();
                break;
            } else {
                System.out.println(Main.os.getError() + "Veuillez mettre un entier" + Main.os.getReset());
                scanner.next();
            }
        }
        return integer;
    }

    /**
     * Vérifie si l'entrée est supérieur ou égale à 4
     * @param scanner Scanner d'entrée
     * @return Retourne l'entier
     */
    public static int isMinFour(Scanner scanner){
        int integer = 0;
        while(true){
            integer = isInteger(scanner);
            if(integer >= 4){
                break;
            } else {
                System.out.println(Main.os.getError() + "Veuillez mettre un nombre égal ou supérieur à 4" + Main.os.getReset());
            }
        }
        return integer;
    }

    /**
     * Le prochain qui doit jouer
     * @param scanner Scanner d'entrée
     */
    public void turn(Scanner scanner){
        if(turn){ //Yellow
            if(player1.getAI() != null){ //IA
                player1.getAI().executeAI(this, player1.getDisk());
            } else { //Joueur
                System.out.println("C'est au tour de " + Main.os.getYellow() + player1.getName() + Main.os.getReset() +" de jouer, veuillez placer un disque");
                playing(scanner, player1.getDisk());
            }
            turn = false;
        } else { //Red
            if(player2.getAI() != null){ //IA
                player2.getAI().executeAI(this, player2.getDisk());
            } else { //Joueur
                System.out.println("C'est au tour de " + Main.os.getRed() + player2.getName() + Main.os.getReset() + " de jouer, veuillez placer un disque");
                playing(scanner, player2.getDisk());
            }
            turn = true;
        }
    }

    /**
     * Place un disque et décrémente le nombre de disque disponible si l'entier est entre 1 et la longueur et que la colonne n'est pas remplie
     * @param scanner Scanner d'entrée
     * @param disk Disque du joueur
     */
    public void playing(Scanner scanner, Coin disk){
        while(true){
            int index = isInteger(scanner);
            if(index >= 1 && index <= grid.getWidth()){
                if(!(isFull(index-1))){
                    place(index-1, disk);
                    grid.decrementNbCoin();
                    break;
                } else {
                    System.out.println(Main.os.getError() + "La colonne " + index + " est pleine, veuillez rechoisir votre colonne" + Main.os.getReset());
                }
            } else {
                System.out.println(Main.os.getError() + "Vous avez mis une valeur trop élevée ou erronée, veuillez rechoisir votre colonne entre 1 et " + grid.getWidth() + Main.os.getReset());
            }
        }
    }

    /**
     * Vérifie si la colonne est pleine 
     * @param index Index de la colonne
     * @return Retourne un booléen
     */
    public boolean isFull(int index){
        boolean is_full = true;;
        for (Coin coin : grid.getGrid().get(index)) {
            if(coin.getDisk() == Coin.Disk.VOID){
                return false;
            }
        }
        return is_full;
    }

    /**
     * Place un disque sur la colonne choisi
     * @param index Index de la colonne
     * @param disk Disque du joueur
     */
    public void place(int index, Coin disk) {
        for (Coin coin : grid.getGrid().get(index)){
            if(coin.getDisk() == Coin.Disk.VOID){
                coin.setDisk(disk.getDisk());
                break;
            }
        }
    }

    /**
     * Vérifie la grille s'il y a un gagnant ou non
     * @return Retourne le gagnant ou non
     */
    public int verify(){
        int[] verify = {verifyHorizontal(), verifyVertical(), verifyDiagAcc(), verifyDiagDes()};
        int max = 0;
        for (int i : verify) {
            if(max < i) {
                max = i;
            }
        }
        return max;
    }
    /**
     * Vérifie la grille à la verticale
     * @return Retourne le gagnant ou non
     */
    private int verifyVertical(){
        int winner = 0;
        for(ArrayList<Coin> vert : grid.getGrid()){
            int red = 0;
            int yellow = 0;
            for(Coin coin : vert){
                switch (coin.getDisk()) {
                    case RED:
                        red++;
                        yellow = 0;
                        break;
                    case YELLOW:
                        red = 0;
                        yellow++;
                        break;
                    default: break;
                }
                if(yellow == 4){
                    winner = 1;
                    break;
                }
                if(red == 4){
                    winner = 2;
                    break;
                } 
            }
        }
        return winner;
    }
    /**
     * Vérifie la grille à l'horizontale
     * @return Retourne le gagnant ou non
     */
    private int verifyHorizontal(){
        int winner = 0;
        for(int i = 0; i < grid.getGrid().get(0).size()-1; i++){
            int red = 0;
            int yellow = 0;
            for(int j = 0; j < grid.getGrid().size(); j++){
                if(grid.getGrid().get(j).get(i).getDisk() == Coin.Disk.RED){
                    red++;
                    yellow = 0;
                }
                if(grid.getGrid().get(j).get(i).getDisk() == Coin.Disk.YELLOW){
                    red = 0;
                    yellow++;
                }
                if(grid.getGrid().get(j).get(i).getDisk() == Coin.Disk.VOID){
                    red = 0;
                    yellow = 0;
                }
                if(yellow == 4){
                    winner = 1;
                    break;
                }
                if(red == 4){
                    winner = 2;
                    break;
                }
            }
        }
        return winner;
    }
    /**
     * Vérifie la grille à la diagonale accendante
     * @return Retourne le gagnant ou non
     */
    private int verifyDiagAcc(){
        int winner = 0;
        for (int i = 0; i <= grid.getGrid().get(i).size()-4; i++) { 
            for (int j = 0; j <= grid.getGrid().size()-4; j++) {
                int red = 0;
                int yellow = 0;
                for (int k = 0; k < 4; k++) {
                    if(grid.getGrid().get(j+k).get(i+k).getDisk() == Coin.Disk.RED){
                        red++;
                        yellow = 0;
                    }
                    if(grid.getGrid().get(j+k).get(i+k).getDisk() == Coin.Disk.YELLOW){
                        red = 0;
                        yellow++;
                    }
                    if(yellow == 4){
                        winner = 1;
                        break;
                    }
                    if(red == 4){
                        winner = 2;
                        break;
                    }
                }
            }
        }
        return winner;
    }
    /**
     * Vérifie la grille à la diagonale descendante
     * @return Retourne le gagnant ou non
     */
    private int verifyDiagDes(){
        int winner = 0;
        for (int i = 3; i < grid.getGrid().get(0).size(); i++) { 
            for (int j = 0; j <= grid.getGrid().size()-4; j++) {
                int red = 0;
                int yellow = 0;
                for (int k = 0; k < 4; k++) {
                    if(grid.getGrid().get(j+k).get(i-k).getDisk() == Coin.Disk.RED){
                        red++;
                        yellow = 0;
                    }
                    if(grid.getGrid().get(j+k).get(i-k).getDisk() == Coin.Disk.YELLOW){
                        red = 0;
                        yellow++;
                    }
                    if(yellow == 4){
                        winner = 1;
                        break;
                    }
                    if(red == 4){
                        winner = 2;
                        break;
                    }
                }
            }
        }
        return winner;
    }
}
