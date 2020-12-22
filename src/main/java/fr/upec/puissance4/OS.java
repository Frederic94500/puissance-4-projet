package fr.upec.puissance4;

import java.io.IOException;

/**
 * Classe OS du puissance 4 Contient les couleurs, ATTENTION: NE FONCTIONNE QUE SUR TERMINAUX UNIX ET LINUX 
 * Contient la commande clear, en fonction du système d'exploitation
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */
public class OS {
    private String red = "\u001B[31m";
    private String yellow = "\u001B[33m";
    private String error = "\u001B[41m";
    private String reset = "\u001B[0m";

    private String os = System.getProperty("os.name");

    /**
     * Constructeur de Color, contruit en fonction du système d'exploitation, si
     * c'est Windows, alors pas de couleur et la commande est "cls". Sinon, on reste
     * sur les paramètres définis
     */
    public OS() {
        if (os.startsWith("Windows")) {
            this.red = "";
            this.yellow = "";
            this.reset = "";
            this.error = "";
        }
    }

    /**
     * Retourne le code couleur jaune
     * @return Retourne le jaune
     */
    public String getYellow() {
        return yellow;
    }

    /**
     * Retourne le code couleur rouge
     * @return Retourne le rouge
     */
    public String getRed() {
        return red;
    }

    /**
     * Retourne le code de réinitialisation de la couleur
     * @return Retourne la réinitialisation
     */
    public String getReset() {
        return reset;
    }

    /**
     * Retourne le code couleur fond rouge
     * @return Retourne le fond rouge
     */
    public String getError() {
        return error;
    }

    /**
     * Retourne la commande de nettoyage du terminal *WIP*
     * @return Retourne la commande
     */
    public void clear() {
        if(os.startsWith("Windows")){
            try {
                Runtime.getRuntime().exec("cls");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.flush();
        }
    }
}
