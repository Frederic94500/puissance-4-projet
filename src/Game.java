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
        System.out.println("Création de la partie...");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Création de la grid\nTaille de la grid, Largeur?");
        int width = scanner.nextInt();
        System.out.println("Taille de la grid, Hauteur?");
        int height = scanner.nextInt();
        this.grid = new Grid(width, height);
        System.out.println("grid créée");

        int nbDiskGrid = width * height;

        System.out.println("Création des joueurs");
        System.out.println("Nom du joueur 1?");
        this.player1 = new Player(true, scanner.next(), nbDiskGrid/2);
        System.out.println("Nom du joueur 2?");
        this.player2 = new Player(false, scanner.next(), nbDiskGrid/2);
        System.out.println("Joueurs créés");

        System.out.println("Partie créée!");

        scanner.close();
    }
}
