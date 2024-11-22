package Controller;

import Model.GameModel;
import Model.GameboardModel;
import Model.KIModel;
import Model.PlayerModel;
import View.GameView;
import View.GameboardView;
import View.KIView;
import View.PlayerView;

import java.util.Objects;

public class GameController {

    //Abfrage Usereingabe ist gültig
    public boolean isAvatarChoiceValid(int playerInput) {
        if(playerInput == 1 || playerInput == 2) {
            return true;
        } else {
            return false;
        }
    }

    //Ablauf einer Spielrunde
    public void gameRound(PlayerModel player, KIModel enemy, GameboardModel gameboard, GameModel game, GameboardView gameboardView, GameView gameView, PlayerView playerView, KIView kiView, KIController kiController, PlayerController playerController) {

        while (player.getRobotModel().getHealth() >= 0 && enemy.getRobotModel().getHealth() >= 0) {

            //Spielerzug
            while (game.getSpielerZug()) {
                int playerMoveCounter = player.getRobotModel().getMobility();

                while (playerMoveCounter >= 1) {
                    char zugEingabe = gameView.printPlayerTurnMessageAndAskInput(player);
                    game.setZugEingabe(zugEingabe);

                    if (isMoveValid(player.getPosZeile(), player.getPosSpalte(), game.getZugEingabe())) { // && game.testBarrierInWay(posZeile, posSpalte, zugEingabe)
                        playerController.move(zugEingabe, game.getSpielerZug(), game.getGegnerZug(), player, gameboard, game);
                        playerView.printUpdatedPlayerPositionText(player);
                        playerMoveCounter--;

                        //Optische Ausgabe des Spielerzuges
                        if (Objects.equals(player.getRobotModel().getSymbol(), " [" + gameView.cyan + player.getRobotModel().getSymbol() + gameView.farbReset + "]")) {
                            gameView.printPlayerTurn(1);

                        } else if (Objects.equals(player.getRobotModel().getSymbol(), " [" + gameView.purple + player.getRobotModel().getSymbol() + gameView.farbReset + "]")) {
                            gameView.printPlayerTurn(2);
                        }

                        gameboardView.printGameboard(gameboard.getGameboard());

                    } else {
                        gameView.printErrorPlayerMoveMessage();
                    }
                }
                //Abfrage ob Gegner in Angriffsreichweite ist (nach Beendigung der Bewegung)
                if(playerCanAttack(player, enemy)) {
                    int playerAttackChoice = gameView.printEnemyInAttackRangeMessage();
                    if(playerAttackChoice == 1) {
                        //Angriff beendet Bewegung
                        playerMoveCounter = 0;
                        playerController.attack(player, enemy);
                        gameView.printPlayerAttackSuccessfullMessage(player, enemy);
                    } else {
                        //TODO: Bewegungszüge noch übrig, weitere Bewegung möglich noch nicht implementiert
                        //TODO: Shield noch nicht implementiert
                    }
                }

            }

            //Spieler hat Gegner besiegt -> Spielersieg
            if (enemy.getRobotModel().getHealth() <= 0) {
                gameView.printWinner(1);
                player.setWinHistory(player.getWinHistory() + 1);
            } else {

                //Gegnerzug
                while (game.getGegnerZug()) {
                    int gegnerMoveCounter = enemy.getRobotModel().getMobility();

                    //Wiederholung Bewegung bis Gegner keine Züge mehr übrig hat
                    while (gegnerMoveCounter >= 1) {
                        gameView.printEnemyTurnMessage(enemy);
                        //java.lang.Thread.sleep(1500); //Künstliche Pause

                        char gegnerZugEingabe = KIController.randomGegnerzug(); //TODO: Übergabe difficulty für später
                        game.setGegnerZugEingabe(gegnerZugEingabe);
                        gameView.printEnemyTurnChoice(gegnerZugEingabe);

                        //Abfrage Zug ist gültig
                        if (isMoveValid(enemy.getPosZeile(), enemy.getPosSpalte(), game.getGegnerZugEingabe())) { // && game.testBarrierInWay(posZeile, posSpalte, zugEingabe)
                            kiController.move(gegnerZugEingabe, enemy, game.getSpielerZug(), game.getGegnerZug(), gameboard, game);
                            kiView.printUpdatedEnemyPositionText(enemy);
                            gegnerMoveCounter--;

                            //Ausgabe des Gegnerzuges
                            gameView.printEnemyTurn();
                            gameboardView.printGameboard(gameboard.getGameboard());

                        } else {
                            gameView.printErrorEnemyMoveMessage();
                            gegnerZugEingabe = KIController.randomGegnerzug(); //TODO: Übergabe difficulty für später
                            game.setGegnerZugEingabe(gegnerZugEingabe);
                        }
                    }

                    //Abfrage ob Spieler in Angriffsreichweite ist (nach Beendigung der Bewegung)
                    if(gegnerCanAttack(enemy, player)) {
                        //Angriff beendet Bewegungsmöglichkeit, TODO: später Auswahl an alternativer Hadnlungen
                        gegnerMoveCounter = 0;

                        //Angriff
                        gameView.printPlayerInAttackRangeMessage();
                        kiController.attack(enemy, player);
                        gameView.printEnemyAttackSuccessfullMessage(enemy, player);
                    }
                }

                //Gegner besiegt Spieler -> Gegnersieg
                if (player.getRobotModel().getHealth() <= 0) {
                    gameView.printWinner(2);
                    player.setLossHistory(player.getLossHistory() + 1);
                }
            }
        }
    }

