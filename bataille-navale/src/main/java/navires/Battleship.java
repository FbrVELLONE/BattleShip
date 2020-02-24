package navires;

import annexes.Orientation;

public class Battleship extends AbstractShip{

    /**
     * Constructor standart
     */
    public Battleship(){
        super('B', "BattleShip", 4, Orientation.EAST);
    }

    /**
     * Constructor with orientation needed
     * @param anOrientation
     */
    public Battleship(Orientation anOrientation){
        super('B', "BattleShip", 4, anOrientation);
    }
} 