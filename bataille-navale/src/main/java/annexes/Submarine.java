package annexes;

public class Submarine extends AbstractShip{

    @Override
    public void print(){

    }

    public Submarine(){
        super('S',"Submarine",3,0);
    }

    public Submarine(int anOrientation){
        super('S',"Submarine",3,anOrientation);
    }
}
