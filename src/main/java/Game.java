public class Game {
    //Attribute für einen Spielzug
    public static char zugEingabe;
    public static char gegnerZugEingabe;
    public static boolean spielerZug;
    public static boolean gegnerZug;

    public Game(char zugEingabe, char gegnerZugEingabe, boolean spielerZug, boolean gegnerZug) {
        Game.zugEingabe = zugEingabe;
        Game.gegnerZugEingabe = gegnerZugEingabe;
        Game.spielerZug = spielerZug;
        Game.gegnerZug = gegnerZug;
    }

    public void gameRound() {
        //TODO: Aus main hier rüber?
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

    //TODO: Barrier Abfrage/ Feld muss leer sein, Implementierung "Kampf" gegen Barrier, erst nach Sieg weiter move (5 LP pro Hit)
    //Methode zum Prüfen ob eine Barriere im Weg ist
    public boolean testBarrierInWay(int posZeile, int posSpalte, char zugEingabe) {
        if (zugEingabe == '2' && Gameboard.gameboard[posZeile - 1][posSpalte] != " [ ]") {
            return false;
        } else if (zugEingabe == '4' && Gameboard.gameboard[posZeile][posSpalte - 1] != " [ ]") {
            return false;
        } else if (zugEingabe == '5') {
            return true;
        } else if (zugEingabe == '6' && Gameboard.gameboard[posZeile][posSpalte + 1] != " [ ]") {
            return false;
        } else if (zugEingabe == '8' && Gameboard.gameboard[posZeile + 1][posSpalte] != " [ ]") {
            return false;
        }
        return true;
    }

}
