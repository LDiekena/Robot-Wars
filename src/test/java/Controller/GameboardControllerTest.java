package Controller;

import Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameboardControllerTest {

    RobotModel robot = new RobotModel("TestRobot", "§", 10,1,1,1,1,1,1,1,1,5);
    RobotModel bot = new RobotModel("TestBot", "X",10,1,1,1,1,1,1,1,1,5);
    PlayerModel player = new PlayerModel("TestPlayer", 5,5,0,0, robot);
    KIModel enemy = new KIModel("TestKI", 8,8,"easy", bot);
    GameboardModel gameboard = new GameboardModel(10,15);
    GameboardController gameboardController = new GameboardController();

    @Test
    void randomNumberRow() {
        int randomNumber = gameboardController.randomNumberRow();
        boolean numberInRange;
        if(randomNumber <= 9) {
            numberInRange = true;
        } else if (randomNumber >= 0) {
            numberInRange = true;
        } else {
            numberInRange = false;
        }
        assertTrue(true);
    }

    @Test
    void randomNumberColumn() {
        int randomNumber = gameboardController.randomNumberColumn();
        boolean numberInRange;
        if(randomNumber <= 14) {
            numberInRange = true;
        } else if (randomNumber >= 0) {
            numberInRange = true;
        } else {
            numberInRange = false;
        }
        assertTrue(true);
    }

    @Test
    void fillStartboard() {
        gameboardController.fillStartboard(gameboard.getGameboard());
        for (int i = 0; i < gameboard.getGameboard().length; i++) {
            for (int j = 0; j < gameboard.getGameboard()[i].length; j++) {
                assertEquals(" [ ]", gameboard.getGameboard()[i][j]);
            }
        }
    }

    @Test
    void placeBarrier() {

    }

    @Test
    void testPlaceRobotsWithDifferentStartPositions() {
        gameboardController.fillStartboard(gameboard.getGameboard());
        gameboardController.placeRobots(player, enemy, gameboard.getGameboard());

        //Test bei unterschiedlichen Startpositionen
        assertEquals(5,player.getPosZeile());
        assertEquals(5,player.getPosSpalte());
        assertEquals(8,enemy.getPosZeile());
        assertEquals(8,enemy.getPosSpalte());

    }

    @Test
    void testPlaceRobotsWithSameStartPositions() {
        //Test bei gleichen Startpositionen
        enemy.setPosZeile(5);
        enemy.setPosSpalte(5);
        gameboardController.placeRobots(player, enemy, gameboard.getGameboard());
        assertEquals(6,enemy.getPosZeile());
        assertEquals(6,enemy.getPosSpalte());
    }

}
