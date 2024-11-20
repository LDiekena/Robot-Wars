package View;

import Model.GameboardModel;

public class GameboardView {

    //Ausgabe Spielfeld
    public void printGameboard(String[][] gameboard) {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                System.out.print(gameboard[i][j]);
            }
            System.out.println();
        }
    }

    public void printPrepareMessage() {
        System.out.println("Das Spielfeld wird für das Spiel vorbereitet.\n");
    }
}
