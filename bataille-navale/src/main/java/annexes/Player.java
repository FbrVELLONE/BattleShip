package annexes;

import java.io.Serializable;
import java.util.List;
import navires.AbstractShip;

public class Player {
    /* **
     * Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;
    protected String name;

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }
    /* **
     * Constructeur2
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships, String nom) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
        this.name = nom;
    }

    /* **
     * Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given coodrinates.
     */
    public void putShips() {
        boolean done = false;
        int i = 0;

        
        do {
            AbstractShip s = ships[i];

            String msg = String.format("placer %d : %s(%d)", i + 1, s.getNom(), s.getTaille());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();


            System.out.println(res.orientation);
            if (res.orientation.equals("e")){
                ships[i].setOrientation(Orientation.EAST);
            }
            if (res.orientation.equals("w")){
                ships[i].setOrientation(Orientation.WEST);
            }
            if (res.orientation.equals("n")){
                ships[i].setOrientation(Orientation.NORTH);
            }
            if (res.orientation.equals("s")){
                ships[i].setOrientation(Orientation.SOUTH);
            }

            try{
                board.putShip(ships[i], res.x, res.y);
                ++i;   
            } catch(IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
            
            
            
            
            done = i == 5;
            board.print(opponentBoard);
        } while (!done);
    }

    public Hit sendHit(int[] coords) throws Exception{
        boolean done = true;
        Hit hit = null;

        do {

                System.out.println("où frapper?");
                InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
    
                coords[0] = hitInput.x;
                coords[1] = hitInput.y;
                    System.out.println("cord0; " + coords[0] + " coord1: " + coords[1]);
                    System.out.println(board.getFrappes()[coords[0] - 1][coords[1] - 1]);
                if (board.getFrappes()[coords[0] - 1][coords[1] - 1] != null){
                    throw new Exception("You have already shot here");
                }

                hit = this.opponentBoard.sendHit(coords[0], coords[1]);

                if(hit != Hit.MISS){
                    this.board.setHit(true, coords[0], coords[1]);
                    // done = false;
                }else{
                    this.board.setHit(false, coords[0], coords[1]);
                    // done = true;
                }

                // board.print(opponentBoard);
        } while (!done);
   
        return hit;
    }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }

    public void setName(String nom){
        this.name = nom;
    }

    public void setDestroyedCount(int count){
        this.destroyedCount = count;
    }

    public int getDestroyedCount(){
        return this.destroyedCount;
    }
}
