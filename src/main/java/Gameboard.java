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
    public static int randomNumberRow () {
        Random r = new Random();
        return r.nextInt(9);
    }

    //Methode für zufällige Spalte
    public static int randomNumberColumn () {
        Random r = new Random();
        return r.nextInt(14);
    }

    public static void fillStartboard() {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                gameboard[i][j] = " [ ]";
            }
        }
    }

    public static void printGameBoard() {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                System.out.print(gameboard[i][j]);
            }
            System.out.println();
        }
    }

    public boolean isMoveValid(int row, int col) {
        return true; //Platzhalter
    }

}
