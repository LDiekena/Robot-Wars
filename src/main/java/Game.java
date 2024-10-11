public class Game {
    //Attribute für einen Spielzug
    public static char zugEingabe;
    public static char gegnerZugEingabe;
    public static boolean spielerZug;
    public static boolean gegnerZug;

    public Game (char zugEingabe, char gegnerZugEingabe, boolean spielerZug, boolean gegnerZug) {
        Game.zugEingabe = zugEingabe;
        Game.gegnerZugEingabe = gegnerZugEingabe;
        Game.spielerZug = spielerZug;
        Game.gegnerZug = gegnerZug;
    }

    /*
    //Methode für die Startpositionen
    //Spielerposition und Gegnerposition auf Spielfeld einfügen
        for (int i = 0; i < Gameboard.gameboard.length; i++) {
        for (int j = 0; j < Gameboard.gameboard[i].length; j++) {
            if (i == player.posZeile && j == player.posSpalte) {
                Gameboard.gameboard[i][j] = " [" + gewaehlterAvatar.symbol + "]";
            } else if (i == gegner.posZeile && j == gegner.posSpalte) {
                if (Gameboard.gameboard[i][j].equals(" [ ]")) {
                    Gameboard.gameboard[i][j] = " [" + gegner.robot.symbol + "]";
                } else {
                    Gameboard.gameboard[i+1][j+1] = " [" + gegner.robot.symbol + "]";
                    //TODO: Randomize neue Position
                }
            }
        }
    }

     */
}
