import java.util.ArrayList;

/**
 * Classe Grid du puissance 4
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */

public class Grid {
    private int width;
    private int height;
    private ArrayList<ArrayList<Coin>> grid; 
    
    public Grid(int width, int height) {
        this.grid = new ArrayList<ArrayList<Coin>>();
        this.width = width;
        this.height = height;
        for(int i = 0; i != width; i++ ) {
            grid.add(i, new ArrayList<Coin>());
            for(int j = 0; j < height; j++){
                grid.get(i).add(j, new Coin());
            }
        }
    }

    @Override
    public String toString(){
        String s = "";
        for(int i = 1; i < width; i++) s += i + " ";
        s += width + "\n";

        for(int i = height-1; i >= 0; i--){
            for(int j = width-1; j >= 0; j--){
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

    public ArrayList<ArrayList<Coin>> getGrid() {
        return grid;
    }
}