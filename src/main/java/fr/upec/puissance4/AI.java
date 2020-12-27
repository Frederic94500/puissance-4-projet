package fr.upec.puissance4;

import java.util.Scanner;

public class AI {
    private int type;

    public AI(int type){
        this.type = type;
    }

    /**
     * 
     * @return
     */
    public int getType() {
        return type;
    }

    public static AI createAI(Scanner scanner){
        while(true){
            System.out.println("0 = BogoIA (Naif), 1 = Min/Max, 2 = α/β (Alpha/Beta)?");
            int integer = Game.isInteger(scanner);
            if(integer >= 0 && integer <= 2){
                return new AI(integer);
            } else {
                System.out.println(Main.os.getError() + "Veuillez entrer un nombre entre 0 et 2" + Main.os.getReset());
            }
        }
    }

    public void executeAI(Game game, Coin disk){
        switch (type) {
            case 0:
                bogo(game, disk);
                break;
            case 1:
                minMax(game, disk);
                break;
            case 2:
                alphaBeta(game, disk);
                break;
        }
    }

    public void printPlace(Game game, Coin disk, int index){
        String s = "";
        switch (disk.getDisk()) {
            case YELLOW:
                s += Main.os.getYellow() + "L'IA a placé sur la colonne " + index + Main.os.getReset();
                break;
            case RED:
                s += Main.os.getRed() + "L'IA a placé sur la colonne " + index + Main.os.getReset();
                break;
            case VOID:
                break;
        }
        System.out.println(s);
    }

    public void bogo(Game game, Coin disk) {
        while(true){
            int random = (int)(Math.random() * game.getGrid().getWidth());
            if(!game.isFull(random)){
                game.place(random, disk);
                game.getGrid().decrementNbCoin();
                printPlace(game, disk, random);
                break;
            }
        }
    }

    public void minMax(Game game, Coin disk) {

    }

    public void alphaBeta(Game game, Coin disk) {

    }
}
