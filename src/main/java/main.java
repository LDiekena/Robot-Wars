import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //Sammlung ASCII Arts
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

        //Auswahlbestätigung und Symbolzuweisung
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

        System.out.println("Du hast den Roboter Nr. " + avatar + " gewählt. Auf dem Spielfeld wird dieser durch das Symbol " +
                gewaehlterAvatar + " repräsentiert.\n");
        System.out.println("Das Spielfeld wird für das Spiel vorbereitet.");

        //Spielfeld als Array in der Größe 10x15
        String[][] spielfeld = new String[10][15];
        Random r = new Random();

        //Randomizer für die Startposition
        int posZeile = r.nextInt(9);
        int posSpalte = r.nextInt(14);

        //Spielfelderstellung leeres Spielfeld
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                spielfeld[i][j] = " [ ]";
            }
        }

        //Spielerposition auf Spielfeld einfügen, je nach Avatar anderes Symbol
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length - 1; j++) {
                if (i == posZeile && j == posSpalte && gewaehlterAvatar == avatar1) {
                    spielfeld[i][j] = " [" + avatar1 + "]";
                } else if (i == posZeile && j == posSpalte && gewaehlterAvatar == avatar2) {
                    spielfeld[i][j] = " [" + avatar2 + "]";
                } else {
                    spielfeld[i][j] = " [ ]";
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

        //Position des Roboters bei Start
        System.out.println("Dein Roboter befindet sich zu Beginn in dem Feld (z|s). Viel Spaß beim Spielen!");
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