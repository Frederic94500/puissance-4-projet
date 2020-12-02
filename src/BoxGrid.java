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

public class BoxGrid {
    enum Disk {YELLOW, RED, VOID};
    private Disk disk;

    public BoxGrid() {
        this.disk = Disk.VOID;
    }

    public void setBoxGrid(Disk disk) {
        this.disk = disk;
    }

    public Disk getDisk(){ return disk; }
}
