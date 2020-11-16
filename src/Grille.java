import java.util.ArrayList;

/**
 * Classe grille du puissance 4
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */

public class Grille {
    private ArrayList<ColonneGrille> grille; 
    private int largeur;
    private int hauteur;
    
    public Grille(int largeur, int hauteur) {
        this.grille = new ArrayList<ColonneGrille>(largeur);
        this.largeur = largeur;
        this.hauteur = hauteur;
        for(int i = 0; i != hauteur; i++ ) {
            grille.set(i) = new ColonneGrille(hauteur);
        }
    }

}