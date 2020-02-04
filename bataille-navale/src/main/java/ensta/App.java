package ensta;

import annexes.AbstractShip;
import annexes.Board;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Board table = new Board("suka");
        Character[] labels = {'D','E','S','T','R'};
        table.print();
    }
}
