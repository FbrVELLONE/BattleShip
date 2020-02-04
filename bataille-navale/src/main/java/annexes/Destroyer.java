package annexes;

public class Destroyer extends AbstractShip{
    
    @Override
    public void print(){

    }

    /**
     * Constructeur par default
     * orientation 0 = est
     */
    public Destroyer(){
        super('D',"Destroyer",2,0);
    }

    /**
     * Constructeur avec l'orientation
     * @param anOrientation
     */
    public Destroyer(int anOrientation){
        super('D',"Destroyer",2,anOrientation);
    }
}