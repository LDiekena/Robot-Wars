import java.util.Random;

public class AlternativeGameboard {
    public static void main(String[] args) {
        //Array in der Größe 10x15
        String[][] spielfeld = new String[10][15];
        Random r = new Random();

        //Randomizer für die Startposition
        int posZeile = r.nextInt(9);
        int posSpalte = r.nextInt(14);

        //Spielfelderstellung
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length - 1; j++) {
                if (i == posZeile && j == posSpalte) {
                    //TODO: Einbau Symbole je nach Avatar
                    System.out.print(" [X]");
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
