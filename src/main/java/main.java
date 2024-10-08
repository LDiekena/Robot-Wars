import java.util.*;

public class main {

    //Farbcodes
    public static String farbReset = "\u001B[0m";
    public static String cyan = "\u001B[36m";
    public static String purple = "\u001B[35m";
    public static String red = "\u001B[31m";
    public static String gelb = "\u001B[33m";

    //Scanner und Randomizer
    public static Scanner sc = new Scanner(System.in);
    public static Random r = new Random();

    //Spielfeld als Array in der Größe 10x15
    public static String[][] spielfeld = new String[10][15];

    //Spielererstellung mit Zuweisung
    public static String avatar1 = cyan + "§" + farbReset;
    public static String avatar2 = purple + "∆" + farbReset;
    public static String gewaehlterAvatar = " ";

    //Erstellung des Gegners
    public static String gegner = red + "¥" + farbReset;
    public static String botName = "Bot 1";

    //Startposition des Spielers
    public static int posZeile = randomNumberRow();
    public static int posSpalte = randomNumberColumn();

    //Startposition des Gegners
    public static int posGegnerZeile = randomNumberRow();
    public static int posGegnerSpalte = randomNumberColumn();

    //Attribute für einen Zpielzug
    public static char zugEingabe = ' ';
    public static char gegnerZugEingabe = ' ';
    public static boolean spielerZug = true;
    public static boolean gegnerZug = false;

    public static void main(String[] args) {

        //Beginn Sammlung ASCII Arts
        String wilkommenASCII = gelb + "           ___\n" +
                                "          |_|_|\n" +
                                "          |_|_|              _____\n" +
                                "          |_|_|     ____    |*_*_*|\n" +
                                " _______   _\\__\\___/ __ \\____|_|_   _______\n" +
                                "/ ____  |=|      \\  <_+>  /      |=|  ____ \\\n" +
                                "~|    |\\|=|======\\\\______//======|=|/|    |~\n" +
                                " |_   |    \\      |      |      /    |    |\n" +
                                "  \\==-|     \\     | Robot|     /     |----|~~/\n" +
                                "  |   |      |    | Wars |    |      |____/~/\n" +
                                "  |   |       \\____\\____/____/      /    / /\n" +
                                "  |   |         {----------}       /____/ /\n" +
                                "  |___|        /~~~~~~~~~~~~\\     |_/~|_|/\n" +
                                "   \\_/        |/~~~~~||~~~~~\\|     /__|\\\n" +
                                "   | |         |    ||||    |     (/|| \\)\n" +
                                "   | |        /     |  |     \\       \\\\\n" +
                                "   |_|        |     |  |     |\n" +
                                "              |_____|  |_____|\n" +
                                "              (_____)  (_____)\n" +
                                "              |     |  |     |\n" +
                                "              |     |  |     |\n" +
                                "              |/~~~\\|  |/~~~\\|\n" +
                                "              /|___|\\  /|___|\\\n" +
                                "             <_______><_______>\n" + farbReset;

        String robot1 = cyan + "   __,_,\n" +
                "  [_|_/\n" +
                "   //\n" +
                " _//    __\n" +
                "(_|)   |@@|\n" +
                " \\ \\__ \\--/ __\n"+
                "  \\o__|----|  |   __\n" +
                "      \\ }{ /\\ )_ / _\\\n" +
                "      /\\__/\\ \\__O (__\n" +
                "     (--/\\--)    \\__/\n" +
                "     _)(  )(_\n" +
                "    `---''---`\n" + farbReset;

        String robot2 = purple + "      \\_/     \n" +
                        "     (* *)     \n" +
                        "    __)#(__    \n" +
                        "   ( )...( )(_)\n" +
                        "   || |_| ||// \n" +
                        ">==() | | ()/  \n" +
                        "    _(___)_    \n" +
                        "   [-]   [-]   \n" + farbReset;

        //Ende Sammlung ASCII Arts



        //Beginn Part Begrüßung und Avatarauswahl
        //Ausgabe Willkomensintro für den Spieler
        System.out.println("      Herzlich willkommen bei Robot Wars!");
        System.out.println(wilkommenASCII);

        //Eingabeaufforderung Name des Spielers
        System.out.println("Bitte gebe deinen Namen für das Spiel ein: ");
        String name = sc.nextLine();

        //Anzeige der Auswahl an wählbaren Avatars
        System.out.println("Hallo " + name + "! Bitte wähle deinen Roboter zwischen den beiden folgenden" +
                " Möglichkeiten aus:");

        System.out.println("Roboter Nr. 1\n" + robot1);
        System.out.println("Roboter Nr. 2\n" + robot2);

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
            gewaehlterAvatar = avatar1;
        } else if (avatar == 2) {
            gewaehlterAvatar = avatar2;
        } else {
            System.out.println("Fehler beim zuweisen des Avatars.");
        }

        System.out.println("Du hast den Roboter Nr. " + avatar + " gewählt. Auf dem Spielfeld wird dieser durch das Symbol " +
                gewaehlterAvatar + " repräsentiert. Dein Gegner wird mit dem Symbol " + gegner + " angezeigt\n");
        //Ende Part Spieler- & Gegnerinitialisierung



        //Beginn Part Spielfeldinitialisierung
        System.out.println("Das Spielfeld wird für das Spiel vorbereitet.\n");

