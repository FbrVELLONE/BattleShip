package annexes;

public abstract class AbstractShip {
    /**
     * Attributs
     */
    protected Character[] label;
    protected String nom;
    protected int taille;
    protected int orientation;


    /**
     * Mutateur d'orientation
     * @param anOrientation
     */
    public void setOrientation(int anOrientation){
        this.orientation = anOrientation;
    }

    /**
     * Constructeur
     */

     public AbstractShip(Character[] aLabel, String aNom,int aTaille, int anOrientation){
         this.label = aLabel;
         this.nom = aNom;
         this.taille = aTaille;
         this.orientation = anOrientation;
     }

     public abstract void print();
}