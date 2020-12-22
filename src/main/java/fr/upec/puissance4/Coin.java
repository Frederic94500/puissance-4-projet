package fr.upec.puissance4;

/**
 * Classe Coin du puissance 4 - Représente la case ou le disque
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

    /**
     * Constructeur d'une case vide
     */
    public Coin() {
        this.disk = Disk.VOID;
    }
    /**
     * Constructeur d'un disque
     * @param disk Disque du joueur
     */
    public Coin(Disk disk){
        this.disk = disk;
    }

    /**
     * Change le disque en fonction du disque placé
     * @param disk Disque du joueur
     */
    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    /**
     * Retourne le disque du joueur ou la case
     * @return Retourne le disque
     */
    public Disk getDisk(){
        return disk;
    }
}
