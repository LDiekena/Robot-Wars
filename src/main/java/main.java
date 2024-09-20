public class main {
    public static void main(String[] args) {
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
        System.out.println("Dein Roboter befindet sich zu Beginn in dem Feld (z|s).");
    }

}
