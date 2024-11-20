package Controller;

import Model.GameboardModel;
import Model.BarrierModel;
import Model.KIModel;
import Model.PlayerModel;

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

    /*
    //Fülle leeres Spielfeld mit Barrieren
    public void placeBarrier() {
        int plantCounter = 0;
        int stoneCounter = 0;
        int waterCounter = 0;

        for (int i = 0; i < gameboard.getGameboard().length; i++) {
            for (int j = 0; j < gameboard.getGameboard()[i].length; j++) {
                if (waterCounter < Barrier.randomBarrierMax() && gameboard.getGameboard()[i][j].equals(" [ ]")) {
                    Barrier waterbarrier = new BarrierModel("water", asciiArts.blau + "≋" + asciiArts.farbReset, 15, randomNumberRow()
                            , randomNumberColumn());
                    gameboard[waterbarrier.getPosZeile()][waterbarrier.getPosSpalte()] = " [" + waterbarrier.getSymbol() + "]";
                    waterCounter++;
                } else if (stoneCounter < Barrier.randomBarrierMax() && gameboard.getGameboard()[i][j].equals(" [ ]")) {
                    Barrier stoneBarrier = new BarrierModel("stone", "▲", 20, randomNumberRow()
                            , randomNumberColumn());
                    gameboard[stoneBarrier.getPosZeile()][stoneBarrier.getPosSpalte()] = " [" + stoneBarrier.getSymbol() + "]";
                    stoneCounter++;
                } else if (plantCounter < Barrier.randomBarrierMax() && gameboard.getGameboard()[i][j].equals(" [ ]")) {
                    Barrier plantBarrier = new BarrierModel("plant", asciiArts.gruen + "♣" + asciiArts.farbReset, 10, randomNumberRow()
                            , randomNumberColumn());
                    gameboard[plantBarrier.getPosZeile()][plantBarrier.getPosSpalte()] = " [" + plantBarrier.getSymbol() + "]";
                    plantCounter++;
                }
            }
        }
    }

     */

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
