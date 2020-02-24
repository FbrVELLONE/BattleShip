package annexes;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import navires.*;

public class Game {

    /*
     * *** Constante
     */
    public static final File SAVE_FILE = new File("savegame.dat");

    /*
     * *** Attributs
     */
    private Player player1;
    private AIPlayer player2;
    private Scanner sin;
    /*
     * *** Constructeurs
     */
    public Game() {
    }

    public Game init() {
        if (!loadSave()) {
            // init attributes
            System.out.println("entre ton nom:");
            
            // TODO use a scanner to read player name
            sin = new Scanner(System.in);
            
            // TODO init boards
            Board b1, b2;
            b1 = new Board(sin.nextLine());
            b2 = new Board("AI");
            
            // TODO init this.player1 & this.player2
            List<AbstractShip> ships_p1 = new ArrayList<AbstractShip>();
            Submarine sub_p1 = new Submarine();
            Submarine sub2_p1 = new Submarine();
            Destroyer dest_p1 = new Destroyer();
            Carrier car_p1 = new Carrier();
            Battleship battle_p1 = new Battleship();
            ships_p1.add(dest_p1);
            ships_p1.add(sub_p1);
            ships_p1.add(sub2_p1);
            ships_p1.add(battle_p1);
            ships_p1.add(car_p1);
            
            this.player1 = new Player(b1, b2, ships_p1, "Alo");
            
            List<AbstractShip> ships_p2 = new ArrayList<AbstractShip>();
            Submarine sub_p2 = new Submarine();
            Submarine sub2_p2 = new Submarine();
            Destroyer dest_p2 = new Destroyer();
            Carrier car_p2 = new Carrier();
            Battleship battle_p2 = new Battleship();
            ships_p2.add(dest_p2);
            ships_p2.add(sub_p2);
            ships_p2.add(sub2_p2);
            ships_p2.add(battle_p2);
            ships_p2.add(car_p2);
            
            this.player2 = new AIPlayer(b2, b1, ships_p2, "AI");
            
            
            b1.print(player2.board);
            
            // place player ships
            player1.putShips();
            player2.putShips();
        }
        return this;
    }

    /*
     * *** Méthodes
     */
    public void run() {
        int[] coords = new int[2];
        Board b1 = player1.board;
        Board b2 = player2.board;
        Hit hit;

        // main loop
        b1.print(player2.board);
        boolean done;
        do {

                hit = player1.sendHit(coords); // TODO player1 send a hit  
                boolean strike = hit != Hit.MISS && hit != null; // TODO set this hit on his board (b1)
                
                done = updateScore();
                System.out.println(makeHitMessage(false /* outgoing hit */, coords, hit));
                
                save();
                
                if (!done && !strike) {
                    do {
                        hit = player2.sendHit(coords); // TODO player2 send a hit.
                        
                        strike = hit != Hit.MISS;
                        if (strike) {
                            b1.print(player2.board);
                        }
                        System.out.println(makeHitMessage(true /* incoming hit */, coords, hit));
                        done = updateScore();
                        
                        if (!done) {
                            save();
                        }
                    }while (strike && !done);
                }
                
            System.out.println(player1.name);
            b1.print(player2.board);
            System.out.println(player2.name);
            b2.print(player1.board);
        } while (!done);

        SAVE_FILE.delete();
        System.out.println(String.format("joueur %d gagne", player1.lose ? 2 : 1));
        sin.close();
    }

    private void save() {
        // try {
        //     // TODO bonus 2 : uncomment
        //     // if (!SAVE_FILE.exists()) {
        //     // SAVE_FILE.getAbsoluteFile().getParentFile().mkdirs();
        //     // }

        //     // TODO bonus 2 : serialize players

        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }

    private boolean loadSave() {
        if (SAVE_FILE.exists()) {
            // try {
            //     // TODO bonus 2 : deserialize players

            //     return true;
            // } catch (IOException | ClassNotFoundException e) {
            //     e.printStackTrace();
            // }
        }
        return false;
    }

    private boolean updateScore() {
        for (Player player : new Player[] { player1, player2 }) {
            int destroyed = 0;
            for (AbstractShip ship : player.getShips()) {
                if (ship.isSunk()) {
                    destroyed++;
                }
            }

            player.destroyedCount = destroyed;
            player.lose = destroyed == player.getShips().length;
            if (player.lose) {
                return true;
            }
        }
        return false;
    }

    private String makeHitMessage(boolean incoming, int[] coords, Hit hit) {
        String msg;
        ColorUtil.Color color = ColorUtil.Color.RESET;
        if(hit == null){
            msg = "hit est null";
        }else{
            switch (hit) {
            case MISS:
                msg = hit.toString();
                break;
            case STRIKE:
                msg = hit.toString();
                color = ColorUtil.Color.RED;
                break;
            default:
                msg = hit.toString() + " coulé";
                color = ColorUtil.Color.RED;
            }
            msg = String.format("%s Frappe en %c%d : %s", incoming ? "<=" : "=>", ((char) ('A' + coords[0]-1)),
                    (coords[1]), msg);
        }
        return ColorUtil.colorize(msg, color);
    }

    private static List<AbstractShip> createDefaultShips() {
        return Arrays.asList(new AbstractShip[] { new Destroyer(), new Submarine(), new Submarine(), new Battleship(),
                new Carrier() });
    }
}
