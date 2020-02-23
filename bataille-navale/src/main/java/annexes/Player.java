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

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
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
            // TODO set ship orientation
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

            
            // TODO put ship at given position
            try{
                board.putShip(ships[i], res.x, res.y);
                ++i;
                
            } catch(IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
            
            // TODO when ship placement successful
            
            
            
            done = i == 5;
            board.print();
        } while (!done);
    }

    public Hit sendHit(int[] coords) {
        boolean done;
        Hit hit = null;

        do {
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
            // TODO call sendHit on this.opponentBoard
            done = false;
            // TODO : Game expects sendHit to return BOTH hit result & hit coords.
            // return hit is obvious. But how to return coords at the same time ?
        } while (!done);

        return hit;
    }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}
