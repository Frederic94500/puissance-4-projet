import java.util.Scanner;

public class Partie {
    private Joueur joueur1;
    private Joueur joueur2;
    private boolean tour; // A qui le tour? true = joueur 1 (Jaune), false = joueur 2 (Rouge)
    private Grille grille;

    public Partie(Joueur joueur1, Joueur joueur2, Grille grille) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.tour = true;
        this.grille = grille;
    }

    public Partie() {
        System.out.println("Création de la partie...");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Création de la grille\nTaille de la grille, Largeur?");
        int largeur = scanner.nextInt();
        System.out.println("Taille de la grille, Hauteur?");
        int hauteur = scanner.nextInt();
        this.grille = new Grille(largeur, hauteur);
        System.out.println("Grille créée");

        int nbPionsGrille = largeur * hauteur;

        System.out.println("Création des joueurs");
        System.out.println("Nom du joueur 1?");
        this.joueur1 = new Joueur(true, scanner.next(), nbPionsGrille/2);
        System.out.println("Nom du joueur 2?");
        this.joueur2 = new Joueur(false, scanner.next(), nbPionsGrille/2);
        System.out.println("Joueurs créés");

        System.out.println("Partie créée!");

        scanner.close();
    }
}
