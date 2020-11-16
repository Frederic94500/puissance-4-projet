/**
 * Classe case de grille du puissance 4
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */

public class CaseGrille {
    enum Couleur {JAUNE, ROUGE, VIDE};
    private Couleur couleur;

    public CaseGrille() {
        this.couleur = Couleur.VIDE;
    }

    public CaseGrille(Couleur couleur) {
        this.couleur = couleur;
    }
}
