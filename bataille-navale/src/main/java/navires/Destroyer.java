package navires;

import annexes.Orientation;

public class Destroyer extends AbstractShip{
    

    /**
     * Constructeur par default
     * orientation 0 = est
     */
    public Destroyer(){
        super('D',"Destroyer",2,Orientation.EAST);
    }

    /**
     * Constructeur avec l'orientation
     * @param anOrientation
     */
    public Destroyer(Orientation anOrientation){
        super('D',"Destroyer",2,anOrientation);
    }
}