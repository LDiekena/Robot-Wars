package Model;

public class KIModel {
    private final String name;
    private int posZeile;
    private int posSpalte;
    private final String difficulty;
    private final RobotModel robot;

    //Konstructor
    public KIModel(String name, int posZeile, int posSpalte, String difficulty, RobotModel robot) {
        this.name = name;
        this.posZeile = posZeile;
        this.posSpalte = posSpalte;
        this.difficulty = difficulty;
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

    public String getDifficulty() {
        return difficulty;
    }

    public RobotModel getRobotModel() {
        return robot;
    }

    //Setter
    public void setPosZeile(int posZeile) {
        this.posZeile = posZeile;
    }

    public void setPosSpalte(int posSpalte) {
        this.posSpalte = posSpalte;
    }
}
