package annexes;

public class Carrier extends AbstractShip{

    public Carrier(){
        super('C', "Carrier", 4, 0);
    }

    public Carrier(int anOrientation){
        super('C', "Carrier", 4, anOrientation);
    }


    @Override
    public void print(){

    }
} 
