import java.util.Random;

public class KI {
    String name;
    static int posZeile;
    static int posSpalte;
    String difficulty;
    Robot robot;

    //Konstructor
    public KI(String name, int posZeile, int posSpalte, String difficulty, Robot robot) {
        this.name = name;
        KI.posZeile = posZeile;
        KI.posSpalte = posSpalte;
        this.difficulty = difficulty;
        this.robot = robot;
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
    public static void move(char gegnerZugEingabe, int posGegnerZeile, int posGegnerSpalte, String gegner, boolean spielerZug, boolean gegnerZug) {
        Gameboard.gameboard[KI.posZeile][KI.posSpalte] = " [ ]";
        if (gegnerZugEingabe == '8') {
            KI.posZeile = posGegnerZeile - 1;
            Gameboard.gameboard[KI.posZeile][KI.posSpalte] = " [" + gegner + "]";
            Game.spielerZug = true;
            Game.gegnerZug = false;
        } else if (gegnerZugEingabe == '4') {
            KI.posSpalte = posGegnerSpalte - 1;
            Gameboard.gameboard[KI.posZeile][KI.posSpalte] = " [" + gegner + "]";
            Game.spielerZug = true;
            Game.gegnerZug = false;
        } else if (gegnerZugEingabe == '5') {
            Gameboard.gameboard[KI.posZeile][KI.posSpalte] = " [" + gegner + "]";
            Game.spielerZug = true;
            Game.gegnerZug = false;
        } else if (gegnerZugEingabe == '6') {
            KI.posSpalte = posGegnerSpalte + 1;
            Gameboard.gameboard[KI.posZeile][KI.posSpalte] = " [" + gegner + "]";
            Game.spielerZug = true;
            Game.gegnerZug = false;
        } else if (gegnerZugEingabe == '2') {
            KI.posZeile = posGegnerZeile + 1;
            Gameboard.gameboard[KI.posZeile][KI.posSpalte] = " [" + gegner + "]";
            Game.spielerZug = true;
            Game.gegnerZug = false;
        }
    }

}