        //Spielfelderstellung leeres Spielfeld
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                spielfeld[i][j] = " [ ]";
            }
        }

        //Spielerposition und Gegnerposition auf Spielfeld einfügen, je nach Avatar anderes Symbol
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                if (i == posZeile && j == posSpalte && gewaehlterAvatar == avatar1) {
                    spielfeld[i][j] = " [" + avatar1 + "]";
                } else if (i == posZeile && j == posSpalte && gewaehlterAvatar == avatar2) {
                    spielfeld[i][j] = " [" + avatar2 + "]";
                } else if (i == posGegnerZeile && j == posGegnerSpalte) {
                    if (spielfeld[i][j].equals(" [ ]")) {
                        spielfeld[i][j] = " [" + gegner + "]";
                    } else {
                        spielfeld[i+1][j+1] = " [" + gegner + "]";
                        //TODO: Randomize neue Position
                    }
                } else {

                }
            }
        }

        //Print vom Startspielfeld
        printSpielfeld();

        //Position des Spielers und Bots beim Start schriftlich fü den Spieler
        System.out.println("\nDein Roboter befindet sich zu Beginn in dem Feld (" + (posZeile+1) + "|" + (posSpalte+1) + ").");
        System.out.println("Dein Gegner " + botName + " befindet sich zu Beginn in dem Feld (" + (posGegnerZeile+1) + "|"
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
                if (testZugGueltig(posZeile, posSpalte, zugEingabe)) {
                    move(zugEingabe, gewaehlterAvatar);
                    System.out.println("Dein Roboter befindet sich auf dem Feld (" + (posZeile+1) + "|" + (posSpalte+1) + ").");
                } else {
                    System.out.println("Dieser Zug würde aus dem Spielfeld führen, bitte versuche es erneut. ");
                }
            }

            //Ausgabe des Spielerzuges
            if (gewaehlterAvatar == avatar1) {
                System.out.println(cyan + "\n Spielerzug \n" + farbReset);
            } else if (gewaehlterAvatar == avatar2) {
                System.out.println(purple + "\n Spielerzug \n" + farbReset);
            }
            printSpielfeld();

            //Spieler überschreibt den Gegner -> Spielersieg
            if (posZeile == posGegnerZeile && posSpalte == posGegnerSpalte) {
                System.out.println("\nGlückwunsch! Du hast deinen Gegner besiegt!");
            } else {
                //Gegnerzug
                while (gegnerZug) {
                    System.out.println("\nDer Gegner ist am Zug und macht seine Eingabe");
                    gegnerZugEingabe = randomGegnerzug();
                    System.out.println("Der Gegner hat die Eingabe " + gegnerZugEingabe + " gewählt");
                    if (testZugGueltig(posGegnerZeile, posGegnerSpalte, gegnerZugEingabe)) {
                        moveBot(gegnerZugEingabe);
                        System.out.println("Der Gegner " + botName + " befindet sich auf dem Feld (" + (posGegnerZeile+1) + "|"
                                + (posGegnerSpalte+1) + ").");
                    } else {
                        System.out.println("Die Eingabe des Gegners würde aus dem Spielfeld führen, der Gegner versucht es erneut.");
                        gegnerZugEingabe = randomGegnerzug();
                    }
                }

                //Ausgabe des Gegnerzuges
                System.out.println(red + "\n Gegnerzug \n" +farbReset);
                printSpielfeld();

                //Gegner überschreibt Spieler -> Gegnersieg
                if (posGegnerZeile == posZeile && posGegnerSpalte == posSpalte) {
                    System.out.println("Schade, du hast verloren!");
                }
            }
        }
        //Ende Part Spiel
    }

    //Methode zur Konsolenausgabe des Spielfeldes
    public static void printSpielfeld () {
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                System.out.print(spielfeld[i][j]);
            }
            System.out.println();
        }
    }

    //Methode für zufällige Zeile
    public static int randomNumberRow () {
        return r.nextInt(9);
    }

    //Methode für zufällige Spalte
    public static int randomNumberColumn () {
        return r.nextInt(14);
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

    //Methode zum Bewegen des Spielers
    public static void move (char zugEingabe, String gewaehlterAvatar) {
        spielfeld[posZeile][posSpalte] = " [ ]";
        if (zugEingabe == '8') {
            posZeile = posZeile - 1;
            spielfeld[posZeile][posSpalte] = " [" + gewaehlterAvatar + "]";
            spielerZug = false;
            gegnerZug = true;
        } else if (zugEingabe == '4') {
            posSpalte = posSpalte - 1;
            spielfeld[posZeile][posSpalte] = " [" + gewaehlterAvatar + "]";
            spielerZug = false;
            gegnerZug = true;
        } else if (zugEingabe == '5') {
            spielfeld[posZeile][posSpalte] = " [" + gewaehlterAvatar + "]";
            spielerZug = false;
            gegnerZug = true;
        } else if (zugEingabe == '6') {
            posSpalte = posSpalte + 1;
            spielfeld[posZeile][posSpalte] = " [" + gewaehlterAvatar + "]";
            spielerZug = false;
            gegnerZug = true;
        } else if (zugEingabe == '2') {
            posZeile = posZeile + 1;
            spielfeld[posZeile][posSpalte] = " [" + gewaehlterAvatar + "]";
            spielerZug = false;
            gegnerZug = true;
        }
    }

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
}