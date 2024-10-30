import java.util.Random;

public class Gameboard {
    static int rows;
    static int cols;
    static String[][] gameboard;


    //Konstruktor
    public Gameboard(int rows, int cols) {
        Gameboard.rows = rows;
        Gameboard.cols = cols;
        gameboard = new String[rows][cols];
    }

    //Methode für zufällige Zeile
    public static int randomNumberRow() {
        Random r = new Random();
        return r.nextInt(9);
    }

    //Methode für zufällige Spalte
    public static int randomNumberColumn() {
        Random r = new Random();
        return r.nextInt(14);
    }

    //Generiere leeres Spielfeld
    public void fillStartboard() {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                gameboard[i][j] = " [ ]";
            }
        }
    }

    //Fülle leeres Spielfeld mit Barrieren
    public void placeBarrier() {
        int plantCounter = 0;
        int stoneCounter = 0;
        int waterCounter = 0;

        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                if (waterCounter < Barrier.randomBarrierMax() && gameboard[i][j].equals(" [ ]")) {
                    Barrier waterbarrier = new Barrier("water", ASCII_Arts.blau + "≋" + ASCII_Arts.farbReset, 15, randomNumberRow()
                            , randomNumberColumn());
                    gameboard[waterbarrier.posZeile][waterbarrier.posSpalte] = " [" + waterbarrier.symbol + "]";
                    waterCounter++;
                } else if (stoneCounter < Barrier.randomBarrierMax() && gameboard[i][j].equals(" [ ]")) {
                    Barrier stoneBarrier = new Barrier("stone", "▲", 20, randomNumberRow()
                            , randomNumberColumn());
                    gameboard[stoneBarrier.posZeile][stoneBarrier.posSpalte] = " [" + stoneBarrier.symbol + "]";
                    stoneCounter++;
                } else if (plantCounter < Barrier.randomBarrierMax() && gameboard[i][j].equals(" [ ]")) {
                    Barrier plantBarrier = new Barrier("plant", ASCII_Arts.gruen + "♣" + ASCII_Arts.farbReset, 10, randomNumberRow()
                            , randomNumberColumn());
                    gameboard[plantBarrier.posZeile][plantBarrier.posSpalte] = " [" + plantBarrier.symbol + "]";
                    plantCounter++;
                }
            }
        }
    }

    //Platziere Spieler und Gegner auf dem Spielfeld
    public void placeRobots(String gewaehlterAvatar, String gegner) {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                if (i == Player.posZeile && j == Player.posSpalte) {
                    gameboard[i][j] = " [" + gewaehlterAvatar + "]";
                } else if (i == KI.posZeile && j == KI.posSpalte) {
                    if (!gameboard[i][j].equals(" [" + gewaehlterAvatar + "]")) {
                        gameboard[i][j] = " [" + gegner + "]";
                    } else {
                        gameboard[i + 1][j + 1] = " [" + gegner + "]";
                        //TODO: Randomize neue Position
                    }
                }
            }
        }
    }

    public void printGameBoard() {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                System.out.print(gameboard[i][j]);
            }
            System.out.println();
        }
    }

}
