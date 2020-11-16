import java.util.ArrayList;

public class ColonneGrille {
    private ArrayList<CaseGrille> colonne;
    private int hauteur;

    public ColonneGrille(int hauteur) {
        this.colonne = new ArrayList<CaseGrille>(hauteur);
        this.hauteur = hauteur;
        for(int j = 0; j != hauteur; j++) {
            colonne.set(i) = new CaseGrille();
        }
    }
}
