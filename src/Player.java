public class Player {
    private String name;
    private Coin disk; //YELLOW = player 1 (Jaune), RED = player 2 (Rouge)
    private int nbDisks;
    
    public Player(Coin disk, String name, int nbDisks){
        this.disk = disk;
        this.name = name;
        this.nbDisks = nbDisks;
    }

    public Coin getDisk(){ return disk; }
    public String getName(){ return name; }
    public int getNbDisks(){ return nbDisks; }
}
