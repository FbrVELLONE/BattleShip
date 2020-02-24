package annexes;

import navires.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TestGame
 */
public class TestGame {
    Board board;
    int compteurNavires;

    Submarine tSub;
    Submarine tSub2;
    Destroyer tDest;
    Carrier tCar;
    Battleship tBattle;

    List<AbstractShip> tShips;

    BattleShipsAI tShipsAI;

    public TestGame(){
        this.board = new Board("Test");
        this.board.print(board);
        this.compteurNavires = 0;

        this.tSub = new Submarine();
        this.tSub2 = new Submarine();
        this.tDest = new Destroyer();
        this.tCar = new Carrier();
        this.tBattle = new Battleship();

        this.tShips = new ArrayList<AbstractShip>();
        tShips.add(tSub);
        tShips.add(tSub2);
        tShips.add(tDest);
        tShips.add(tCar);
        tShips.add(tBattle);

        this.tShipsAI = new BattleShipsAI(board, board);
        tShipsAI.putShips(tShips.toArray(new AbstractShip[tShips.size()]));
    }

    public void gameRun(){
        do {
            int[] hitCoords = new int[2];
            tShipsAI.sendHit(hitCoords);
            if (board.getNavires()[hitCoords[1] -1][hitCoords[0] - 1] != null)
                if(board.getNavires()[hitCoords[1] -1][hitCoords[0] - 1].isSunk()){
                    ++compteurNavires;
                }
            
            board.print(board);
        } while (compteurNavires != 5);
    }
}