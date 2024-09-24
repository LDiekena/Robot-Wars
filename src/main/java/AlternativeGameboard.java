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

        //Barrieren für das Spielfeld       TODO: Mehrere Barrierenfelder von den verschiedenen Arten
        String steinBarriere = "▲";
        String pflanzeBarriere = "♣";
        String wasserBarriere = "≋";

        int posZeileSteinBarrier = r.nextInt(9);
        int posSpalteSteinBarrier = r.nextInt(14);

        int posZeilePflanzeBarrier = r.nextInt(9);
        int posSpaltePflanzeBarrier = r.nextInt(14);

        int posZeileWasserBarrier = r.nextInt(9);
        int posSpalteWasserBarrier = r.nextInt(14);

        //Spielfelderstellung
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length - 1; j++) {
                if (i == posZeile && j == posSpalte && gewaehlterAvatar == avatar1) {
                    System.out.print(" [" + avatar1 + "]");
                } else if (i == posZeile && j == posSpalte && gewaehlterAvatar == avatar2) {
                    System.out.print(" [" + avatar2+ "]");
                } else if (i == posZeileSteinBarrier && j == posSpalteSteinBarrier) {
                    System.out.print(" [" + steinBarriere+ "]");
                } else if (i == posZeilePflanzeBarrier && j == posSpaltePflanzeBarrier) {
                    System.out.print(" [" + pflanzeBarriere + "]");
                } else if (i == posZeileWasserBarrier && j == posSpalteWasserBarrier) {
                    System.out.print(" [" + wasserBarriere + "]");
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
