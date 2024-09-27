import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        //Beginn Sammlung ASCII Arts
        String wilkommenASCII = "           ___\n" +
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
                                "             <_______><_______>\n";

        String robot1 = "   __,_,\n" +
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
                "    `---''---`\n";

        String robot2 = "      \\_/     \n" +
                        "     (* *)     \n" +
                        "    __)#(__    \n" +
                        "   ( )...( )(_)\n" +
                        "   || |_| ||// \n" +
                        ">==() | | ()/  \n" +
                        "    _(___)_    \n" +
                        "   [-]   [-]   \n";

        //Ende Sammlung ASCII Arts



        //Ausgabe Willkomensintro für den Spieler
        System.out.println("      Herzlich willkommen bei Robot Wars!");
        System.out.println(wilkommenASCII);

        //Eingabeaufforderung Name des Spielers
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte gebe deinen Namen für das Spiel ein: ");
        String name = sc.nextLine();

        //Anzeige der Auswahl an wählbaren Avatars
        System.out.println("Hallo " + name + "! Bitte wähle deinen Roboter zwischen den beiden folgenden" +
                " Möglichkeiten aus:");

        System.out.println("Roboter Nr. 1\n" + robot1);
        System.out.println("Roboter Nr. 2\n" + robot2);

        //Avatarauswahl des Spielers
        System.out.println("Treffe nun deine Entscheidung in dem du 1 oder 2 eingibst.");
        int avatar = sc.nextInt();

        //Abfrage ob eingegebene Auswahl korrekt bis diese korrekt ist
        while (avatar != 1 && avatar != 2) {
            System.out.println("Deine Eingabe war ungültig, bitte gebe entweder eine 1 für Roboter Nr. 1" +
                    " ein oder die 2 für Roboter Nr. 2!");
            avatar = sc.nextInt();
        }



        // Beginn Part Spieler- & Gegnerinitialisierung
        //Spielererstellung mit Zuweisung
        char avatar1 = '§';
        char avatar2 = '∆';
        char gewaehlterAvatar = ' ';

        if (avatar == 1) {
            gewaehlterAvatar = avatar1;
        } else if (avatar == 2) {
            gewaehlterAvatar = avatar2;
        } else {
            System.out.println("Fehler beim zuweisen des Avatars.");
        }

        //Erstellung des Gegners
        char gegner = '¥';
        String botName = "Bot 1";

        System.out.println("Du hast den Roboter Nr. " + avatar + " gewählt. Auf dem Spielfeld wird dieser durch das Symbol " +
                gewaehlterAvatar + " repräsentiert. Dein Gegner wird mit dem Symbol" + gegner + " angezeigt\n");
        //Ende Part Spieler- & Gegnerinitialisierung



        //Beginn Part Spielfeldinitialisierung
        System.out.println("Das Spielfeld wird für das Spiel vorbereitet.");

        //Spielfeld als Array in der Größe 10x15
        String[][] spielfeld = new String[10][15];

        //Startposition des Spielers
        int posZeile = randomNumberRow(9);
        int posSpalte = randomNumberColumn(14);

        //Startposition des Gegners
        int posGegnerZeile = randomNumberColumn(9);
        int posGegnerSpalte = randomNumberColumn(14);

        //Spielfelderstellung leeres Spielfeld
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                spielfeld[i][j] = " [ ]";
            }
        }

        //Spielerposition und Gegnerposition auf Spielfeld einfügen, je nach Avatar anderes Symbol
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length - 1; j++) {
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


        //Print vom Spielfeld-Array
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length - 1; j++) {
                System.out.print(spielfeld[i][j]);
            }
            System.out.println();
        }

        //Position des Spielers und Bots beim Start
        System.out.println("Dein Roboter befindet sich zu Beginn in dem Feld (" + (posZeile+1) + "|" + (posSpalte+1) + ").");
        System.out.println("Dein Gegner " + botName + " befindet sich zu Beginn in dem Feld (" + (posGegnerZeile+1) + "|"
                + (posGegnerSpalte+1) + "). \nViel Spaß beim Spielen!");

        //Ende Part Spielfeldinitialisierung




    }

    //Methode für Random Number
    public static int randomNumberRow (int number) {
        Random r = new Random();
        number = r.nextInt(9);
        return number;
    }

    public static int randomNumberColumn (int number) {
        Random r = new Random();
        number = r.nextInt(14);
        return number;
    }
}