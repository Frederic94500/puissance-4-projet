package fr.upec.puissance4;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Classe File du puissance 4 - Enregistre et Lit la partie avec l'aide de gson
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */

public class File {
    /**
     * Enregistre la partie
     * @param game La partie
     * @throws IOException Echec d'écriture 
     */
    public static void save(Game game) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Writer writer = Files.newBufferedWriter(Paths.get("partie-" + DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDateTime.now()) + ".json"));

        gson.toJson(game, writer);

        writer.close();
    }

    /**
     * Lit la partie
     * @param path Fichier de la partie à lire
     * @return Retourne la partie
     * @throws IOException Echec de lecture
     */
    public static Game read(Path path) throws IOException{
        try(Reader reader = Files.newBufferedReader(path)){
            return new Gson().fromJson(reader, Game.class);
        }
    }
}
