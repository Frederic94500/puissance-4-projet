public class Joueur {
    private boolean pion; //true = joueur 1 (Jaune), false = joueur 2 (Rouge)
    private String nom;
    private int nbPions;
    
    public Joueur(boolean pion, String nom, int nbPions){
        this.pion = pion;
        this.nom = nom;
        this.nbPions = nbPions;
    }

    public boolean getPion(){ return pion; }
    public String getNom(){ return nom; }
    public int nbPions(){ return nbPions; }
}
