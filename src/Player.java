public class Player {
    private boolean disk; //true = player 1 (Jaune), false = player 2 (Rouge)
    private String name;
    private int nbDisks;
    
    public Player(boolean disk, String name, int nbDisks){
        this.disk = disk;
        this.name = name;
        this.nbDisks = nbDisks;
    }

    public boolean getDisk(){ return disk; }
    public String getName(){ return name; }
    public int getNbDisks(){ return nbDisks; }
}
