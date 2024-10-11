import java.util.*;

public class main {
    //Objektgenerierung
    static ASCII_Arts asciiArts = new ASCII_Arts();
    static Gameboard board = new Gameboard(10, 15);
    static Robot robot1 = new Robot("Roboter Nr. 1", ASCII_Arts.cyan + "§" + ASCII_Arts.farbReset, 100);
    static Robot robot2 = new Robot("Roboter Nr. 1", ASCII_Arts.purple + "∆" + ASCII_Arts.farbReset, 100);
    static Robot bot1 = new Robot("Bot 1", ASCII_Arts.red + "¥" + ASCII_Arts.farbReset, 100);


    //Scanner und Randomizer
    public static Scanner sc = new Scanner(System.in);
    public static Random r = new Random();

    //Spielererstellung mit Zuweisung
    public static String avatar1 = robot1.symbol;
    public static String avatar2 = robot2.symbol;
    public static Robot gewaehlterAvatar;

    //Erstellung des Gegners
    public static String gegner = bot1.symbol;

    //Startposition des Spielers
    public static int posZeile = Gameboard.randomNumberRow();
    public static int posSpalte = Gameboard.randomNumberColumn();

    //Startposition des Gegners
    public static int posGegnerZeile = Gameboard.randomNumberRow();
    public static int posGegnerSpalte = Gameboard.randomNumberColumn();

    //Attribute für einen Spielzug
    public static char zugEingabe = ' ';
    public static char gegnerZugEingabe = ' ';
    public static boolean spielerZug = true;
    public static boolean gegnerZug = false;

