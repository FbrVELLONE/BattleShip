package navires;

import annexes.Orientation;

public abstract class AbstractShip {
    /**
     * Attributs
     */
    protected Character label;
    protected String nom;
    protected int taille;
    protected Orientation orientation;
    protected int strikeCount;

    /**
     * Mutateur de label
     * @param label
     */
    public void setLabel(Character label){
        this.label = label;
    }

    /**
     * Mutateur de nom
     * @param nom
     */
    public void setNom(String nom){
        this.nom = nom;
    }

    /**
     * Mutateur de taille
     * @param taille
     */
    public void setTaille(int taille){
        this.taille = taille;
    }

    /**
     * Mutateur d'orientation
     * @param anOrientation
     */
    public void setOrientation(Orientation anOrientation){
        this.orientation = anOrientation;
    }

    /**
     * Accesseur de label
     * @return label
     */
    public Character getLabel(){
        return this.label;
    }

    /**
     * Accesseur de nom
     * @return nom
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Accesseur de taille
     * @return taille
     */
    public int getTaille(){
        return this.taille;
    }

    /**
     * Accesseur d'orientation
     * @return orientation
     */
    public Orientation getOrientation(){
        return this.orientation;
    }

    /**
     * Add the strikes in each ship
     */
    public void addStrike(){
        this.strikeCount++;
    }

    /**
     * Verify if the ship was sunk or not
     * @return true if its sunk or false if not
     */
    boolean isSunk(){
        if (this.strikeCount == this.taille){
            return true;
        }else   
            return false;
    }

    /**
     * Constructeur
     */
     public AbstractShip(Character aLabel, String aNom,int aTaille, Orientation anOrientation){
         this.label = aLabel;
         this.nom = aNom;
         this.taille = aTaille;
         this.orientation = anOrientation;
         this.strikeCount = 0;
     }

}