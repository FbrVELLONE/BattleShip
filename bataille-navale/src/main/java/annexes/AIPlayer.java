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

    // TODO AIPlayer must not inherit "keyboard behavior" from player. Call ai
    // instead.
    public void putShips(){
        ai.putShips(ships);
    }

    public Hit sendHit(int[] coords){
        return ai.sendHit(coords);
    }

}
