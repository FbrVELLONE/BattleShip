package annexes;

public class Battleship extends AbstractShip{

    public Battleship(){
        super('B', "BattleShip", 3, 0);
    }

    public Battleship(int anOrientation){
        super('B', "BattleShip", 3, anOrientation);
    }


    @Override
    public void print(){

    }
} 