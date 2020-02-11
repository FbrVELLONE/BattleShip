package ensta;

import annexes.AbstractShip;
import annexes.Board;

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
        Board table = new Board("Test");
        table.print();
    }
}
