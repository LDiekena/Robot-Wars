package Controller;

import Model.GameModel;
import Model.GameboardModel;
import Model.KIModel;
import Model.PlayerModel;

import java.util.Random;

public class KIController {

    //Methode für zufälligen Gegnerzug
    public static char randomGegnerzug() {
        char gegnerzug = ' ';
        Random r = new Random();
        int randomNumber = r.nextInt(5);
        if (randomNumber == 0) {
            gegnerzug = '2';
        } else if (randomNumber == 1) {
            gegnerzug = '4';
        } else if (randomNumber == 2) {
            gegnerzug = '5';
        } else if (randomNumber == 3) {
            gegnerzug = '6';
        } else if (randomNumber == 4) {
            gegnerzug = '8';
        }
        return gegnerzug;
    }

    //Methode zum Bewegen des Bots
    public void move(char gegnerZugEingabe, KIModel enemy, boolean spielerZug, boolean gegnerZug, GameboardModel gameboard, GameModel game) {
        gameboard.getGameboard()[enemy.getPosZeile()][enemy.getPosSpalte()] = " [ ]";
        if (gegnerZugEingabe == '8') {
            enemy.setPosZeile(enemy.getPosZeile() - 1);
            gameboard.getGameboard()[enemy.getPosZeile()][enemy.getPosSpalte()] = " [" + enemy.getRobotModel().getSymbol() + "]";
            game.setSpielerZug(true);
            game.setGegnerZug(false);
        } else if (gegnerZugEingabe == '4') {
            enemy.setPosSpalte(enemy.getPosSpalte() - 1);
            gameboard.getGameboard()[enemy.getPosZeile()][enemy.getPosSpalte()] = " [" + enemy.getRobotModel().getSymbol() + "]";
            game.setSpielerZug(true);
            game.setGegnerZug(false);
        } else if (gegnerZugEingabe == '5') {
            gameboard.getGameboard()[enemy.getPosZeile()][enemy.getPosSpalte()] = " [" + enemy.getRobotModel().getSymbol() + "]";
            game.setSpielerZug(true);
            game.setGegnerZug(false);
        } else if (gegnerZugEingabe == '6') {
            enemy.setPosSpalte(enemy.getPosSpalte() + 1);
            gameboard.getGameboard()[enemy.getPosZeile()][enemy.getPosSpalte()] = " [" + enemy.getRobotModel().getSymbol() + "]";
            game.setSpielerZug(true);
            game.setGegnerZug(false);
        } else if (gegnerZugEingabe == '2') {
            enemy.setPosZeile(enemy.getPosZeile() + 1);
            gameboard.getGameboard()[enemy.getPosZeile()][enemy.getPosSpalte()] = " [" + enemy.getRobotModel().getSymbol() + "]";
            game.setSpielerZug(true);
            game.setGegnerZug(false);
        }
    }

    //Methode zum Angreifen von der KI
    public void attack(KIModel enemy, PlayerModel player) {
        player.getRobotModel().setHealth(player.getRobotModel().getHealth() - enemy.getRobotModel().getDamage());
    }
}
