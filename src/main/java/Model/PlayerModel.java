package Model;

public class PlayerModel {
    private String name;
    private int posZeile;
    private int posSpalte;
    private int winHistory;
    private int lossHistory;
    private RobotModel robotModel;

    //Konstructor
    public PlayerModel(String name, int posZeile, int posSpalte, int winHistory, int lossHistory, RobotModel robotModel) {
        this.name = name;
        this.posZeile = posZeile;
        this.posSpalte = posSpalte;
        this.winHistory = winHistory;
        this.lossHistory = lossHistory;
        this.robotModel = robotModel;
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

    public RobotModel getRobotModel() {
        return robotModel;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

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

    public void setRobotModel(RobotModel robot) {
        this.robotModel = robot;
    }
}
