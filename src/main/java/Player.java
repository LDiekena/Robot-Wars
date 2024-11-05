public class Player {
    private final String name;
    private int posZeile;
    private int posSpalte;
    private int winHistory;
    private int lossHistory;
    private final Robot robot;

    //Constructor
    public Player(String name, int posZeile, int posSpalte, int winHistory, int lossHistory, Robot robot) {
        this.name = name;
        this.posZeile = posZeile;
        this.posSpalte = posSpalte;
        this.winHistory = winHistory;
        this.lossHistory = lossHistory;
        this.robot = robot;
    }

    //Getter
    public String getName() {
        return name;
    }

    public int getPosZeile() {
        return posZeile;
    }

    public int getPosSpalte() {
        return posSpalte;
    }

    public int getWinHistory() {
        return winHistory;
    }

    public int getLossHistory() {
        return lossHistory;
    }

    public Robot getRobot() {
        return robot;
    }

    //Setter
    public void setPosZeile(int posZeile) {
        this.posZeile = posZeile;
    }

    public void setPosSpalte(int posSpalte) {
        this.posSpalte = posSpalte;
    }

    public void setWinHistory(int winHistory) {
        this.winHistory = winHistory;
    }

    public void setLossHistory(int lossHistory) {
        this.lossHistory = lossHistory;
    }

    //Methode zum Bewegen des Spielers
    public void move(char zugEingabe, String gewaehlterAvatar, int posZeile, int posSpalte, boolean spielerZug, boolean gegnerZug) {
        runGame.board.getGameboard()[this.posZeile][this.posSpalte] = " [ ]";
        if (zugEingabe == '8') {
            this.posZeile = posZeile - 1;
            runGame.board.getGameboard()[this.posZeile][this.posSpalte] = " [" + gewaehlterAvatar + "]";
            runGame.game.setSpielerZug(false);
            runGame.game.setGegnerZug(true);
        } else if (zugEingabe == '4') {
            this.posSpalte = posSpalte - 1;
            runGame.board.getGameboard()[this.posZeile][this.posSpalte] = " [" + gewaehlterAvatar + "]";
            runGame.game.setSpielerZug(false);
            runGame.game.setGegnerZug(true);
        } else if (zugEingabe == '5') {
            runGame.board.getGameboard()[this.posZeile][this.posSpalte] = " [" + gewaehlterAvatar + "]";
            runGame.game.setSpielerZug(false);
            runGame.game.setGegnerZug(true);
        } else if (zugEingabe == '6') {
            this.posSpalte = posSpalte + 1;
            runGame.board.getGameboard()[this.posZeile][this.posSpalte] = " [" + gewaehlterAvatar + "]";
            runGame.game.setSpielerZug(false);
            runGame.game.setGegnerZug(true);
        } else if (zugEingabe == '2') {
            this.posZeile = posZeile + 1;
            runGame.board.getGameboard()[this.posZeile][this.posSpalte] = " [" + gewaehlterAvatar + "]";
            runGame.game.setSpielerZug(false);
            runGame.game.setGegnerZug(true);
        }
    }
}
