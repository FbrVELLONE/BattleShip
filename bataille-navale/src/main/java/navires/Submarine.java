package navires;

import annexes.Orientation;

public class Submarine extends AbstractShip{

    /**
     * Constructor standart
     */
    public Submarine(){
        super('S',"Submarine",3,Orientation.EAST);
    }

    /**
     * Constructor with orientation needed
     * @param anOrientation
     */
    public Submarine(Orientation anOrientation){
        super('S',"Submarine",3,anOrientation);
    }
}
