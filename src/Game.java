import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Game du puissance 4 - Gérant la partie
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */

public class Game {
    private Player player1;
    private Player player2;
    private boolean turn; // A qui le tour? true = player 1 (Jaune), false = player 2 (Rouge)
    private Grid grid;

    /**
     * Constructeur de la partie
     * @param player1 Joueur 1
     * @param player2 Joueur 2
     * @param grid Grille
     */
    public Game(Player player1, Player player2, Grid grid) {
        this.player1 = player1;
        this.player2 = player2;
        this.turn = true;
        this.grid = grid;
    }

    /**
     * Constructeur de la partie, utile pour {@link #File.read(String file)}
     */
    public Game() {
    }

    /**
     * Créée de la partie et renvoie la partie créée
     * @param scanner Scanner d'entrée
     * @return Retourne la partie créée
     */
    public static Game createGame(Scanner scanner){
        System.out.println("Création de la partie...");

        System.out.println("Création de la grille\nTaille de la grille, Largeur?");
        int width = isInteger(scanner);
        System.out.println("Taille de la grille, Hauteur?");
        int height = isInteger(scanner);
        Grid grid = new Grid(width, height);
        System.out.println("Grille créée");

        System.out.println("Création des joueurs");
        System.out.println("Nom du joueur 1?");
        Player player1 = new Player(new Coin(Coin.Disk.YELLOW), scanner.next());

        System.out.println("Nom du joueur 2?");
        Player player2 = new Player(new Coin(Coin.Disk.RED), scanner.next());
        System.out.println("Joueurs créés");

        Game game = new Game(player1, player2, grid);
        System.out.println("Partie créée!");

        return game;
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
                System.out.println("Veuillez mettre un entier");
                scanner.next();
            }
        }
        return integer;
    }

    /**
     * Le prochain qui doit jouer
     * @param scanner Scanner d'entrée
     */
    public void turn(Scanner scanner){
        if(turn){
            System.out.println("C'est au tour de " + player1.getName() + " de jouer, veuillez placer un disque");
            playing(scanner ,player1.getDisk());
            turn = false;
        } else {
            System.out.println("C'est au tour de " + player2.getName() + " de jouer, veuillez placer un disque");
            playing(scanner, player2.getDisk());
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
                    grid.decrementnbCoin();
                    break;
                } else {
                    System.out.println("La colonne " + index + " est pleine, veuillez rechoisir votre colonne");
                }
            } else {
                System.out.println("Vous avez mis une valeur trop élevée ou erronée, veuillez rechoisir votre colonne entre 1 et " + grid.getWidth());
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
     * WIP
     */
    public void verify(){
        verify_vertical();
        verify_horizontal();
        //verify_diag_acc();
        //verify_diag_des();
    }
    private int verify_vertical(){
        int winner = 0;
        for(ArrayList<Coin> vert : grid.getGrid()){ //Vérification verticale
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
                    System.out.println("Jaune gagne!");
                    winner = 1;
                }
                if(red == 4){
                    System.out.println("Rouge gagne!");
                    winner = 2;
                } 
            }
        }
        return winner;
    }
    private int verify_horizontal(){
        int winner = 0;
        for(int i = 0; i < grid.getGrid().get(i).size(); i++){ //Vérification horizontale
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
                if(yellow == 4){
                    System.out.println("Jaune gagne!");
                    winner = 1;
                }
                if(red == 4){
                    System.out.println("Rouge gagne!");
                    winner =2;
                }
            }
        }
        return winner;
    }
    /*private int verify_diag_acc(){ //Vérification diagonale croissante
        for (int i = 0; i < grid.getGrid().get(i).size()-4; i++) { 
            for (int j = 0; j < grid.getGrid().size()-4; j++) {
                
            }
        }
    }
    private int verify_diag_des(){

    }*/
}
