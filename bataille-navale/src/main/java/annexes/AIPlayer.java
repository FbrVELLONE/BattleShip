package annexes;

import java.io.Serializable;
import java.util.List;

import navires.*;
public class AIPlayer extends Player {
    /*
     * ** Attribut
     */
    private BattleShipsAI ai;

    /*
     * ** Constructeur
     */
    public AIPlayer(Board ownBoard, Board opponentBoard, List<AbstractShip> ships) {
        super(ownBoard, opponentBoard, ships);
        ai = new BattleShipsAI(ownBoard, opponentBoard);
    }
    /*
     * ** Constructeur
     */
    public AIPlayer(Board ownBoard, Board opponentBoard, List<AbstractShip> ships, String nom) {
        super(ownBoard, opponentBoard, ships, nom);
        ai = new BattleShipsAI(ownBoard, opponentBoard);
    }

    /**
     * Get the IA player to put the ships on your board
     */
    public void putShips(){
        ai.putShips(ships);
    }

    /**
     * causes the AI player to use the AI function to send the hits
     */
    public Hit sendHit(int[] coords){
        return ai.sendHit(coords);
    }

}
