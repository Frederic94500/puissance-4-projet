/**
 * @deprecated
 */

import java.util.ArrayList;

public class ColonneGrille {
    private ArrayList<CaseGrille> colonne;
    private int hauteur;

    public ColonneGrille(int hauteur) {
        this.colonne = new ArrayList<CaseGrille>(hauteur);
        this.hauteur = hauteur;
        for(int i = 0; i != hauteur; i++) {
            colonne.set(i, new CaseGrille());
        }
    }
}