    //Methode Zuggültigkeit
    public boolean isMoveValid(int posZeile, int posSpalte, char zugEingabe) {
        if (posZeile == 9 && zugEingabe == '2') {
            return false;
        } else if (posZeile == 0 && zugEingabe == '8') {
            return false;
        } else if (posSpalte == 14 && zugEingabe == '6') {
            return false;
        } else if (posSpalte == 0 && zugEingabe == '4') {
            return false;
        } else {
            return true;
        }
    }

    /*
    //TODO: Barrier Abfrage/ Feld muss leer sein, Implementierung "Kampf" gegen Barrier, erst nach Sieg weiter move
    //Methode zum Prüfen ob eine Barriere im Weg ist
    public boolean testBarrierInWay(int posZeile, int posSpalte, char zugEingabe) {
        if (zugEingabe == '2' && runGame.board.getGameboard()[posZeile - 1][posSpalte] != " [ ]") {
            return false;
        } else if (zugEingabe == '4' && runGame.board.getGameboard()[posZeile][posSpalte - 1] != " [ ]") {
            return false;
        } else if (zugEingabe == '5') {
            return true;
        } else if (zugEingabe == '6' && runGame.board.getGameboard()[posZeile][posSpalte + 1] != " [ ]") {
            return false;
        } else if (zugEingabe == '8' && runGame.board.getGameboard()[posZeile + 1][posSpalte] != " [ ]") {
            return false;
        }
        return true;
    }

     */

    //Methode Abfrage ob der Spieler den Gegner angreifen kann
    public boolean playerCanAttack(PlayerModel player, KIModel gegner) {
        int playerRightMaxRange = player.getPosSpalte() + player.getRobotModel().getRange();
        int playerDownMaxRange = player.getPosZeile() + player.getRobotModel().getRange();
        int playerLeftMaxRange = player.getPosSpalte() - player.getRobotModel().getRange();
        int playerUpMaxRange = player.getPosZeile() - player.getRobotModel().getRange();

        if (gegner.getPosSpalte() <= playerRightMaxRange && gegner.getPosSpalte() > player.getPosSpalte()
                || gegner.getPosZeile() <= playerDownMaxRange && gegner.getPosZeile() > player.getPosZeile()
                || gegner.getPosSpalte() >= playerLeftMaxRange && gegner.getPosSpalte() < player.getPosSpalte()
                || gegner.getPosZeile() >= playerUpMaxRange && gegner.getPosZeile() < player.getPosZeile()) {
            return true;
        } else {
            return false;
        }
    }

    //Methode Abfrage ob der Gegnner den Spieler angreifen kann
    public boolean gegnerCanAttack(KIModel gegner, PlayerModel player) {

        int gegnerRightMaxRange = gegner.getPosSpalte() + gegner.getRobotModel().getRange();
        int gegnerDownMaxRange = gegner.getPosZeile() + gegner.getRobotModel().getRange();
        int gegnerLeftMaxRange = gegner.getPosSpalte() - gegner.getRobotModel().getRange();
        int gegnerUpMaxRange = gegner.getPosZeile() - gegner.getRobotModel().getRange();

        // Gegner kann Spieler erreichen (horizontal und vertikal)
        if (player.getPosSpalte() <= gegnerRightMaxRange && player.getPosSpalte() > gegner.getPosSpalte()
                || player.getPosZeile() <= gegnerDownMaxRange && player.getPosZeile() > gegner.getPosZeile()
                || player.getPosSpalte() >= gegnerLeftMaxRange && player.getPosSpalte() < gegner.getPosSpalte()
                || player.getPosZeile() >= gegnerUpMaxRange && player.getPosZeile() < gegner.getPosZeile()) {
            return true;
        } else {
            return false;
        }
    }
}
