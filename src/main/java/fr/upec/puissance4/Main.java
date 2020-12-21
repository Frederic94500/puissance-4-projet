package fr.upec.puissance4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

        if(args.length == 0){
            System.out.println("Pas d'argument... Création de la partie");
            game = Game.createGame(scanner);
            saving(game);
        } else {
            Path path = Paths.get(args[0]);
            if(Files.exists(path)){
                System.out.println("Lecture de la partie...");
                try {
                    game = fr.upec.puissance4.File.read(path);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            } else {
                System.out.println("Fichier inexistant, création de la partie");
                game = Game.createGame(scanner);
                saving(game);
            }
        }

        System.out.println("Affichage de la grille");
        System.out.println(game.getGrid());

        int winner = game.verify(); //0 = plus de disque, 1 = jaune qui gagne, 2 = rouge qui gagne

        while (winner == 0 && game.getGrid().getNbCoin() != 0){
            game.turn(scanner);
            System.out.println(game.getGrid());
            saving(game);
            winner = game.verify();
        }

        String[] message = {"Il n'y a plus de disque disponible pour jouer :(, égalité.", game.getPlayer1().getName() + " gagne la partie!", game.getPlayer2().getName() + " gagne la partie!"};
        System.out.println(message[winner]);

        scanner.close();  
    }

    public static void saving(Game game){
        try {
            fr.upec.puissance4.File.save(game);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}