package Controller;

import Model.GameboardModel;
import Model.BarrierModel;
import Model.KIModel;
import Model.PlayerModel;
import View.GameView;
import View.GameboardView;

import java.util.Random;

public class GameboardController {


    //Methode für zufällige Zeile
    public int randomNumberRow() {
        Random r = new Random();
        return r.nextInt(9);
    }

    //Methode für zufällige Spalte
    public int randomNumberColumn() {
        Random r = new Random();
        return r.nextInt(14);
    }

    //Generiere leeres Spielfeld
    public void fillStartboard(String [][] gameboard) {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                gameboard[i][j] = " [ ]";
            }
        }
    }

    //Methode zum Platzieren der Barrieren
    public void placeBarrier(GameboardModel gameboard, BarrierController barrierController, GameView gameView) {
        int plantCounter = 0;
        int stoneCounter = 0;
        int waterCounter = 0;

        for (int i = 0; i < gameboard.getGameboard().length; i++) {
            for (int j = 0; j < gameboard.getGameboard()[i].length; j++) {
                if (waterCounter < barrierController.randomBarrierMax() && gameboard.getGameboard()[i][j].equals(" [ ]")) {
                    BarrierModel waterBarrier = new BarrierModel("water", gameView.blau + "≋" + gameView.farbReset, 15, randomNumberRow()
                            , randomNumberColumn());
                    gameboard.getGameboard()[waterBarrier.getPosZeile()][waterBarrier.getPosSpalte()] = " [" + waterBarrier.getSymbol() + "]";
                    waterCounter++;
                } else if (stoneCounter < barrierController.randomBarrierMax() && gameboard.getGameboard()[i][j].equals(" [ ]")) {
                    BarrierModel stoneBarrier = new BarrierModel("stone", "▲", 20, randomNumberRow()
                            , randomNumberColumn());
                    gameboard.getGameboard()[stoneBarrier.getPosZeile()][stoneBarrier.getPosSpalte()] = " [" + stoneBarrier.getSymbol() + "]";
                    stoneCounter++;
                } else if (plantCounter < barrierController.randomBarrierMax() && gameboard.getGameboard()[i][j].equals(" [ ]")) {
                    BarrierModel plantBarrier = new BarrierModel("plant", gameView.gruen + "♣" + gameView.farbReset, 10, randomNumberRow()
                            , randomNumberColumn());
                    gameboard.getGameboard()[plantBarrier.getPosZeile()][plantBarrier.getPosSpalte()] = " [" + plantBarrier.getSymbol() + "]";
                    plantCounter++;
                }
            }
        }
    }



    //Platziere Spieler und Gegner auf dem Spielfeld
    public void placeRobots(PlayerModel player, KIModel enemy, String[][] gameboard) {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                if (i == player.getPosZeile() && j == player.getPosSpalte()) {
                    gameboard[i][j] = " [" + player.getRobotModel().getSymbol() + "]";
                } else if (i == enemy.getPosZeile() && j == enemy.getPosSpalte()) {
                    if (!gameboard[i][j].equals(" [" + player.getRobotModel().getSymbol() + "]")) {
                        gameboard[i][j] = " [" + enemy.getRobotModel().getSymbol() + "]";
                    } else {
                        gameboard[i + 1][j + 1] = " [" + enemy.getRobotModel().getSymbol() + "]";
                        //TODO: Randomize neue Position
                    }
                }
            }
        }
    }
}
