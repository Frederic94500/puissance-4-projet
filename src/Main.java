import java.io.IOException;

/**
 * Classe principale du puissance 4
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u - INFO G2A
 */

public class Main{
    public static void main(String[] args) {
        try{
            System.out.println("Lecture de la partie...");
            Game game = File.lecture(args[0]);
            System.out.println("Lecture réussi!");

        } catch (IOException e){ //Cas où le fichier est inexistant
            System.out.println("Fichier inexistant, création de la partie");
            Game game = Game.createGame();
            try {
                File.enregistrement(game);
            } catch (IOException e1) {
                e1.printStackTrace();
                System.exit(0);
            }

        } catch (ArrayIndexOutOfBoundsException e){ //Cas où on démarre le programme sans argument
            System.out.println("Pas d'argument... Création de la partie");
            Game game = Game.createGame();
            try {
                File.enregistrement(game);
            } catch (IOException e1) {
                e1.printStackTrace();
                System.exit(0);
            }
            
        } catch (Exception e) {
            System.out.println("Erreur inconnu!");
            System.exit(0);
        }
    }
}