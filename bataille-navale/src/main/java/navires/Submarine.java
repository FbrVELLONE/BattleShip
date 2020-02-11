package navires;

import annexes.Orientation;

public class Submarine extends AbstractShip{


    public Submarine(){
        super('S',"Submarine",3,Orientation.EAST);
    }

    public Submarine(Orientation anOrientation){
        super('S',"Submarine",3,anOrientation);
    }
}
