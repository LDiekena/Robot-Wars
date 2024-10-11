public class Player {
    String name;
    static int posZeile;
    static int posSpalte;
    int winHistory;
    int lossHistory;
    Robot robot;

    //Constructor
    public Player(String name, int posZeile, int posSpalte, int winHistory, int lossHistory, Robot robot) {
        this.name = name;
        Player.posZeile = posZeile;
        Player.posSpalte = posSpalte;
        this.winHistory = winHistory;
        this.lossHistory = lossHistory;
        this.robot = robot;
    }

    //Methode zum Bewegen des Spielers
    public static void move(char zugEingabe, String gewaehlterAvatar, int posZeile, int posSpalte, boolean spielerZug, boolean gegnerZug) {
        Gameboard.gameboard[Player.posZeile][Player.posSpalte] = " [ ]";
        if (zugEingabe == '8') {
            Player.posZeile = posZeile - 1;
            Gameboard.gameboard[Player.posZeile][Player.posSpalte] = " [" + gewaehlterAvatar + "]";
            Game.spielerZug = false;
            Game.gegnerZug = true;
        } else if (zugEingabe == '4') {
            Player.posSpalte = posSpalte - 1;
            Gameboard.gameboard[Player.posZeile][Player.posSpalte] = " [" + gewaehlterAvatar + "]";
            Game.spielerZug = false;
            Game.gegnerZug = true;
        } else if (zugEingabe == '5') {
            Gameboard.gameboard[Player.posZeile][Player.posSpalte] = " [" + gewaehlterAvatar + "]";
            Game.spielerZug = false;
            Game.gegnerZug = true;
        } else if (zugEingabe == '6') {
            Player.posSpalte = posSpalte + 1;
            Gameboard.gameboard[Player.posZeile][Player.posSpalte] = " [" + gewaehlterAvatar + "]";
            Game.spielerZug = false;
            Game.gegnerZug = true;
        } else if (zugEingabe == '2') {
            Player.posZeile = posZeile + 1;
            Gameboard.gameboard[Player.posZeile][Player.posSpalte] = " [" + gewaehlterAvatar + "]";
            Game.spielerZug = false;
            Game.gegnerZug = true;
        }
    }
}
