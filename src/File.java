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
    public static void save(Game game) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Writer writer = Files.newBufferedWriter(Paths.get("partie-" + date.format(LocalDateTime.now()) + ".json"));

        gson.toJson(game, writer);

        writer.close();
    }

    public static Game read(String file) throws IOException{
        try(Reader reader = Files.newBufferedReader(Paths.get(file))){
            return new Gson().fromJson(reader, Game.class);
        }
    }
}
