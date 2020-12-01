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
            Partie partie = Fichier.lecture(args[0]);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Fichier inexistant, création de la partie");
            Partie partie = new Partie();
            try {
                Fichier.enregistrement(partie);
            } catch (IOException e1) {
                e1.printStackTrace();
                System.exit(0);
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println("Création de la partie");
            Partie partie = new Partie();
            try {
                Fichier.enregistrement(partie);
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