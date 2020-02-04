package annexes;

public class Board{

    /**
     * Attributs
     */
    String nom;
    Character[][] navires;
    boolean[][] frappes;

    /**
     * Constructeur avec deux parametres
     * @param aNom  le nom du tableau
     * @param taille la taille du tableau
     */
    public Board(String aNom, int taille){
        this.nom = aNom;
        this.navires = new Character[taille][taille];
        this.frappes = new boolean[taille][taille];
    }

    /**
     * Constructeur qui prend le nom comme argument et donne la taille 10 par default
     * @param aNom
     */

    public Board(String aNom){
        this.nom = aNom;
        this.navires = new Character[10][10];
        this.frappes = new boolean[10][10];
    }
    /**
     * montre le deux tableu
     */

    public void print(){
        System.out.println("Navires: ");
        System.out.print("  ");
        char aux = 65;
        for(int y = 0; y <= this.navires.length; y++){
            
            if (y != 0){
                if (y != 10){
                    System.out.print(y + "  ");
                }else   
                    System.out.print(y + " ");
            }
            for (int x = 0; x < this.navires.length; x++) {
                if (y == 0){
                    System.out.print(" " + aux);
                    aux++;
                }else
                    System.out.print(". ");
                
            }
            
            System.out.println("");
        }

        System.out.println("Frappes: ");
        System.out.print("  ");
        aux = 65;
        for(int y = 0; y <= this.navires.length; y++){
            
            if (y != 0){
                if (y != 10){
                    System.out.print(y + "  ");
                }else   
                    System.out.print(y + " ");
            }
            for (int x = 0; x < this.navires.length; x++) {
                if (y == 0){
                    System.out.print(" " + aux);
                    aux++;
                }else
                    System.out.print(". ");
                
            }
            
            System.out.println("");
        }
    }


}