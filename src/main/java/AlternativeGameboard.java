import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AlternativeGameboard {
    public static void main(String[] args) {

        //Array in der Größe 10x15
        String[][] spielfeld = new String[10][15];
        Random r = new Random();

        //Randomizer für die Startposition
        int posZeile = r.nextInt(9);
        int posSpalte = r.nextInt(14);

        //Avatar
        int avatar = 2; //Für Testzwecke starr
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

        //Barrieren für das Spielfeld
        int zStein = 5;
        int sStein = 5;
        int zPflanzen = 10;
        int sPflanzen = 10;
        int zWasser = 7;
        int sWasser = 7;

        //TODO: Ummodelieren auf zweidimensionale Arrays
        List<Integer> steinZeile = new ArrayList<>();
        List<Integer> steinSpalte = new ArrayList<>();
        List<Integer> pflanzenZeile = new ArrayList<>();
        List<Integer> pflanzenSpalte = new ArrayList<>();
        List<Integer> wasserZeile = new ArrayList<>();
        List<Integer> wasserSpalte = new ArrayList<>();

        //Symbole für Barrierenfeldern
        String steinBarriere = "▲";
        String pflanzeBarriere = "♣";
        String wasserBarriere = "≋";

        //Random Positionen für die Barrieren TODO: Methode für alle Arten
        while (steinZeile.size() < zStein) {
            int posSteinBarrier = r.nextInt(9);
            steinZeile.add(posSteinBarrier);
            zStein--;
        }
        while (steinSpalte.size() < sStein) {
            int posSteinBarrier = r.nextInt(14);
            steinSpalte.add(posSteinBarrier);
            sStein--;
        }
        while (pflanzenZeile.size() < zPflanzen) {
            int posPflanzenBarrier = r.nextInt(9);
            pflanzenZeile.add(posPflanzenBarrier);
            zPflanzen--;
        }
        while (pflanzenSpalte.size() < sPflanzen) {
            int posPflanzenBarrier = r.nextInt(14);
            pflanzenSpalte.add(posPflanzenBarrier);
            sPflanzen--;
        }
        while (wasserZeile.size() < zWasser) {
            int posWasserBarrier = r.nextInt(9);
            wasserZeile.add(posWasserBarrier);
            zWasser--;
        }
        while (wasserSpalte.size() < sWasser) {
            int posWasserBarrier = r.nextInt(14);
            wasserSpalte.add(posWasserBarrier);
            sWasser--;
        }

        //Zähler für die
        int anzahlStein = 0;
        int anzahlPflanzen = 0;
        int anzahlWasser = 0;





        //Spielfelderstellung leeres Spielfeld
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                spielfeld[i][j] = " [ ]";
            }
        }

        //Array für Barrierenpositionen
        int[] barrierenColumn = new int[25];
        int[] barrierenRow = new int[25];

        //Generiere Random Positionen
        for (int i = 0; i < barrierenColumn.length; i++) {
                barrierenColumn[i] = randomNumberColumn(i);
        }

        for (int i = 0; i < barrierenRow.length; i++) {
            barrierenRow[i] = randomNumberRow(i);
        }

        System.out.println(Arrays.toString(barrierenColumn));
        System.out.println(Arrays.toString(barrierenRow));

        int barrierCounter = 0;
        //Barrieren hinzufügen
        while (barrierCounter < 25) {
            //TODO: Denkfehler herausfinden
        }


        //Position des Spielers auf dem Spielfeld ausgeben



    /*    for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length - 1; j++) {
                if (i == posZeile && j == posSpalte && gewaehlterAvatar == avatar1) {
                    spielfeld[i][j] = " [" + avatar1 + "]";
                } else if (i == posZeile && j == posSpalte && gewaehlterAvatar == avatar2) {
                    spielfeld[i][j] = " [" + avatar2 + "]";
                } else if (i == steinZeile.get(anzahlStein) && j == steinSpalte.get(anzahlStein) && i!= posZeile && j !=posSpalte) {
                    spielfeld[i][j] = " [" + steinBarriere + "]";
                    anzahlStein++;
                } else if (i == pflanzenZeile.get(anzahlPflanzen) && j == pflanzenSpalte.get(anzahlPflanzen) && i!= posZeile && j !=posSpalte
                        && pflanzenZeile.get(anzahlPflanzen) != steinZeile.get(anzahlStein) && pflanzenSpalte.get(anzahlPflanzen)
                        != steinSpalte.get(anzahlStein)) {
                    spielfeld[i][j] = " [" + pflanzeBarriere + "]";
                    anzahlPflanzen++;
                } else if (i == wasserZeile.get(anzahlWasser) && j == wasserSpalte.get(anzahlWasser) && i!= posZeile && j !=posSpalte
                        && wasserZeile.get(anzahlWasser) != steinZeile.get(anzahlStein) && wasserSpalte.get(anzahlWasser)
                        != steinSpalte.get(anzahlStein) && wasserZeile.get(anzahlWasser) != pflanzenZeile.get(anzahlPflanzen)
                        && wasserZeile.get(anzahlWasser) != pflanzenSpalte.get(anzahlPflanzen) ) {
                    spielfeld[i][j] = " [" + wasserBarriere + "]";
                    anzahlWasser++;
                } else {
                    spielfeld[i][j] = " [ ]";
                }
            }
        }
        */

        //Print vom Spielfeld-Array
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length - 1; j++) {
                System.out.print(spielfeld[i][j]);
            }
            System.out.println();
        }

        //Für Textausgabe, da Array start mit 0
        posZeile++;

        System.out.println("Dein Roboter befindet sich auf Position (S:" + posSpalte + "|Z:" +  posZeile + ").");
    }

    //TODO: Methode für Random Number
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
