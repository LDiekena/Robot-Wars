import java.util.ArrayList;
import java.util.LinkedList;
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

        List<Integer> steinZeile = new ArrayList<>();
        List<Integer> steinSpalte = new ArrayList<>();
        List<Integer> pflanzenZeile = new ArrayList<>();
        List<Integer> pflanzenSpalte = new ArrayList<>();
        List<Integer> wasserZeile = new ArrayList<>();
        List<Integer> wasserSpalte = new ArrayList<>();

        String steinBarriere = "▲";
        String pflanzeBarriere = "♣";
        String wasserBarriere = "≋";

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

        int anzahlStein = 0;
        int anzahlPflanzen = 0;
        int anzahlWasser = 0;

        //TODO: Abfrage ob Feld schon Belegt ist (Barrieren oder Spieler), manchmal Problem
        //Spielfelderstellung
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length - 1; j++) {
                if (i == posZeile && j == posSpalte && gewaehlterAvatar == avatar1) {
                    System.out.print(" [" + avatar1 + "]");
                } else if (i == posZeile && j == posSpalte && gewaehlterAvatar == avatar2) {
                    System.out.print(" [" + avatar2+ "]");
                } else if (i == steinZeile.get(anzahlStein) && j == steinSpalte.get(anzahlStein)) {
                    System.out.print(" [" + steinBarriere+ "]");
                    anzahlStein++;
                } else if (i == pflanzenZeile.get(anzahlPflanzen) && j == pflanzenSpalte.get(anzahlPflanzen)) {
                    System.out.print(" [" + pflanzeBarriere + "]");
                    anzahlPflanzen++;
                } else if (i == wasserZeile.get(anzahlWasser) && j == wasserSpalte.get(anzahlWasser)) {
                    System.out.print(" [" + wasserBarriere + "]");
                    anzahlWasser++;
                } else {
                    System.out.print(" [ ]");
                }
            }
            System.out.println(" [ ]");
        }

        posZeile++;

        System.out.println("Dein Roboter befindet sich auf Position (S:" + posSpalte + "|Z:" +  posZeile + ").");
    }


}
