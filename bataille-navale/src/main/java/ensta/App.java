/**
 * Project for IN205 subject (JAVA):
 *  Battleships
 * 
 * Authors of the project:
 *  David Velasquez Ospina
 *  Fabricio Vellone
 * 
 * 
 */
package ensta;
import annexes.*;

/**
 * Class responsible for executing and starting the game .
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Game game = new Game();
        game.init();
        game.run();
    }

}
