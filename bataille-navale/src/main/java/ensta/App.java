package ensta;

import annexes.Board;
import annexes.Orientation;
import navires.Destroyer;

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
        table.print();

        //test de navires
        Destroyer ship_test = new Destroyer(Orientation.NORTH);
        System.out.println(ship_test.getOrientation());

    }
}
