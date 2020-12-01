import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.JsonElement;

/**
 * Classe principale du puissance 4
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u - INFO G2A
 */

public class Main{
    public static void main(String[] args) {
        /*try{
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(args[0]));
            Partie data = gson.fromJson(reader, Partie.class);

        } catch (FileNotFoundException e){
            System.out.println("Fichier inexistant");
            System.exit(0);
        }*/

        Grille grille = new Grille(10, 10);
        System.out.println(grille);

        Partie partie = new Partie();
    }
}