    public static void main(String[] args) {

        //Beginn Part Begrüßung und Avatarauswahl
        //Ausgabe Willkomensintro für den Spieler
        System.out.println("      Herzlich willkommen bei Robot Wars!");
        System.out.println(asciiArts.wilkommenASCII);

        //Eingabeaufforderung Name des Spielers
        System.out.println("Bitte gebe deinen Namen für das Spiel ein: ");
        String name = sc.nextLine();

        //Anzeige der Auswahl an wählbaren Avatars
        System.out.println("Hallo " + name + "! Bitte wähle deinen Roboter zwischen den beiden folgenden" +
                " Möglichkeiten aus:");

        System.out.println("Roboter Nr. 1\n" + asciiArts.robot1);
        System.out.println("Roboter Nr. 2\n" + asciiArts.robot2);

        //Avatarauswahl seitens des Spielers
        System.out.println("Treffe nun deine Entscheidung in dem du 1 oder 2 eingibst.");
        int avatar = sc.nextInt();

        //Abfrage ob eingegebene Auswahl korrekt bis diese korrekt ist
        while (avatar != 1 && avatar != 2) {
            System.out.println("Deine Eingabe war ungültig, bitte gebe entweder eine 1 für Roboter Nr. 1" +
                    " ein oder die 2 für Roboter Nr. 2!");
            avatar = sc.nextInt();
        }
        //Ende Part Begrüßung und Avatarauswahl



        //Beginn Part Spieler- & Gegnerinitialisierung
        if (avatar == 1) {
            gewaehlterAvatar = new Robot("Roboter Nr. 1", robot1.symbol, 100);
        } else if (avatar == 2) {
            gewaehlterAvatar = new Robot("Roboter Nr. 1", robot2.symbol, 100);
        } else {
            System.out.println("Fehler beim zuweisen des Avatars.");
        }

        System.out.println("Du hast den Roboter Nr. " + gewaehlterAvatar.name + " gewählt. Auf dem Spielfeld wird dieser durch das Symbol " +
                gewaehlterAvatar.symbol + " repräsentiert. Dein Gegner wird mit dem Symbol " + gegner + " angezeigt\n");
        //Ende Part Spieler- & Gegnerinitialisierung

        //TODO: New Robot vorher füllen
        Player player = new Player(name, Gameboard.randomNumberRow(), Gameboard.randomNumberColumn(), 0, 0, robot1);

        KI gegner = new KI("Bot 1", Gameboard.randomNumberRow(), Gameboard.randomNumberColumn(), "easy", bot1);




        //Beginn Part Spielfeldinitialisierung
        System.out.println("Das Spielfeld wird für das Spiel vorbereitet.\n");

        Gameboard.fillStartboard();

        //Spielerposition und Gegnerposition auf Spielfeld einfügen
        for (int i = 0; i < Gameboard.gameboard.length; i++) {
            for (int j = 0; j < Gameboard.gameboard[i].length; j++) {
                if (i == posZeile && j == posSpalte) {
                    Gameboard.gameboard[i][j] = " [" + gewaehlterAvatar.symbol + "]";
                } else if (i == posGegnerZeile && j == posGegnerSpalte) {
                    if (Gameboard.gameboard[i][j].equals(" [ ]")) {
                        Gameboard.gameboard[i][j] = " [" + gegner.robot.symbol + "]";
                    } else {
                        Gameboard.gameboard[i+1][j+1] = " [" + gegner.robot.symbol + "]";
                        //TODO: Randomize neue Position
                    }
                }
            }
        }


        int plantCounter = 0;
        int stoneCounter = 0;
        int waterCounter = 0;

        //Barrieren auf dem Spielfeld einfügen, je nach Typ anderes Symbol
        for (int i = 0; i < Gameboard.gameboard.length; i++) {
            for (int j = 0; j < Gameboard.gameboard[i].length; j++) {
                if (waterCounter < 10 && Gameboard.gameboard[i][j].equals(" [ ]")) {
                    Barrier waterbarrier = new Barrier("water", ASCII_Arts.blau + "≋" + ASCII_Arts.farbReset, 0, Gameboard.randomNumberRow()
                            , Gameboard.randomNumberColumn());
                    Gameboard.gameboard[waterbarrier.posZeile][waterbarrier.posSpalte] = " [" + waterbarrier.symbol + "]";
                    waterCounter++;
                } else if (stoneCounter < 10 && Gameboard.gameboard[i][j].equals(" [ ]")) {
                    Barrier stoneBarrier = new Barrier("stone", "▲", 0, Gameboard.randomNumberRow()
                            , Gameboard.randomNumberColumn());
                    Gameboard.gameboard[stoneBarrier.posZeile][stoneBarrier.posSpalte] = " [" + stoneBarrier.symbol + "]";
                    stoneCounter++;
                } else if (plantCounter < 15 && Gameboard.gameboard[i][j].equals(" [ ]")) {
                    Barrier plantBarrier = new Barrier("water", ASCII_Arts.gruen + "♣" + ASCII_Arts.farbReset, 0, Gameboard.randomNumberRow()
                            , Gameboard.randomNumberColumn());
                    Gameboard.gameboard[plantBarrier.posZeile][plantBarrier.posSpalte] = " [" + plantBarrier.symbol + "]";
                    plantCounter++;
                }

            }
        }

        //Print vom Startspielfeld
        Gameboard.printGameBoard();

        //Position des Spielers und Bots beim Start schriftlich fü den Spieler
        System.out.println("\nDein Roboter befindet sich zu Beginn in dem Feld (" + (posZeile+1) + "|" + (posSpalte+1) + ").");
        System.out.println("Dein Gegner " + gegner.name + " befindet sich zu Beginn in dem Feld (" + (posGegnerZeile+1) + "|"
                + (posGegnerSpalte+1) + "). \nViel Spaß beim Spielen!");
        //Ende Part Spielfeldinitialisierung



        //Start Part Spiel
        //Bishergie Gewinnbedingung nur Erreichung des Gegnerfeldes
        while (posZeile != posGegnerZeile || posSpalte != posGegnerSpalte) {
            //Spielerzug
            while (spielerZug) {
                System.out.println("\n" + name + " ist dran. Um dich zu bewegen nutze die Eingaben 6 = rechts, 4 = links, 8 = hoch und 2 = unten" +
                        ", möchtest du auf der aktuellen Position verweilen gebe eine 5 ein.");
                zugEingabe = sc.next().charAt(0);
                if (testZugGueltig(posZeile, posSpalte, zugEingabe)) { // && testBarrierInWay(posZeile, posSpalte, zugEingabe)
                    move(zugEingabe, gewaehlterAvatar.symbol);
                    System.out.println("Dein Roboter befindet sich auf dem Feld (" + (posZeile+1) + "|" + (posSpalte+1) + ").");
                } else {
                    System.out.println("Dieser Zug würde aus dem Spielfeld führen oder eine Barriere ist im Weg, bitte versuche es erneut. ");
                }
            }

            //Ausgabe des Spielerzuges
            if (Objects.equals(gewaehlterAvatar.symbol, avatar1)) {
                System.out.println(ASCII_Arts.cyan + "\n Spielerzug \n" + ASCII_Arts.farbReset);
            } else if (Objects.equals(gewaehlterAvatar.symbol, avatar2)) {
                System.out.println(ASCII_Arts.purple + "\n Spielerzug \n" + ASCII_Arts.farbReset);
            }
            Gameboard.printGameBoard();

            //Spieler überschreibt den Gegner -> Spielersieg
            if (posZeile == posGegnerZeile && posSpalte == posGegnerSpalte) {
                System.out.println("\nGlückwunsch! Du hast deinen Gegner besiegt!");
            } else {
                //Gegnerzug
                while (gegnerZug) {
                    System.out.println("\nDer Gegner ist am Zug und macht seine Eingabe");
                    gegnerZugEingabe = randomGegnerzug();
                    System.out.println("Der Gegner hat die Eingabe " + gegnerZugEingabe + " gewählt");
                    if (testZugGueltig(posGegnerZeile, posGegnerSpalte, gegnerZugEingabe)) { // && testBarrierInWay(posZeile, posSpalte, zugEingabe)
                        moveBot(gegnerZugEingabe);
                        System.out.println("Der Gegner " + gegner.name + " befindet sich auf dem Feld (" + (posGegnerZeile+1) + "|"
                                + (posGegnerSpalte+1) + ").");
                    } else {
                        System.out.println("Die Eingabe des Gegners würde aus dem Spielfeld führen oder eine Barriere ist im Weg, der Gegner versucht es erneut.");
                        gegnerZugEingabe = randomGegnerzug();
                    }
                }

                //Ausgabe des Gegnerzuges
                System.out.println(ASCII_Arts.red + "\n Gegnerzug \n" + ASCII_Arts.farbReset);
                Gameboard.printGameBoard();

                //Gegner überschreibt Spieler -> Gegnersieg
                if (posGegnerZeile == posZeile && posGegnerSpalte == posSpalte) {
                    System.out.println("Schade, du hast verloren!");
                }
            }
        }
        //Ende Part Spiel
    }

