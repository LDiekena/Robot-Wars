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

        //Spielfeld Attribute
        int boardLenght = 15;
        int boardHight = 10;
        int position;

        //Spielfeld
        while (boardHight >= 1) {
            int i = boardLenght;
            while (i > 1) {
                System.out.print(" [ ]");
                i--;
            }
            boardHight--;
            System.out.println(" [ ]");
        }

        //Position des Roboters bei Start
        System.out.println("Dein Roboter befindet sich zu Beginn in dem Feld (z|s). Viel Spaß beim Spielen!");
    }
}