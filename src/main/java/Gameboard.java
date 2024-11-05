import java.util.Random;

public class Gameboard {
    ASCII_Arts asciiArts = new ASCII_Arts();
    private final int rows;
    private final int cols;
    private final String[][] gameboard;


    //Konstruktor
    public Gameboard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        gameboard = new String[rows][cols];
    }

    //Getter
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public  String[][] getGameboard() {
        return gameboard;
    }


    //TODO: Koordinaten auslagern

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
                    Barrier waterbarrier = new Barrier("water", asciiArts.blau + "≋" + asciiArts.farbReset, 15, randomNumberRow()
                            , randomNumberColumn());
                    gameboard[waterbarrier.getPosZeile()][waterbarrier.getPosSpalte()] = " [" + waterbarrier.getSymbol() + "]";
                    waterCounter++;
                } else if (stoneCounter < Barrier.randomBarrierMax() && gameboard[i][j].equals(" [ ]")) {
                    Barrier stoneBarrier = new Barrier("stone", "▲", 20, randomNumberRow()
                            , randomNumberColumn());
                    gameboard[stoneBarrier.getPosZeile()][stoneBarrier.getPosSpalte()] = " [" + stoneBarrier.getSymbol() + "]";
                    stoneCounter++;
                } else if (plantCounter < Barrier.randomBarrierMax() && gameboard[i][j].equals(" [ ]")) {
                    Barrier plantBarrier = new Barrier("plant", asciiArts.gruen + "♣" + asciiArts.farbReset, 10, randomNumberRow()
                            , randomNumberColumn());
                    gameboard[plantBarrier.getPosZeile()][plantBarrier.getPosSpalte()] = " [" + plantBarrier.getSymbol() + "]";
                    plantCounter++;
                }
            }
        }
    }

    //Platziere Spieler und Gegner auf dem Spielfeld
    public void placeRobots(String gewaehlterAvatar, String gegner, int playerPosZeile, int playerPosSpalte, int gegnerPosZeile, int gegnerPosSpalte) {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                if (i == playerPosZeile && j == playerPosSpalte) {
                    gameboard[i][j] = " [" + gewaehlterAvatar + "]";
                } else if (i == gegnerPosZeile && j == gegnerPosSpalte) {
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
