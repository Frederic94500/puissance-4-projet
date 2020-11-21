import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Partie {
    private Joueur joueur1;
    private Joueur joueur2;
    private int tour; // A qui le tour? 0 = joueur 1 (Jaune), 1 = joueur 2 (Rouge)
    private Grille grille;

    public Partie(Joueur joueur1, Joueur joueur2, Grille grille) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.tour = 0;
        this.grille = grille;
    }

    public void creation_partie(Partie partie) throws IOException {
        BufferedWriter ecriture = Files.newBufferedWriter(Paths.get("customer.json"));

        Map<Joueur, Object> joueurs = new HashMap<>();
        
    }
}
