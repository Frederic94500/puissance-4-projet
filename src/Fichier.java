import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Fichier {
    public static void enregistrement(Partie partie) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Writer writer = Files.newBufferedWriter(Paths.get("partie-" + date.format(LocalDateTime.now()) + ".json"));

        gson.toJson(partie, writer);

        writer.close();
    }

    public static Partie lecture(String fichier) throws IOException{
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(fichier));
        Partie partie = gson.fromJson(reader, Partie.class);
        reader.close();
        return partie;
    }
}
