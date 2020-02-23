package annexes;

import navires.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    }

    public void gameRun(){
        do {
            Random rnd = new Random(); 
            int x = rnd.nextInt(9) + 1;
            int y = rnd.nextInt(9) + 1;
            
            tShipsAI.putShips(tShips.toArray(new AbstractShip[tShips.size()]));
            tShipsAI.sendHit(new int[]{x,y});
            System.out.println("here");
            if(board.getNavires()[y][x].isSunk()){
                compteurNavires++;
            }
            System.out.println("here 2");
            board.print(board);
        } while (compteurNavires != 5);
    }
}