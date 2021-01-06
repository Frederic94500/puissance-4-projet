package fr.upec.puissance4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Classe principale du puissance 4
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */
public class Main{
    static final OS os = new OS();
    
    /**
     * Fonction principale
     * @param args Argument d'exécution
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game;

        game = creating(args, scanner); //Création de la partie
        if(game == null){
            System.out.println("Erreur durant l'exécution");
            System.exit(1);
        }

        System.out.println("\n=====Affichage de la grille=====");
        System.out.println(game.getGrid());

        int winner = game.verify(); //0 = pas de gagnant, 1 = jaune qui gagne, 2 = rouge qui gagne

        while (winner == 0 && game.getGrid().getNbCoin() != 0){ //Voir verify(), si le nombre de disque est différent de 0, alors on continue 
            game.turn(scanner);
            System.out.println("===============\n" + game.getGrid());
            fr.upec.puissance4.File.save(game);
            winner = game.verify();
        }

        String[] message = {"Il n'y a plus de disque disponible pour jouer :(, égalité.", 
            os.getYellow() + game.getPlayer1().getName() + " gagne la partie!", 
            os.getRed() + game.getPlayer2().getName() + " gagne la partie!"};

        System.out.println(message[winner]);

        scanner.close();  
    }

    /**
     * Créée la partie 
     * @param args Argument d'exécution
     * @param scanner Scanner d'entrée
     * @return Retourne le jeu
     */
    public static Game creating(String[] args, Scanner scanner){
        Game game;
        if(args.length == 0){ //Cas où il n'y a pas d'argument
            System.out.println("Pas d'argument... Création de la partie");
            game = Game.createGame(scanner, "");
            fr.upec.puissance4.File.save(game);
        } else { //Cas où il y a un argument
            Path path = Paths.get(args[0]);
            if(Files.exists(path)){ //Cas où le fichier existe
                System.out.println("Lecture de la partie...");
                try {
                    game = fr.upec.puissance4.File.read(path);
                } catch (IOException e) {
                    e.printStackTrace();
                    game = null;
                }
            } else { 
                System.out.println("Fichier inexistant, création de la partie");
                game = Game.createGame(scanner, args[0]);
                fr.upec.puissance4.File.save(game);
            }
        }
        return game;
    }
}