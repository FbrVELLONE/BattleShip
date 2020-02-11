package ensta;

import annexes.AbstractShip;
import annexes.Board;

/**
 * Pour éxecuter: mvn exec:java
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Board table = new Board("test");
        table.print();
    }
}
