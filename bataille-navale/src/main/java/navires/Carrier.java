package navires;

import annexes.Orientation;

public class Carrier extends AbstractShip{

    public Carrier(){
        super('C', "Carrier", 4, Orientation.EAST);
    }

    public Carrier(Orientation anOrientation){
        super('C', "Carrier", 4, anOrientation);
    }
} 
