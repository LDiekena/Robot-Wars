import java.util.*;

public class runGame {
    //Objektgenerierung
    static ASCII_Arts asciiArts = new ASCII_Arts();
    static Gameboard board = new Gameboard(10, 15);
    static Game game = new Game(' ', ' ', true, false);
    static Robot robot1 = new Robot("Roboter Nr. 1", ASCII_Arts.cyan + "§" + ASCII_Arts.farbReset,
            10, 1, 1, 1, 1, 1, 1, 1, 1);
    static Robot robot2 = new Robot("Roboter Nr. 2", ASCII_Arts.purple + "∆" + ASCII_Arts.farbReset,
            10, 1, 1, 1, 1, 1, 1, 1, 1);
    //KI Robot erstmal mit fester Skillverteilung, TODO: später eventuell noch random verteilt
    static Robot bot1 = new Robot("Bot 1", ASCII_Arts.red + "¥" + ASCII_Arts.farbReset,
            0, 3, 2, 2, 3, 1, 1, 3, 3);

    //Scanner
    public static Scanner sc = new Scanner(System.in);

    //Spielererstellung mit Zuweisung
    public static String avatar1 = robot1.getSymbol();
    public static String avatar2 = robot2.getSymbol();
    public static Robot gewaehlterAvatar;

