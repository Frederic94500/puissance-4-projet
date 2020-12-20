package fr.upec.puissance4;

import java.util.ArrayList;

/**
 * Classe Grid (la grille de jeu) du puissance 4
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */

public class Grid {
    private int width;
    private int height;
    private int nbCoin;
    private ArrayList<ArrayList<Coin>> grid; 
    
    /**
     * Constructeur de la grille
     * @param width Longueur
     * @param height Hauteur
     */
    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.nbCoin = width * height;

        this.grid = new ArrayList<ArrayList<Coin>>();
        for(int i = 0; i != width; i++ ) {
            grid.add(i, new ArrayList<Coin>());
            for(int j = 0; j < height; j++){
                grid.get(i).add(j, new Coin());
            }
        }
    }

    /**
     * Retourne la grille de jeu
     * @return Retourne la grille
     */
    public ArrayList<ArrayList<Coin>> getGrid() {
        return grid;
    }
    /**
     * Retourne la longueur de la grille
     * @return Retourne la longueur
     */
    public int getWidth() {
        return width;
    }
    /**
     * Retourne le nombre de disques disponible
     * @return Retourne le nombre de disques
     */
    public int getNbCoin(){
        return nbCoin;
    }

    /**
     * Affiche la grille
     * @return Retourne la grille
     */
    @Override
    public String toString(){
        String s = "";
        for(int i = 1; i < width; i++) s += i + " ";
        s += width + "\n";

        for(int i = height-1; i >= 0; i--){
            for(int j = 0; j < width; j++){
                switch(grid.get(j).get(i).getDisk()){
                    case YELLOW:
                        s += "X ";
                        break;
                    case RED:
                        s += "O ";
                        break;
                    case VOID:
                        s += "_ ";
                        break;
                }
            }
            s += "\n";
        }
        return s;
    }

    /**
     * Décrémente le nombre de disques disponible pour le jeu
     */
    public void decrementnbCoin(){
        nbCoin--;
    }
}