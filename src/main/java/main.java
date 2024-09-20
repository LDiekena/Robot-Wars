import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //Ausgabe Willkomensintro für den Spieler
        System.out.println("           ___");
        System.out.println("          |_|_|");
        System.out.println("          |_|_|              _____");
        System.out.println("          |_|_|     ____    |*_*_*|");
        System.out.println(" _______   _\\__\\___/ __ \\____|_|_   _______");
        System.out.println("/ ____  |=|      \\  <_+>  /      |=|  ____ \\");
        System.out.println("~|    |\\|=|======\\\\______//======|=|/|    |~");
        System.out.println(" |_   |    \\      |      |      /    |    |");
        System.out.println("  \\==-|     \\     | Robot|     /     |----|~~/");
        System.out.println("  |   |      |    | Wars |    |      |____/~/");
        System.out.println("  |   |       \\____\\____/____/      /    / /");
        System.out.println("  |   |         {----------}       /____/ /");
        System.out.println("  |___|        /~~~~~~~~~~~~\\     |_/~|_|/");
        System.out.println("  \\_/        |/~~~~~||~~~~~\\|     /__|\\");
        System.out.println("   | |         |    ||||    |     (/|| \\)");
        System.out.println("   | |        /     |  |     \\       \\\\");
        System.out.println("   |_|        |     |  |     |");
        System.out.println("              |_____|  |_____|");
        System.out.println("              (_____)  (_____)");
        System.out.println("              |     |  |     |");
        System.out.println("              |     |  |     |");
        System.out.println("              |/~~~\\|  |/~~~\\|");
        System.out.println("              /|___|\\  /|___|\\");
        System.out.println("             <_______><_______>");

        System.out.println("Herzlich willkommen bei Robot Wars!");
        //Eingabeaufforderung Name des Spielers
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte gebe deinen Namen ein: ");
        String name = sc.nextLine();

        //Anzeige der Auswahl an wählbaren Avatars
        System.out.println("Hallo " + name + "! Bitte wähle deinen Roboter zwischen den beiden folgenden" +
                " Möglichkeiten aus.");

        System.out.println("Roboter Nr. 1");
        System.out.println("   __,_,");
        System.out.println("  [_|_/ ");
        System.out.println("   //");
        System.out.println(" _//    __");
        System.out.println("(_|)   |@@|");
        System.out.println(" \\ \\__ \\--/ __");
        System.out.println("  \\o__|----|  |   __");
        System.out.println("      \\ }{ /\\ )_ / _\\");
        System.out.println("      /\\__/\\ \\__O (__");
        System.out.println("     (--/\\--)    \\__/");
        System.out.println("     _)(  )(_");
        System.out.println("    `---''---`");
        System.out.println();

        System.out.println( "Roboter Nr. 2" );
        System.out.println("      \\_/     ");
        System.out.println("     (* *)     ");
        System.out.println("    __)#(__    ");
        System.out.println("   ( )...( )(_)");
        System.out.println("   || |_| ||// ");
        System.out.println(">==() | | ()/  ");
        System.out.println("    _(___)_    ");
        System.out.println("   [-]   [-]   ");

        //Avatarauswahl des Spielers
        System.out.println("Treffe nun deine Entscheidung in dem du 1 oder 2 eingibst.");
        int avatar = sc.nextInt();

        //Abfrage ob eingegebene Auswahl korrekt bis diese korrekt ist
        while (avatar != 1 && avatar != 2) {
            System.out.println("Deine Eingabe war ungültig, bitte gebe entweder eine 1 für Roboter Nr. 1" +
                    " ein oder die 2 für Roboter Nr. 2!");
            avatar = sc.nextInt();
        }

        //Auswahlbestätigung
        System.out.println("Du hast den Roboter Nr. " + avatar + " gewählt.");
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