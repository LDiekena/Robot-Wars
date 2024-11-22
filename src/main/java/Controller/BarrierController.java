package Controller;

import java.util.Random;

public class BarrierController {
    //Notiz an mich: Abfrage welche Barrier anhand von Position

    //Methode für zufällige Zeile
    public int randomBarrierMax() {
        Random r = new Random();
        return r.nextInt(20);
    }
}
