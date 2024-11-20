package View;

import Model.KIModel;

public class KIView {
    //KI
    public void displayEnemyPositionText(KIModel gegner) {
        System.out.println("Dein Gegner " + gegner.getName() + " befindet sich zu Beginn in dem Feld (" + (gegner.getPosZeile() + 1) + "|"
                + (gegner.getPosSpalte() + 1) + ").");
    }

    public void printUpdatedEnemyPositionText(KIModel gegner) {
        System.out.println("Der Gegner " + gegner.getName() + " befindet sich auf dem Feld (" + (gegner.getPosZeile() + 1) + "|"
                + (gegner.getPosSpalte() + 1) + ").");
    }

}
