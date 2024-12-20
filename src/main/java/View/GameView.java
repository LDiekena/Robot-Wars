package View;

import Model.KIModel;
import Model.PlayerModel;
import java.util.Scanner;

public class GameView {
    //Farbcodes
    public final String farbReset = "\u001B[0m";
    public final String cyan = "\u001B[36m";
    public final String purple = "\u001B[35m";
    public final String gelb = "\u001B[33m";
    public final String red = "\u001B[31m";
    public final String gruen = "\033[0;32m";
    public final String blau = "\033[0;34m";

    //Ausgabe Introscreen
    public void displayIntroScreen() {
        System.out.println("      Herzlich willkommen bei Robot Wars!");

        String welcomeASCII = gelb + "           ___\n" +
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

        System.out.println(welcomeASCII);
    }

    //Ausgabe Namensabfrage
    public String askPlayerName() {
        System.out.println("Bitte gebe deinen Namen für das Spiel ein: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    //Ausgabe Avatarabfrage
    public int askAvatarChoice(String name) {
        System.out.println("Hallo " + name + "! Bitte wähle deinen Roboter zwischen den beiden folgenden" +
                " Möglichkeiten aus:");

        String robot1 = cyan + "   __,_,\n" +
                "  [_|_/\n" +
                "   //\n" +
                " _//    __\n" +
                "(_|)   |@@|\n" +
                " \\ \\__ \\--/ __\n" +
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

        System.out.println("Cyannator\n" + robot1);
        System.out.println("Purplenator\n" + robot2);

        System.out.println("Treffe nun deine Entscheidung in dem du 1 oder 2 eingibst.");

        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    //Ausgabe inkorrekte Eingabe Avatar
    public int incorrectInputAvatar() {
        System.out.println("Deine Eingabe war ungültig, bitte gebe entweder eine 1 für Roboter Nr. 1" +
                " ein oder die 2 für Roboter Nr. 2!");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    //Ausgabe Fehler bei der Avatarwahl
    public void printErrorSetAvater() {
        System.out.println("Fehler beim zuweisen des Avatars.");
    }

    //Ausgabe nach askAvatarChoice
    public void confirmAvatarChoice(PlayerModel player, KIModel enemy) {
        System.out.println("Du hast den Roboter Nr. " + player.getRobotModel().getName() + " gewählt. Auf dem Spielfeld wird dieser durch das Symbol " +
                player.getRobotModel().getSymbol() + " repräsentiert. Dein Gegner wird mit dem Symbol " + enemy.getRobotModel().getSymbol() + " angezeigt\n");
    }

    //Ausgabe Spielstart
    public void printStartMessage() {
        System.out.println("Viel Spaß beim Spielen!");
    }

    //Ausgabe Player ist dran, Farbe je nach Avatarwahl
    public void printPlayerTurn(int i) {
        if(i == 1) {
            System.out.println(cyan + "\n Spielerzug \n" + farbReset);
        } else {
            System.out.println(purple + "\n Spielerzug \n" + farbReset);
        }
    }

    //Ausgabe Gegner ist dran
    public void printEnemyTurn() {
        System.out.println(red + "\n Gegnerzug \n" + farbReset);
    }

    //Ausgabe Richtungswahl des Spielers
    public char printPlayerTurnMessageAndAskInput(PlayerModel player) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n" + player.getName() + " ist dran. Um dich zu bewegen nutze die Eingaben 6 = rechts, 4 = links, 8 = hoch und 2 = unten" +
                ", möchtest du auf der aktuellen Position verweilen gebe eine 5 ein.");
        return sc.next().charAt(0);
    }

    //Ausgabe Gegner wählt Zug
    public void printEnemyTurnMessage(KIModel gegner) {
        System.out.println("\nDer Gegner ist am Zug und macht seine Eingabe...");
    }

    //Ausgabe Richtungsauswahl Gegner
    public void printEnemyTurnChoice(int enemyInput) {
        System.out.println("Der Gegner hat die Eingabe " + enemyInput + " gewählt");
    }

    //Ausgabe Zugmöglichkeiten
    public int printPossibilities(int input) {
        System.out.println("Der Gegner befindet sich in Angriffsreichweite.");
        System.out.println("1. Angriff starten");
        System.out.println("2. Bewegen");

        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    //Ausgabe Fehler, Spieler kann nicht in die ausgewählte Richtung
    public void printErrorPlayerMoveMessage() {
        System.out.println("Dieser Zug würde aus dem Spielfeld führen oder eine Barriere ist im Weg, bitte versuche es erneut. ");
    }

    //Ausgabe Fehler, Bot kann nicht in die ausgewählte Richtung
    public void printErrorEnemyMoveMessage() {
        System.out.println("Die Eingabe des Gegners würde aus dem Spielfeld führen oder eine Barriere ist im Weg, der Gegner versucht es erneut.");
    }

    //Ausgabe Spieler kann Gegner angreifen
    public int printEnemyInAttackRangeMessage() {
        System.out.println("Der Gegner befindet sich in Angriffsreichweite, möchtest du deinen Gegner angreifen (1) oder einen Schild aktivieren (2)? Bitte mache deine Eingabe:");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    //Ausgabe Spieler hat Attacke ausgeführt
    public void printPlayerAttackSuccessfullMessage(PlayerModel player, KIModel enemy) {
        System.out.println("Du hast " + player.getRobotModel().getDamage() + "Schaden an deinem Gegner gemacht. Der Gegner hat nur noch " + enemy.getRobotModel().getHealth() +
                "Leben übrig.");
    }

    //Ausgabe Bot hat Attacke ausgeführt
    public void printEnemyAttackSuccessfullMessage(KIModel enemy, PlayerModel player) {
        System.out.println("Der Gegner hat " + enemy.getRobotModel().getDamage() + "Schaden an dem Spieler verursacht. Der Spieler hat nur noch " + player.getRobotModel().getHealth() +
                "Leben übrig.");
    }

    //Ausgabe Bot kann Spieler angreifen
    public void printPlayerInAttackRangeMessage() {//TODO: Für später übergabe mit difficulty und dementsprechend Handlungswahl
        System.out.println("Der Spieler befindet sich in Angriffsreichweite des Gegners. Der Gegner greift an.");
    }

    //Ausgabe Sieger
    public void printWinner (int i) {
        if(i == 1) {
            System.out.println("Gratulation, du hast deinen Gegner besiegt!");
        } else {
            System.out.println("Schade, du hast verloren!");
        }
    }

}
