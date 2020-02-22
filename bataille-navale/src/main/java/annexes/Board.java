package annexes;

import navires.AbstractShip;

public class Board implements IBoard{

    /**
     * Attributs
     */
    private String nom;
    private Character[][] navires;
    private boolean[][] frappes;

    /**
     * Mutateur de nom
     * @param nom
     */
    public void setNom(String nom){
        this.nom = nom;
    }

    /**
     * Mutateur de navires
     * @param navires
     */
    public void setNavires(Character[][] navires){
        this.navires = navires;
    }

    /**
     * mutateur de frappes
     * @param frappes
     */
    public void setFrappes(boolean[][]frappes){
        this.frappes = frappes;
    }

    /**
     * Accesseur de nom
     * @return nom
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Accesseur de navires
     * @return navires
     */
    public Character[][] getNavires(){
        return this.navires;
    }

    /**
     * Accesseur de frappes
     * @return frappes
     */
    public boolean[][] getFrappes(){
        return this.frappes;
    }
    /**
     * Constructeur avec deux parametres
     * @param aNom  le nom du tableau
     * @param taille la taille du tableau
     */
    public Board(String aNom, int taille){
        this.nom = aNom;
        this.navires = new Character[taille][taille];
        for(int i = 0; i < taille; i++) for (int j = 0; j<taille; j++)
            navires[j][i] = '.';

        this.frappes = new boolean[taille][taille];
    }

    /**
     * Constructeur qui prend le nom comme argument et donne la taille 10 par default
     * @param aNom
     */
    public Board(String aNom){
        this.nom = aNom;
        this.navires = new Character[10][10];
        for(int i = 0; i < 10; i++) for (int j = 0; j<10; j++)
            navires[j][i] = '.';

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
                    System.out.print(navires[y-1][x] + " ");
                
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
                }else{
                    if (frappes[y-1][x]){
                        System.out.print("X ");
                    }else
                        System.out.print(". ");
                }
                    
                
            }
            
            System.out.println("");
        }
    }



    public int getSize(){
        return this.navires.length;
    }

    
    public void putShip(AbstractShip ship, int x, int y) throws ArrayIndexOutOfBoundsException{
        int taille = ship.getTaille();
        switch (ship.getOrientation()) {
            case EAST:
                if ( x + taille <= navires.length){
                    for (int i = 0; i < taille; i++){
                        navires[y-1][x-1+i] = ship.getLabel();
                    }
                }    
                break;

            case WEST:
                if ( x - taille >= 0){
                    for (int i = 0; i < taille; i++){
                        navires[y-1][x-1-i] = ship.getLabel();
                    }
                }    
                break;
            case SOUTH:
                if ( y + taille <= navires.length){
                    for (int i = 0; i < taille; i++){
                        navires[y-1+i][x-1] = ship.getLabel();
                    }
                }    
                break;
            case NORTH:
                if ( y - taille >= 0){
                    for (int i = 0; i < taille; i++){
                        navires[y-1-i][x-1] = ship.getLabel();
                        System.out.println(navires[y-i][x]);
                    }
                }    
                break;
        }

    }

    public boolean hasShip(int x, int y){
        if (navires[y-1][x-1] != '.'){
            return true;
        }else 
            return false;
        
    }

    public void setHit(boolean hit, int x, int y){
        if (hit){
            this.frappes[y-1][x-1] = true;
        }else   
            this.frappes[y-1][x-1] = false;
    }

    /**
     * 
     */
    public Boolean getHit(int x, int y){
        if (navires[y-1][x-1] != '.'){
            return true;
        }else
            return false;
    }
}