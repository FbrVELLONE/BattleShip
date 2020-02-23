package navires;

import annexes.ColorUtil;
import annexes.ColorUtil.Color;

/**
 * ShipState
 */
public class ShipState {
    protected AbstractShip reference;
    protected boolean struck;
    
    /**
     * Get the label of the utilised ship
     */
    public String toString(){
        return ColorUtil.colorize(this.reference.getLabel().toString(), ColorUtil.Color.RED);
    }

    
    /**
     * add Strike
     */
    public void addStrike(){
        if (!this.struck){
            this.reference.addStrike();
        }
        else{
            System.out.println("Ship has already been hit in this position");
        }
        this.struck = true;
    }

    /**
     * Get the ship passed as reference
     * @return the ship
     */
    public AbstractShip getShip(){
        return this.reference;
    }

    /**
     * Return the state of ship by the attacks
     * @return true if its touched or false if not
     */
    public boolean isStruck(){
        return this.struck;
    }

    public boolean isSunk(){
        if (reference.strikeCount == reference.getTaille()){
            return true;
        }else
            return false;
    }

    /**
     * Constructor of this class
     * @param ref ship passed as reference 
     */
    public ShipState(AbstractShip ref){
        this.reference = ref;
        this.struck = false;
    }
}