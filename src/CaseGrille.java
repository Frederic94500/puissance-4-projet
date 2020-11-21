/**
 * Classe case de grille du puissance 4
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */

 /*
  *  Représnetation des pions:
  *     -JAUNE = X
  *     -ROUGE = O
  *     -VIDE = _
  */

public class CaseGrille {
    enum Pion {JAUNE, ROUGE, VIDE};
    private Pion pion;

    public CaseGrille() {
        this.pion = Pion.VIDE;
    }

    public void setCaseGrille(Pion pion) {
        this.pion = pion;
    }

    public Pion getPion(){ return pion; }
}
