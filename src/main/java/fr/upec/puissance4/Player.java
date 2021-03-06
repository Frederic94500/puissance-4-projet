package fr.upec.puissance4;

/**
 * Classe Player du puissance 4 - Données d'un joueur
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */
public class Player {
    private String name;
    private AI ai; //null = non IA, 0 = Bogo, 1 = Min/Max, 2 = Custom
    private Coin disk; //YELLOW = player 1 (Jaune), RED = player 2 (Rouge)

    /**
     * Constructeur du joueur
     * @param disk Son disque
     * @param name Son nom
     */
    public Player(Coin disk, AI ai, String name){
        this.disk = disk;
        this.ai = ai;
        this.name = name;
    }

    /**
     * Retourne le disque d'un joueur
     * @return Retourne le disque
     */
    public Coin getDisk(){ 
        return disk;
    }
    /**
     * Retourne le nom d'un joueur
     * @return Retourne le nom
     */
    public String getName(){
        return name;
    }
    /**
     * Retourne le type de joueur
     * @return Retourne un booléen 
     */
    public AI getAI(){
        return ai;
    }
}