    public static void main(String[] args) throws InterruptedException {

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
        int wahlRobot = sc.nextInt();

        //Abfrage ob eingegebene Auswahl korrekt bis diese korrekt ist
        while (wahlRobot != 1 && wahlRobot != 2) {
            System.out.println("Deine Eingabe war ungültig, bitte gebe entweder eine 1 für Roboter Nr. 1" +
                    " ein oder die 2 für Roboter Nr. 2!");
            wahlRobot = sc.nextInt();
        }
        //Ende Part Begrüßung und Avatarauswahl


        //Beginn Part Spieler- & Gegnerinitialisierung
        if (wahlRobot == 1) {
            gewaehlterAvatar = robot1;
        } else if (wahlRobot == 2) {
            gewaehlterAvatar = robot2;
        } else {
            System.out.println("Fehler beim zuweisen des Avatars.");
        }

        System.out.println("Du hast den Roboter Nr. " + gewaehlterAvatar.getName() + " gewählt. Auf dem Spielfeld wird dieser durch das Symbol " +
                gewaehlterAvatar.getSymbol() + " repräsentiert. Dein Gegner wird mit dem Symbol " + bot1.getSymbol() + " angezeigt\n");

        Player player = new Player(name, Gameboard.randomNumberRow(), Gameboard.randomNumberColumn(), 0, 0, gewaehlterAvatar);
        KI gegner = new KI("Bot 1", Gameboard.randomNumberRow(), Gameboard.randomNumberColumn(), "easy", bot1);
        //Ende Part Spieler- & Gegnerinitialisierung


        //Start Werteverteilung des Roboters
        System.out.println("Alle Werte deines Roboters sind zum Initial mit dem Wert 1 festgesetzt. Bitte verteile nachfolgend " +
                "die [" + gewaehlterAvatar.getSkillpoints() + "] zur Verfügung stehenden Skillpunkte um dir deinen Robotor zu Individualisieren. ");
        gewaehlterAvatar.printStats();

        //Verteilung der Skillpunkte bis keine mehr übrig sind
        while (gewaehlterAvatar.getSkillpoints() > 0) {
            gewaehlterAvatar.changeStats();
        }
        //Ende Werteverteilung des Rooboters


        
        //Beginn Part Spielfeldinitialisierung
        System.out.println("Das Spielfeld wird für das Spiel vorbereitet.\n");
        //java.lang.Thread.sleep(2000); //Künstliche Pause

        //Initialisierung leere Felder, Barrieren, Roboterpositionen und Ausgabe des Spielfeldes
        board.fillStartboard();
        board.placeBarrier();
        board.placeRobots(gewaehlterAvatar.getSymbol(), gegner.getRobot().getSymbol(), player.getPosZeile(), player.getPosSpalte(), gegner.getPosZeile(), gegner.getPosSpalte());
        board.printGameBoard();

        //Position des Spielers und Bots beim Start schriftlich für den Spieler
        System.out.println("\nDein Roboter befindet sich zu Beginn in dem Feld (" + (player.getPosZeile() + 1) + "|" + (player.getPosSpalte() + 1) + ").");
        System.out.println("Dein Gegner " + gegner.getName() + " befindet sich zu Beginn in dem Feld (" + (gegner.getPosZeile() + 1) + "|"
                + (gegner.getPosSpalte() + 1) + "). \nViel Spaß beim Spielen!");
        //Ende Part Spielfeldinitialisierung



        /*TODO: Wenn beide auf einem Feld sind dann Kampfsequenz mit beiden Roboter Strings und Lebensanzeige, Aktionsauswahl Attacke oder Flucht, Flucht Auswahl Richtung,
        vielleicht LP Regeneration nach Anzahl Züge?, erster Hit von Roboter der auf das Feld des anderen ankommt und Kampf startet
         */
        //Start Part Spiel
        //Bishergie Gewinnbedingung nur Erreichung des Gegnerfeldes
        while (player.getPosZeile() != gegner.getPosZeile() || player.getPosSpalte() != gegner.getPosSpalte()) {
            //Spielerzug
            while (game.getSpielerZug()) {
                int playerMoveCounter = player.getRobot().getMobility();
                while (playerMoveCounter >= 1) {
                    System.out.println("\n" + player.getName() + " ist dran. Um dich zu bewegen nutze die Eingaben 6 = rechts, 4 = links, 8 = hoch und 2 = unten" +
                            ", möchtest du auf der aktuellen Position verweilen gebe eine 5 ein.");
                    char zugEingabe = sc.next().charAt(0);
                    game.setZugEingabe(zugEingabe);
                    //TODO: MoveCounter anhand der mobility des Roboters, move solange bis Counter = 0
                    if (game.isMoveValid(player.getPosZeile(), player.getPosSpalte(), game.getZugEingabe())) { // && game.testBarrierInWay(posZeile, posSpalte, zugEingabe)
                        player.move(game.getZugEingabe(), player.getRobot().getSymbol(), player.getPosZeile(), player.getPosSpalte(), game.getSpielerZug(), game.getGegnerZug());
                        System.out.println("Dein Roboter befindet sich auf dem Feld (" + (player.getPosZeile() + 1) + "|" + (player.getPosSpalte() + 1) + ").");
                        playerMoveCounter--;
                    } else {
                        System.out.println("Dieser Zug würde aus dem Spielfeld führen oder eine Barriere ist im Weg, bitte versuche es erneut. ");
                    }
                }
            }

            //Ausgabe des Spielerzuges
            if (Objects.equals(gewaehlterAvatar.getSymbol(), avatar1)) {
                System.out.println(ASCII_Arts.cyan + "\n Spielerzug \n" + ASCII_Arts.farbReset);
            } else if (Objects.equals(gewaehlterAvatar.getSymbol(), avatar2)) {
                System.out.println(ASCII_Arts.purple + "\n Spielerzug \n" + ASCII_Arts.farbReset);
            }
            board.printGameBoard();

            //Spieler überschreibt den Gegner -> Spielersieg
            if (player.getPosZeile() == gegner.getPosZeile() && player.getPosSpalte() == gegner.getPosSpalte()) {
                System.out.println("\nGlückwunsch! Du hast deinen Gegner besiegt!");
            } else {
                //Gegnerzug
                while (game.getGegnerZug()) {
                    int gegnerMoveCounter = gegner.getRobot().getMobility();
                    while (gegnerMoveCounter >= 1) {
                        System.out.println("\nDer Gegner ist am Zug und macht seine Eingabe...");
                        //java.lang.Thread.sleep(1500); //Künstliche Pause
                        char gegnerZugEingabe = KI.randomGegnerzug(); //TODO: Übergabe difficulty für später
                        game.setGegnerZugEingabe(gegnerZugEingabe);
                        System.out.println("Der Gegner hat die Eingabe " + game.getGegnerZugEingabe() + " gewählt");
                        if (game.isMoveValid(gegner.getPosZeile(), gegner.getPosSpalte(), game.getGegnerZugEingabe())) { // && game.testBarrierInWay(posZeile, posSpalte, zugEingabe)
                            gegner.move(game.getGegnerZugEingabe(), gegner.getPosZeile(), gegner.getPosSpalte(), gegner.getRobot().getSymbol(), game.getSpielerZug(), game.getGegnerZug());
                            System.out.println("Der Gegner " + gegner.getName() + " befindet sich auf dem Feld (" + (gegner.getPosZeile() + 1) + "|"
                                    + (gegner.getPosSpalte() + 1) + ").");
                            gegnerMoveCounter--;
                        } else {
                            System.out.println("Die Eingabe des Gegners würde aus dem Spielfeld führen oder eine Barriere ist im Weg, der Gegner versucht es erneut.");
                            gegnerZugEingabe = KI.randomGegnerzug(); //TODO: Übergabe difficulty für später
                            game.setGegnerZugEingabe(gegnerZugEingabe);
                        }
                    }
                }

                //Ausgabe des Gegnerzuges
                System.out.println(ASCII_Arts.red + "\n Gegnerzug \n" + ASCII_Arts.farbReset);
                board.printGameBoard();

                //Gegner überschreibt Spieler -> Gegnersieg
                if (gegner.getPosZeile() == player.getPosZeile() && gegner.getPosSpalte() == player.getPosSpalte()) {
                    System.out.println("Schade, du hast verloren!");
                }
            }
        }
        //Ende Part Spiel
    }

}