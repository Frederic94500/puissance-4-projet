import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private boolean turn; // A qui le tour? true = player 1 (Jaune), false = player 2 (Rouge)
    private Grid grid;

    public Game(Player player1, Player player2, Grid grid) {
        this.player1 = player1;
        this.player2 = player2;
        this.turn = true;
        this.grid = grid;
    }

    public Game() {
    }

    public static Game createGame(){
        System.out.println("Création de la partie...");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Création de la grid\nTaille de la grid, Largeur?");
        int width = scanner.nextInt();
        System.out.println("Taille de la grid, Hauteur?");
        int height = scanner.nextInt();
        Grid grid = new Grid(width, height);
        System.out.println("Grille créée");

        int nbDiskGrid = width * height;

        System.out.println("Création des joueurs");
        System.out.println("Nom du joueur 1?");
        Coin coin = new Coin();
        coin.setDisk(Coin.Disk.YELLOW);
        Player player1 = new Player(coin, scanner.next(), nbDiskGrid/2);
        System.out.println("Nom du joueur 2?");
        coin.setDisk(Coin.Disk.RED);
        Player player2 = new Player(coin, scanner.next(), nbDiskGrid/2);
        System.out.println("Joueurs créés");

        Game game = new Game(player1, player2, grid);
        System.out.println("Partie créée!");

        scanner.close();
        return game;
    }

    public Grid getGrid() {
        return grid;
    }
    public boolean getTurn(){
        return turn;
    }

    public void turn(){
        Scanner scanner = new Scanner(System.in);
        if(turn){
            System.out.println("C'est au tour de " + player1.getName() + " de jouer, veuillez placer un disque");
            playing(scanner, player1.getDisk());
            turn = false;
        } else {
            System.out.println("C'est au tour de " + player2.getName() + " de jouer, veuillez placer un disque");
            playing(scanner, player2.getDisk());
            turn = true;
        }
        scanner.close();
    }

    public void playing(Scanner scanner, Coin disk){
        while(true){
            try{
                int index = scanner.nextInt();
                scanner.nextLine();
                if(!(is_full(index-1))){
                    place(index-1, disk);
                    break;
                } else {
                    System.out.println("La colonne " + index + " est pleine, veuillez rechoisir votre colonne");
                }
            } catch (Exception e) {
                System.out.println("Veuillez mettre un nombre correct");
            }
        }
    }

    public boolean is_full(int index){
        index--;
        boolean is_full = true;;
        ArrayList<Coin> column = grid.getGrid().get(index);
        for(int i = 0; i < column.size(); i++){
            if(column.get(i).getDisk() == Coin.Disk.VOID){
                is_full = false;
                break;
            }
        }
        return is_full;
    }

    public void place(int index, Coin disk) {
        ArrayList<Coin> column = grid.getGrid().get(index);
        for (int i = 0; i < column.size(); i++) {
            if (column.get(i).getDisk() == Coin.Disk.VOID) {
                column.set(i, disk);
            }
        }
    }

    public void verify(){
        for(int i = 0; i < grid.getGrid().size(); i++){ //Vérification verticale
            int red = 0;
            int yellow = 0;
            for(int j = 0; j < grid.getGrid().get(i).size(); j++){
                if(grid.getGrid().get(i).get(j).getDisk() == Coin.Disk.RED){
                    red++;
                    yellow = 0;
                }
                if(grid.getGrid().get(i).get(j).getDisk() == Coin.Disk.YELLOW){
                    red = 0;
                    yellow++;
                }
                if(red == 4){
                    System.out.println("Rouge gagne!");
                }
                if(yellow == 4){
                    System.out.println("Jaune gagne!");
                }
            }
        }
        for(int i = 0; i < grid.getGrid().get(i).size(); i++){ //Vérfication hozizontale
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
                if(red == 4){
                    System.out.println("Rouge gagne!");
                }
                if(yellow == 4){
                    System.out.println("Jaune gagne!");
                }
            }
        }
        for (int i = 0; i < grid.getGrid().get(i).size(); i++) {
            for (int j = 0; j < 4; j++) {
                
            }
        }
    }
}