    //Methode für zufälligen Gegnerzug
    public static char randomGegnerzug () {
        char gegnerzug = ' ';
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

    //Methode zum Prüfen der Zuggültigkeit
    public static boolean testZugGueltig (int posZeile, int posSpalte, char zugEingabe) {
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

    //TODO: Barrier Abfrage/ Feld muss leer sein
    //Methode zum Prüfen ob eine Barriere im Weg ist
    public static boolean testBarrierInWay (int posZeile, int posSpalte, char zugEingabe) {
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

    //Methode zum Bewegen des Spielers
    public static void move (char zugEingabe, String gewaehlterAvatar) {
        Gameboard.gameboard[posZeile][posSpalte] = " [ ]";
        if (zugEingabe == '8') {
            posZeile = posZeile - 1;
            Gameboard.gameboard[posZeile][posSpalte] = " [" + gewaehlterAvatar + "]";
            spielerZug = false;
            gegnerZug = true;
        } else if (zugEingabe == '4') {
            posSpalte = posSpalte - 1;
            Gameboard.gameboard[posZeile][posSpalte] = " [" + gewaehlterAvatar + "]";
            spielerZug = false;
            gegnerZug = true;
        } else if (zugEingabe == '5') {
            Gameboard.gameboard[posZeile][posSpalte] = " [" + gewaehlterAvatar + "]";
            spielerZug = false;
            gegnerZug = true;
        } else if (zugEingabe == '6') {
            posSpalte = posSpalte + 1;
            Gameboard.gameboard[posZeile][posSpalte] = " [" + gewaehlterAvatar + "]";
            spielerZug = false;
            gegnerZug = true;
        } else if (zugEingabe == '2') {
            posZeile = posZeile + 1;
            Gameboard.gameboard[posZeile][posSpalte] = " [" + gewaehlterAvatar + "]";
            spielerZug = false;
            gegnerZug = true;
        }
    }

    //TODO: ggf Alternative Bewegung anhand der Entscheidung des Spielers
    //Methode zum Bewegen des Bots
    public static void moveBot (char gegnerZugEingabe) {
        Gameboard.gameboard[posGegnerZeile][posGegnerSpalte] = " [ ]";
        if (gegnerZugEingabe == '8') {
            posGegnerZeile = posGegnerZeile - 1;
            Gameboard.gameboard[posGegnerZeile][posGegnerSpalte] = " [" + gegner + "]";
            spielerZug = true;
            gegnerZug = false;
        } else if (gegnerZugEingabe == '4') {
            posGegnerSpalte = posGegnerSpalte - 1;
            Gameboard.gameboard[posGegnerZeile][posGegnerSpalte] = " [" + gegner + "]";
            spielerZug = true;
            gegnerZug = false;
        } else if (gegnerZugEingabe == '5') {
            Gameboard.gameboard[posGegnerZeile][posGegnerSpalte] = " [" + gegner + "]";
            spielerZug = true;
            gegnerZug = false;
        } else if (gegnerZugEingabe == '6') {
            posGegnerSpalte = posGegnerSpalte + 1;
            Gameboard.gameboard[posGegnerZeile][posGegnerSpalte] = " [" + gegner + "]";
            spielerZug = true;
            gegnerZug = false;
        } else if (gegnerZugEingabe == '2') {
            posGegnerZeile = posGegnerZeile + 1;
            Gameboard.gameboard[posGegnerZeile][posGegnerSpalte] = " [" + gegner + "]";
            spielerZug = true;
            gegnerZug = false;
        }
    }
}