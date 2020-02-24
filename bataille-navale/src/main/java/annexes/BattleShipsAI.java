package annexes;

import navires.*;
import java.io.Serializable;
import java.util.*;

public class BattleShipsAI implements Serializable {

    /*
     * ** Attributs
     */

    /**
     * grid size.
     */
    private final int size;

    /**
     * My board. My ships have to be put on this one.
     */
    private final IBoard board;

    /**
     * My opponent's board. My hits go on this one to strike his ships.
     */
    private final IBoard opponent;

    /**
     * Coords of last known strike. Would be a good idea to target next hits around
     * this point.
     */
    private int lastStrike[];

    /**
     * If last known strike lead me to think the underlying ship has vertical
     * placement.
     */
    private Boolean lastVertical;

    /*
     * ** Constructeur
     */

    /**
     * Constructor
     * @param myBoard       board where ships will be put.
     * @param opponentBoard Opponent's board, where hits will be sent.
     */
    public BattleShipsAI(IBoard myBoard, IBoard opponentBoard) {
        this.board = myBoard;
        this.opponent = opponentBoard;
        size = board.getSize();
    }

    /*
     * ** Méthodes publiques
     */

    /**
     * Put the ships on owned board.
     * 
     * @param ships the ships to put
     */
    public void putShips(AbstractShip ships[]) {
        int x, y;
        Orientation o = null;
        Random rnd = new Random();

        for (AbstractShip s : ships) {
            do {
                x = rnd.nextInt(10) + 1;
                y = rnd.nextInt(10) + 1;
                
                int sCase = rnd.nextInt(4);
                switch (sCase) {
                    case 0:
                        o = Orientation.EAST;
                        break;
                
                    case 1:
                        o = Orientation.WEST;
                        break;
                
                    case 2:
                        o = Orientation.NORTH;
                        break;
                
                    case 3:
                        o = Orientation.SOUTH;
                        break;
                }
                s.setOrientation(o);
               
            } while (!canPutShip(s, x, y));
            board.putShip(s, x, y);

        }
    }

    /**
     * Send the AI's hit to the game board, checking whether or not there are boats
     * @param coords array must be of size 2. Will hold the coord of the send hit.
     * @return the status of the hit.
     */
    public Hit sendHit(int[] coords) {
        
        int res[] = null;  
        
        if (coords == null || coords.length < 2) {
            throw new IllegalArgumentException("must provide an initialized array of size 2");
        }

        if (lastVertical != null) {
            if (lastVertical) {
                res = pickVCoord();
            } else {
                res = pickHCoord();
            }

            if (res == null) {
                lastStrike = null;
                lastVertical = null;
            }
        } else if (lastStrike != null) {
            res = pickVCoord();
            if (res == null) {
                res = pickHCoord();
            }
            if (res == null) {
                lastStrike = null;
            }
        }

        if (lastStrike == null) {
            
            res = pickRandomCoord();
            
        }
        Hit hit = opponent.sendHit(res[0], res[1]);
        board.setHit(hit != Hit.MISS, res[0], res[1]);

        if (hit != Hit.MISS) {
            if (lastStrike != null) {
                lastVertical = guessOrientation(lastStrike, res);
            }
            lastStrike = res;
        }

        coords[0] = res[0];
        coords[1] = res[1];
        return hit;
    }

    /*
     * *** Méthodes privées
     */

    /**
     * Checks if it is possible to allocate the boat to the desired place
     * @param ship Target boat in positioning
     * @param x coord x
     * @param y coord y
     * @return True to possible positioning and false to impossible
     */    
    private boolean canPutShip(AbstractShip ship, int x, int y) {
        Orientation o = ship.getOrientation();
        int dx = 0, dy = 0;
        if (o == Orientation.EAST) {
            if (x-1 + ship.getTaille() >= this.size) {
                return false;
            }
            dx = 1;
        } else if (o == Orientation.SOUTH) {
            if (y-1 + ship.getTaille() >= this.size) {
                return false;
            }
            dy = 1;
        } else if (o == Orientation.NORTH) {
            if (y - ship.getTaille() < 0) {
                return false;
            }
            dy = -1;
        } else if (o == Orientation.WEST) {
            if (x - ship.getTaille() < 0) {
                return false;
            }
            dx = -1;
        }

        int ix = x;
        int iy = y;

        for (int i = 0; i < ship.getTaille(); ++i) {
            if (board.hasShip(ix, iy)) {
                return false;
            }
            ix += dx;
            iy += dy;
        }

        return true;
    }

    /**
     * Seeks to provide guidance
     * @param c1
     * @param c2
     * @return
     */
    private boolean guessOrientation(int[] c1, int[] c2) {
        return c1[0] == c2[0];
    }

    /**
     * Whether or not the ship was hit
     * @param x
     * @param y
     * @return
     */
    private boolean isUndiscovered(int x, int y) {
        return x > 0 && x <= size && y > 0 && y <= size && board.getHit(x, y) == null;
    }

    /**
     * Select random coordinates
     * @return the coords
     */
    private int[] pickRandomCoord() {
        Random rnd = new Random();
        int x;
        int y;

        do {
            x = rnd.nextInt(size) + 1;
            y = rnd.nextInt(size) + 1;
        } while (!isUndiscovered(x, y));

        return new int[] { x, y };
    }

    /**
     * pick a coord verically around last known strike
     * 
     * @return suitable coord, or null if none is suitable
     */
    private int[] pickVCoord() {
        int x = lastStrike[0];
        int y = lastStrike[1];

        for (int iy : new int[] { y - 1, y + 1 }) {
            if (isUndiscovered(x, iy)) {
                return new int[] { x, iy };
            }
        }
        return null;
    }

    /**
     * pick a coord horizontally around last known strike
     * 
     * @return suitable coord, or null if none is suitable
     */
    private int[] pickHCoord() {
        int x = lastStrike[0];
        int y = lastStrike[1];

        for (int ix : new int[] { x - 1, x + 1 }) {
            if (isUndiscovered(ix, y)) {
                return new int[] { ix, y };
            }
        }
        return null;
    }
}
