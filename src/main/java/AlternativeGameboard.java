import java.util.Random;

public class AlternativeGameboard {
    public static void main(String[] args) {
        String[][] spielfeld = new String[10][15];
        Random r = new Random();


        int posZeile = r.nextInt(9);
        int posSpalte = r.nextInt(14);

        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 1; j < spielfeld[i].length; j++) {
                if (i == posZeile && j == posSpalte) {
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
