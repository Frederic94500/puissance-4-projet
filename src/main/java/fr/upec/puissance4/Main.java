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

        while (game.verify_horizontal() == 0 && game.verify_vertical() == 0 && game.getGrid().getNbCoin() != 0){
            game.turn(scanner);
            System.out.println(game.getGrid());
            saving(game);
        }

        String[] message = {"Il n'y a plus de disque disponible pour jouer :(, égalité.", game.getPlayer1().getName() + " gagne la partie!", game.getPlayer2().getName() + " gagne la partie!"};
        int[] winner = {game.verify_horizontal(), game.verify_vertical()};
        boolean validation = false;

        for (int i : winner) {
            if(i != 0){
                System.out.println(message[i]);
                validation = true;
                break;
            }
        }

        if(!validation){ System.out.println(message[0]); }

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