package fr.upec.puissance4;

/**
 * Classe OS du puissance 4 Contient les couleurs, ATTENTION: NE FONCTIONNE QUE SUR TERMINAUX UNIX ET LINUX
 * @author Frédéric TRAN - u21960418 - INFO G2A
 * @author Tony TAVERNIER - u21808537 - INFO G2A
 */
public class OS {
    private String red = "\u001B[31m";
    private String yellow = "\u001B[33m";
    private String error = "\u001B[41m";
    private String reset = "\u001B[0m";

    private String os;

    /**
     * Constructeur de OS, contruit en fonction du système d'exploitation,
     * si c'est Windows, alors pas de couleur.
     * Sinon, on reste sur les paramètres définis.
     */
    public OS() {
        this.os = System.getProperty("os.name");
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
}
