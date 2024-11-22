package View;

import Model.PlayerModel;

public class PlayerView {

    //Ausgabe Startposition vom Spieler
    public void printPlayerStartpositionText(PlayerModel player) {
        System.out.println("\nDein Roboter befindet sich zu Beginn in dem Feld (" + (player.getPosZeile() + 1) + "|" + (player.getPosSpalte() + 1) + ").");
    }

    //Ausgabe aktuelle Position vom Spieler
    public void printUpdatedPlayerPositionText(PlayerModel player) {
        System.out.println("Dein Roboter befindet sich auf dem Feld (" + (player.getPosZeile() + 1) + "|" + (player.getPosSpalte() + 1) + ").");
    }
}
