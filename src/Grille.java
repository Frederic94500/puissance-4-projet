import java.util.ArrayList;

/**
 * Classe grille du puissance 4
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */

public class Grille {
    private ArrayList<ArrayList<CaseGrille>> grille; 
    private int largeur;
    private int hauteur;
    
    public Grille(int largeur, int hauteur) {
        this.grille = new ArrayList<ArrayList<CaseGrille>>(/*largeur*/);
        this.largeur = largeur;
        this.hauteur = hauteur;
        for(int i = 0; i != largeur; i++ ) {
            grille.add(i, new ArrayList<CaseGrille>(/*hauteur*/));
            for(int j = 0; j < hauteur; j++){
                grille.get(i).add(j, new CaseGrille());
            }
        }
    }

    @Override
    public String toString(){
        String s = "";
        for(int i = 1; i < largeur; i++) s += i + " ";
        s += largeur + "\n";
        for(int i = largeur-1; i >= 0; i--){
            for(int j = hauteur-1; j >= 0; j--){
                switch(grille.get(j).get(i).getPion()){
                    case JAUNE:
                        s += "X ";
                    case ROUGE:
                        s += "O ";
                    case VIDE:
                        s += "_ ";
                }
            }
            s += "\n";
        }
        return s;
    }
}