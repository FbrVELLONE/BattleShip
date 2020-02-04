package annexes;

public class Board{

    /**
     * Attributs
     */
    String nom;
    char[][] navires;
    boolean[][] frappes;

    /**
     * Constructeur avec deux parametres
     * @param aNom  le nom du tableau
     * @param taille la taille du tableau
     */
    public Board(String aNom, int taille){
        this.nom = aNom;
        this.navires = new char[taille][taille];
        this.frappes = new boolean[taille][taille];
    }

    /**
     * Constructeur qui prend le nom comme argument et donne la taille 10 par default
     * @param aNom
     */

    public Board(String aNom){
        this.nom = aNom;
        this.navires = new char[10][10];
        this.frappes = new boolean[10][10];
    }




}