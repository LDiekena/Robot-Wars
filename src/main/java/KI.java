import java.util.Random;

public class KI {
    private final String name;
    private int posZeile;
    private int posSpalte;
    private final String difficulty;
    private final Robot robot;

    //Konstructor
    public KI(String name, int posZeile, int posSpalte, String difficulty, Robot robot) {
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

    //Methode für zufälligen Gegnerzug
    public static char randomGegnerzug() {
        char gegnerzug = ' ';
        Random r = new Random();
        int randomNumber = r.nextInt(5);
        if (randomNumber == 0) {
            gegnerzug = '2';
        } else if (randomNumber == 1) {
            gegnerzug = '4';
        } else if (randomNumber == 2) {
            gegnerzug = '5';
        } else if (randomNumber == 3) {
            gegnerzug = '6';
        } else if (randomNumber == 4) {
            gegnerzug = '8';
        }
        return gegnerzug;
    }


    //TODO: ggf Alternative Bewegung anhand der Entscheidung des Spielers
    //Methode zum Bewegen des Bots
    public void move(char gegnerZugEingabe, int posGegnerZeile, int posGegnerSpalte, String gegner, boolean spielerZug, boolean gegnerZug) {
        runGame.board.getGameboard()[this.posZeile][this.posSpalte] = " [ ]";
        if (gegnerZugEingabe == '8') {
            this.posZeile = posGegnerZeile - 1;
            runGame.board.getGameboard()[this.posZeile][this.posSpalte] = " [" + gegner + "]";
            runGame.game.setSpielerZug(true);
            runGame.game.setGegnerZug(false);
        } else if (gegnerZugEingabe == '4') {
            this.posSpalte = posGegnerSpalte - 1;
            runGame.board.getGameboard()[this.posZeile][this.posSpalte] = " [" + gegner + "]";
            runGame.game.setSpielerZug(true);
            runGame.game.setGegnerZug(false);
        } else if (gegnerZugEingabe == '5') {
            runGame.board.getGameboard()[this.posZeile][this.posSpalte] = " [" + gegner + "]";
            runGame.game.setSpielerZug(true);
            runGame.game.setGegnerZug(false);
        } else if (gegnerZugEingabe == '6') {
            this.posSpalte = posGegnerSpalte + 1;
            runGame.board.getGameboard()[this.posZeile][this.posSpalte] = " [" + gegner + "]";
            runGame.game.setSpielerZug(true);
            runGame.game.setGegnerZug(false);
        } else if (gegnerZugEingabe == '2') {
            this.posZeile = posGegnerZeile + 1;
            runGame.board.getGameboard()[this.posZeile][this.posSpalte] = " [" + gegner + "]";
            runGame.game.setSpielerZug(true);
            runGame.game.setGegnerZug(false);
        }
    }

}
