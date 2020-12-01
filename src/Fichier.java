import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class Fichier {
    public void enregistrement(Partie partie) {
        Gson gson = new Gson();

        Writer writer = FileWriter("test.json");

        gson.toJson(partie, writer);

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Partie lecture(String fichier){
        Gson gson = new Gson();
        Partie partie = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fichier));
            partie = gson.fromJson(reader, Partie.class);
            reader.close();
            return partie;
        } catch (IOException e) {
            e.printStackTrace();
            return partie;
        }
    }

    private Writer FileWriter(String string) {
        return null;
    }
}
