public class KI {
    String name;
    int posZeile;
    int posSpalte;
    String difficulty;
    Robot robot;

    //Konstructor
    public KI(String name, int posZeile, int posSpalte, String difficulty, Robot robot) {
        this.name = name;
        this.posZeile = posZeile;
        this.posSpalte = posSpalte;
        this.difficulty = difficulty;
        this.robot = robot;
    }

    /*
    //TODO: ggf Alternative Bewegung anhand der Entscheidung des Spielers
    //Methode zum Bewegen des Bots
    public static void moveBot (char gegnerZugEingabe) {
        spielfeld[posGegnerZeile][posGegnerSpalte] = " [ ]";
        if (gegnerZugEingabe == '8') {
            posGegnerZeile = posGegnerZeile - 1;
            spielfeld[posGegnerZeile][posGegnerSpalte] = " [" + gegner + "]";
            spielerZug = true;
            gegnerZug = false;
        } else if (gegnerZugEingabe == '4') {
            posGegnerSpalte = posGegnerSpalte - 1;
            spielfeld[posGegnerZeile][posGegnerSpalte] = " [" + gegner + "]";
            spielerZug = true;
            gegnerZug = false;
        } else if (gegnerZugEingabe == '5') {
            spielfeld[posGegnerZeile][posGegnerSpalte] = " [" + gegner + "]";
            spielerZug = true;
            gegnerZug = false;
        } else if (gegnerZugEingabe == '6') {
            posGegnerSpalte = posGegnerSpalte + 1;
            spielfeld[posGegnerZeile][posGegnerSpalte] = " [" + gegner + "]";
            spielerZug = true;
            gegnerZug = false;
        } else if (gegnerZugEingabe == '2') {
            posGegnerZeile = posGegnerZeile + 1;
            spielfeld[posGegnerZeile][posGegnerSpalte] = " [" + gegner + "]";
            spielerZug = true;
            gegnerZug = false;
        }
    }

     */
}
