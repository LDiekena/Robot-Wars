public class Game {
    //Attribute für einen Spielzug
    private char zugEingabe;
    private char gegnerZugEingabe;
    private boolean spielerZug;
    private boolean gegnerZug;

    //Konstruktor
    public Game(char zugEingabe, char gegnerZugEingabe, boolean spielerZug, boolean gegnerZug) {
        this.zugEingabe = zugEingabe;
        this.gegnerZugEingabe = gegnerZugEingabe;
        this.spielerZug = spielerZug;
        this.gegnerZug = gegnerZug;
    }

    //Getter
    public char getZugEingabe() {
        return zugEingabe;
    }

    public char getGegnerZugEingabe() {
        return gegnerZugEingabe;
    }

    public boolean getSpielerZug() {
        return spielerZug;
    }

    public boolean getGegnerZug() {
        return gegnerZug;
    }

    //Setter
    public void setZugEingabe(char zugEingabe) {
        this.zugEingabe = zugEingabe;
    }

    public void setGegnerZugEingabe(char gegnerZugEingabe) {
        this.gegnerZugEingabe = gegnerZugEingabe;
    }

    public void setSpielerZug(boolean spielerZug) {
        this.spielerZug = spielerZug;
    }

    public void setGegnerZug(boolean gegnerZug) {
        this.gegnerZug = gegnerZug;
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
        if (zugEingabe == '2' && runGame.board.getGameboard()[posZeile - 1][posSpalte] != " [ ]") {
            return false;
        } else if (zugEingabe == '4' && runGame.board.getGameboard()[posZeile][posSpalte - 1] != " [ ]") {
            return false;
        } else if (zugEingabe == '5') {
            return true;
        } else if (zugEingabe == '6' && runGame.board.getGameboard()[posZeile][posSpalte + 1] != " [ ]") {
            return false;
        } else if (zugEingabe == '8' && runGame.board.getGameboard()[posZeile + 1][posSpalte] != " [ ]") {
            return false;
        }
        return true;
    }

    //Methode zur Abfrage ob Roboter in Angriffsreichweite ist
    public boolean inRange(KI gegner, Player player) {
        //Spieler kann Gegner erreichen (horizontal und vertikal)
        //TODO: Betrachtung bislang nur genau die Reichweite erreicht, Implementierung auch für den Fall das man näher dran ist!
        if (player.getPosZeile() + player.getRobot().getRange() == gegner.getPosZeile() || player.getPosSpalte() + player.getRobot().getRange() == gegner.getPosSpalte()
        || player.getPosZeile() - player.getRobot().getRange() == gegner.getPosZeile() || player.getPosSpalte() - player.getRobot().getRange() == gegner.getPosSpalte()) {
            return true;
        // Gegner kann Spieler erreichen (horizontal und vertikal)
        } else if (gegner.getPosZeile() + gegner.getRobot().getRange() == player.getPosZeile() || gegner.getPosSpalte() + gegner.getRobot().getRange() == player.getPosSpalte()
        || gegner.getPosZeile() - gegner.getRobot().getRange() == player.getPosZeile() || gegner.getPosSpalte() - gegner.getRobot().getRange() == player.getPosSpalte()) {
            return true;
        //Spieler kann Gegner erreichen (diagonal)
        } else if (player.getPosZeile() + player.getRobot().getRange() == gegner.getPosZeile() && player.getPosSpalte() + player.getRobot().getRange() <= gegner.getPosSpalte()
                || player.getPosZeile() + player.getRobot().getRange() == gegner.getPosZeile() && player.getPosSpalte() - player.getRobot().getRange() <= gegner.getPosSpalte()
                || player.getPosZeile() - player.getRobot().getRange() == gegner.getPosZeile() && player.getPosSpalte() - player.getRobot().getRange() <= gegner.getPosSpalte()
                || player.getPosZeile() - player.getRobot().getRange() == gegner.getPosZeile() && player.getPosSpalte() + player.getRobot().getRange() <= gegner.getPosSpalte()) {
            return true;
        //Gegner kann Spieler erreichen (diagonal)
        } else if (gegner.getPosZeile() + gegner.getRobot().getRange() == player.getPosZeile() && gegner.getPosSpalte() + gegner.getRobot().getRange() == player.getPosSpalte()
                || gegner.getPosZeile() + gegner.getRobot().getRange() == player.getPosZeile() && gegner.getPosSpalte() - gegner.getRobot().getRange() == player.getPosSpalte()
                || gegner.getPosZeile() - gegner.getRobot().getRange() == player.getPosZeile() && gegner.getPosSpalte() - gegner.getRobot().getRange() == player.getPosSpalte()
                || gegner.getPosZeile() - gegner.getRobot().getRange() == player.getPosZeile() && gegner.getPosSpalte() + gegner.getRobot().getRange() == player.getPosSpalte()) {
            return true;
        } else if (player.getPosZeile() + player.getRobot().getRange() > runGame.board.getRows()
                || player.getPosSpalte() + player.getRobot().getRange() > runGame.board.getCols()
                || gegner.getPosZeile() + gegner.getRobot().getRange() > runGame.board.getRows()
                || gegner.getPosSpalte() + gegner.getRobot().getRange() > runGame.board.getCols()
                || player.getPosZeile() - player.getRobot().getRange() < runGame.board.getRows()
                || player.getPosSpalte() - player.getRobot().getRange() < runGame.board.getCols()
                || gegner.getPosZeile() - gegner.getRobot().getRange() < runGame.board.getRows()
                || gegner.getPosSpalte() - gegner.getRobot().getRange() < runGame.board.getCols()) {
            return false;
        }
        return false;
    }

}
