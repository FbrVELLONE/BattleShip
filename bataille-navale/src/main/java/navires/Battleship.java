package navires;

import annexes.Orientation;

public class Battleship extends AbstractShip{

    public Battleship(){
        super('B', "BattleShip", 3, Orientation.EAST);
    }

    public Battleship(Orientation anOrientation){
        super('B', "BattleShip", 3, anOrientation);
    }
} 