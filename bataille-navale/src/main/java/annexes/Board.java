package annexes;

import navires.*;

public class Board implements IBoard{

    /**
     * Attributs
     */
    private String nom;
    private ShipState[][] navires;
    private Boolean[][] frappes;

    /**
     * Mutateur de nom
     * @param nom
     */
    public void setNom(final String nom){
        this.nom = nom;
    }

    /**
     * Mutateur de navires
     * @param navires
     */
    public void setNavires(final ShipState[][] navires){
        this.navires = navires;
    }

    /**
     * mutateur de frappes
     * @param frappes
     */
    public void setFrappes(final Boolean[][]frappes){
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
    public ShipState[][] getNavires(){
        return this.navires;
    }

    /**
     * Accesseur de frappes
     * @return frappes
     */
    public Boolean[][] getFrappes(){
        return this.frappes;
    }
    /**
     * Constructeur avec deux parametres
     * @param aNom  le nom du tableau
     * @param taille la taille du tableau
     */
    public Board(final String aNom, final int taille){
        this.nom = aNom;
        this.navires = new ShipState[taille][taille];


        this.frappes = new Boolean[taille][taille];
    }

    /**
     * Constructeur qui prend le nom comme argument et donne la taille 10 par default
     * @param aNom
     */
    public Board(final String aNom){
        this.nom = aNom;
        this.navires = new ShipState[10][10];


        this.frappes = new Boolean[10][10];
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
                }else{
                    if (navires[y-1][x] == null){
                        System.out.print(". ");
                    }
                    else 
                        System.out.print(navires[y-1][x].getShip().getLabel() + " ");
                }
                    
                
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
                    if (frappes[y-1][x] != null){
                        if (this.navires[y-1][x] != null){
                            if (this.navires[y-1][x].isStruck()){
                                System.out.print(ColorUtil.colorize("X ", ColorUtil.Color.RED));
                            }
                        }else{
                             System.out.print(ColorUtil.colorize("X ", ColorUtil.Color.WHITE));
                        }
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

    
    public void putShip(final AbstractShip ship, final int x, final int y) throws ArrayIndexOutOfBoundsException{
        final int taille = ship.getTaille();
        switch (ship.getOrientation()) {
            case EAST:
                if ( x - 1 + taille <= navires.length){
                    for (int i = 0; i < taille; i++){
                        if (navires[y-1][x-1+i] == null){
                            navires[y-1][x-1+i] = new ShipState(ship);
                            navires[y-1][x-1+i].getShip().setLabel(ship.getLabel());
                        }else{
                            for (;i>0;i--){
                                navires[y-1][x-1+(i-1)] = null;
                            }
                            throw new ArrayIndexOutOfBoundsException("This position has already been taken by another ship");
                        }
                    }
                }else{
                    throw new ArrayIndexOutOfBoundsException("Ship out of bounds, please enter another position or orientation");
                }
                break;

            case WEST:
                if ( x - taille >= 0){
                    for (int i = 0; i < taille; i++){
                        if (navires[y-1][x-1-i] == null){
                            navires[y-1][x-1-i] = new ShipState(ship);
                            navires[y-1][x-1-i].getShip().setLabel(ship.getLabel());
                        }else{
                            for (;i>0;i--){
                                navires[y-1][x-1-(i-1)] = null;
                            }
                            throw new ArrayIndexOutOfBoundsException("This position has already been taken by another ship");
                        }
                    }
                }else{
                    throw new ArrayIndexOutOfBoundsException("Ship out of bounds, please enter another position or orientation");
                }    
                break;
            case SOUTH:
                if ( y - 1 + taille <= navires.length){
                    for (int i = 0; i < taille; i++){
                        if (navires[y-1+i][x-1] == null){
                            navires[y-1+i][x-1] = new ShipState(ship);
                            navires[y-1+i][x-1].getShip().setLabel(ship.getLabel());
                        }else{
                            for (;i>0;i--){
                                navires[y-1+(i-1)][x-1] = null;
                            }
                            throw new ArrayIndexOutOfBoundsException("This position has already been taken by another ship");
                        }
                    }   
                }else{
                    throw new ArrayIndexOutOfBoundsException("Ship out of bounds, please enter another position or orientation");
                } 
                break;
            case NORTH:
                if ( y + 1 - taille > 0){
                    for (int i = 0; i < taille; i++){
                        
                        if (navires[y-1-i][x-1] == null){
                            navires[y-1-i][x-1] = new ShipState(ship);
                            navires[y-1-i][x-1].getShip().setLabel(ship.getLabel());
                        }else{
                            for (;i>=0;i--){
                                navires[y-1-(i-1)][x-1] = null;
                            }
                            throw new ArrayIndexOutOfBoundsException("This position has already been taken by another ship");
                        }
                    }
                }else{
                    throw new ArrayIndexOutOfBoundsException("Ship out of bounds, please enter another position or orientation");
                }
                break;
        }

    }
    public boolean hasShip(final int x, final int y){
        if (navires[y-1][x-1] != null){
            return true;
        }else 
            return false;
        
    }

    public void setHit(final boolean hit, final int x, final int y) throws ArrayIndexOutOfBoundsException{
       try{ 
           if (hit){
                if (this.frappes[y-1][x-1] == null)
                    this.frappes[y-1][x-1] = false;
                if (!this.frappes[y-1][x-1]){
                    this.frappes[y-1][x-1] = true;
                    if (navires[y-1][x-1] != null)
                        this.navires[y-1][x-1].addStrike();
                }else{
                    throw new ArrayIndexOutOfBoundsException("Ship has already been hit in this position");
                }
            }else   
                this.frappes[y-1][x-1] = false;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 
     */
    public Boolean getHit(final int x, final int y){
        if (navires[y-1][x-1].isStruck()){
            return true;
        }else
            return false;
    }
}
