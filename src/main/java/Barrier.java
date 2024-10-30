import java.util.Random;

public class Barrier {

    String type;
    String symbol;
    int lifePoints;
    int posZeile;
    int posSpalte;

    public Barrier(String type, String symbol, int lifePoints, int posZeile, int posSpalte) {
        this.type = type;
        this.symbol = symbol;
        this.lifePoints = lifePoints;
        this.posZeile = posZeile;
        this.posSpalte = posSpalte;
    }

    //Methode für zufällige Zeile
    public static int randomBarrierMax() {
        Random r = new Random();
        return r.nextInt(20);
    }
}


