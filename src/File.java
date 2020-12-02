import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class File {
    public static void enregistrement(Game game) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Writer writer = Files.newBufferedWriter(Paths.get("partie-" + date.format(LocalDateTime.now()) + ".json"));

        gson.toJson(game, writer);

        writer.close();
    }

    public static Game lecture(String file) throws IOException{
        Gson gson = new Gson();

        Reader reader = Files.newBufferedReader(Paths.get(file));
        Game game = gson.fromJson(reader, Game.class);
        
        reader.close();
        return game;
    }
}
