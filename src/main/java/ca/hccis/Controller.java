package ca.hccis;

import ca.hccis.volleyball.Game;
import ca.hccis.util.CisUtility;

/**
 * Controls the overall flow of the program.
 *
 * @author cis1201
 * @since 20241113
 */
public class Controller {

    public static void main(String[] args) {

        System.out.println("Welcome to the volleyball project (" + CisUtility.getTodayString("yyyy-MM-dd") + ")");
        Game game = new Game();
        game.start();
    }
}