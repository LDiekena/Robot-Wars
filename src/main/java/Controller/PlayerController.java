package Controller;

import Model.GameModel;
import Model.GameboardModel;
import Model.KIModel;
import Model.PlayerModel;

public class PlayerController {

    //Methode zum Bewegen des Spielers
    public void move(char zugEingabe, boolean spielerZug, boolean gegnerZug, PlayerModel player, GameboardModel gameboard, GameModel game) {
        gameboard.getGameboard()[player.getPosZeile()][player.getPosSpalte()] = " [ ]";
        if (zugEingabe == '8') {
            player.setPosZeile(player.getPosZeile() - 1);
            gameboard.getGameboard()[player.getPosZeile()][player.getPosSpalte()] = " [" + player.getRobotModel().getSymbol() + "]";
            game.setSpielerZug(false);
            game.setGegnerZug(true);
        } else if (zugEingabe == '4') {
            player.setPosSpalte(player.getPosSpalte() - 1);
            gameboard.getGameboard()[player.getPosZeile()][player.getPosSpalte()] = " [" + player.getRobotModel().getSymbol() + "]";
            game.setSpielerZug(false);
            game.setGegnerZug(true);
        } else if (zugEingabe == '5') {
            gameboard.getGameboard()[player.getPosZeile()][player.getPosSpalte()] = " [" + player.getRobotModel().getSymbol() + "]";
            game.setSpielerZug(false);
            game.setGegnerZug(true);
        } else if (zugEingabe == '6') {
            player.setPosSpalte(player.getPosSpalte() + 1);
            gameboard.getGameboard()[player.getPosZeile()][player.getPosSpalte()] = " [" + player.getRobotModel().getSymbol() + "]";
            game.setSpielerZug(false);
            game.setGegnerZug(true);
        } else if (zugEingabe == '2') {
            player.setPosZeile(player.getPosZeile() + 1);
            gameboard.getGameboard()[player.getPosZeile()][player.getPosSpalte()] = " [" + player.getRobotModel().getSymbol() + "]";
            game.setSpielerZug(false);
            game.setGegnerZug(true);
        }
    }

    //Methode zum Angreifen vom Spieler
    public void attack(PlayerModel playerModel, KIModel enemy) {
        enemy.getRobotModel().setHealth(enemy.getRobotModel().getHealth() - playerModel.getRobotModel().getDamage());
    }
}
