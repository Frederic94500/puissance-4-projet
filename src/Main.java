import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;

/**
 * Classe principale du puissance 4
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u - INFO G2A
 */

public class Main{
    public static void main(String[] args) {
        try{
            File fichier = new File(args[0]);
            Scanner lecture_fichier = new Scanner(fichier);
            while(lecture_fichier.hasNextLine()){
                String data = lecture_fichier.nextLine();
            }
            lecture_fichier.close();

            JsonElement parser = JsonElement.parseString()

            JsonObject json = new JsonParser().parse("{\"name\": \"Jason\", \"age\": 29}").getAsJsonObject();
        } catch (FileNotFoundException e){
            System.out.println("Fichier inexistant");
            System.exit(0);
        }
    }
}