import java.util.ArrayList;

/**
 * Classe Grid du puissance 4
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */

public class Grid {
    private ArrayList<ArrayList<BoxGrid>> grid; 
    private int width;
    private int height;
    
    public Grid(int width, int height) {
        this.grid = new ArrayList<ArrayList<BoxGrid>>(/*width*/);
        this.width = width;
        this.height = height;
        for(int i = 0; i != width; i++ ) {
            grid.add(i, new ArrayList<BoxGrid>(/*height*/));
            for(int j = 0; j < height; j++){
                grid.get(i).add(j, new BoxGrid());
            }
        }
    }

    @Override
    public String toString(){
        String s = "";
        for(int i = 1; i < width; i++) s += i + " ";
        s += width + "\n";
        for(int i = width-1; i >= 0; i--){
            for(int j = height-1; j >= 0; j--){
                switch(grid.get(j).get(i).getDisk()){
                    case YELLOW:
                        s += "X ";
                    case RED:
                        s += "O ";
                    case VOID:
                        s += "_ ";
                }
            }
            s += "\n";
        }
        return s;
    }
}