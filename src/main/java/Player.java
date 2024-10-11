public class Player {
    String name;
    int posZeile;
    int posSpalte;
    int winHistory;
    int lossHistory;
    Robot robot;

    //Constructor
    public Player(String name, int posZeile, int posSpalte, int winHistory, int lossHistory, Robot robot) {
        this.name = name;
        this.posZeile = posZeile;
        this.posSpalte = posSpalte;
        this.winHistory = winHistory;
        this.lossHistory = lossHistory;
        this.robot = robot;
    }

}
