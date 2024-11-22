package Model;

public class GameboardModel {

    private final int rows;
    private final int cols;
    private final String[][] gameboard;


    //Konstruktor
    public GameboardModel(int rows, int cols) {
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

    public String[][] getGameboard() {
        return gameboard;
    }
}
