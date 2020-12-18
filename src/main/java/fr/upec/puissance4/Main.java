package fr.upec.puissance4;

import java.io.IOException;
import java.util.Scanner;

/**
 * Classe principale du puissance 4
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u - INFO G2A
 */

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = null;
        try{ //Cas où le fichier existe
            System.out.println("Lecture de la partie...");
            game = File.read(args[0]);
            System.out.println("Lecture réussi!");
        }
        catch (IOException e){ //Cas où le fichier est inexistant
            System.out.println("Fichier inexistant, création de la partie");
            game = Game.createGame(scanner);
            try {
                File.save(game);
            } catch (IOException e1) {
                e1.printStackTrace();
                System.exit(0);
            }
        }
        catch (ArrayIndexOutOfBoundsException e){ //Cas où on démarre le programme sans argument
            System.out.println("Pas d'argument... Création de la partie");
            game = Game.createGame(scanner);
            try {
                File.save(game);
            } catch (IOException e1) {
                e1.printStackTrace();
                System.exit(0);
            }
        }
        catch (Exception e) {
            System.out.println("Erreur inconnu!");
            e.printStackTrace();
            System.exit(0);
        }
        finally{
            System.out.println("Affichage de la grille");
            System.out.println(game.getGrid());
        }

        /*while(true){
            game.turn(scanner);
            System.out.println(game.getGrid());
        }*/

        for(int i = 0; i <= 5; i++){
            game.turn(scanner);
            System.out.println(game.getGrid());
            try {
                File.save(game);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            } 
        }

        scanner.close();  
    }
}