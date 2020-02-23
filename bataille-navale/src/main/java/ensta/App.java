package ensta;

import navires.*;

import java.util.ArrayList;
import java.util.List;

import annexes.*;

/**
 * Exercice 1.
 * 
 * Creation de la classe Board
 * Pour éxecuter: mvn exec:java
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //test de board
        Board table = new Board("Test");
        Board table_2 = new Board("Test_2");
        table.print(table_2);

        Submarine sub = new Submarine();
        Submarine sub2 = new Submarine();
        Destroyer dest = new Destroyer();
        Carrier car = new Carrier();
        Battleship battle = new Battleship();

        List<AbstractShip> ships = new ArrayList<AbstractShip>();
        ships.add(dest);
        ships.add(sub);
        ships.add(sub2);
        ships.add(battle);
        ships.add(car);

        Player Cachorra = new Player(table,table_2,ships);
        Player Cachorra2 = new Player(table_2,table,ships);

        int[] hitCoords = new int[]{1,1};
        Cachorra.putShips();
        Cachorra2.sendHit(hitCoords);    
        table_2.print(table_2);
    }
}
