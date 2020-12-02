/**
 * Classe case de grille du puissance 4
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */

 /*
  *  Représnetation des pions:
  *     -YELLOW = X
  *     -RED = O
  *     -VOID = _
  */

public class Coin {
    enum Disk {YELLOW, RED, VOID};
    private Disk disk;

    public Coin() {
        this.disk = Disk.VOID;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public Disk getDisk(){ return disk; }
}
