import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte gebe deinen Namen ein: ");
        String name = sc.nextLine();

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

        System.out.println("Treffe nun deine Entscheidung in dem du 1 oder 2 eingibst.");
        int avatar = sc.nextInt();

        while (avatar != 1 && avatar != 2) {
            System.out.println("Deine Eingabe war ungültig, bitte gebe entweder eine 1 für Roboter Nr. 1" +
                    " ein oder die 2 für Roboter Nr. 2!");
            avatar = sc.nextInt();
        }

        System.out.println("Du hast den Roboter Nr. " + avatar + " gewählt.");

    }
}
