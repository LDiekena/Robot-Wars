import java.util.Random;

public class Barrier {

    private final String type;
    private final String symbol;
    private int lifePoints;
    private int posZeile;
    private int posSpalte;

    //Konstruktor
    public Barrier(String type, String symbol, int lifePoints, int posZeile, int posSpalte) {
        this.type = type;
        this.symbol = symbol;
        this.lifePoints = lifePoints;
        this.posZeile = posZeile;
        this.posSpalte = posSpalte;
    }
    //Getter
    public String getType() {
        return type;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getPosZeile() {
        return posZeile;
    }

    public int getPosSpalte() {
        return posSpalte;
    }

    //Setter
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setPosZeile(int posZeile) {
        this.posZeile = posZeile;
    }

    public void setPosSpalte(int posSpalte) {
        this.posSpalte = posSpalte;
    }

    //Methode für zufällige Zeile
    public static int randomBarrierMax() {
        Random r = new Random();
        return r.nextInt(20);
    }
}


