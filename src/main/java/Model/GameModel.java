package Model;

public class GameModel {
    //Attribute für einen Spielzug
    private char zugEingabe;
    private char gegnerZugEingabe;
    private boolean spielerZug;
    private boolean gegnerZug;

    //Konstruktor
    public GameModel(char zugEingabe, char gegnerZugEingabe, boolean spielerZug, boolean gegnerZug) {
        this.zugEingabe = zugEingabe;
        this.gegnerZugEingabe = gegnerZugEingabe;
        this.spielerZug = spielerZug;
        this.gegnerZug = gegnerZug;
    }

    //Getter
    public char getZugEingabe() {
        return zugEingabe;
    }

    public char getGegnerZugEingabe() {
        return gegnerZugEingabe;
    }

    public boolean getSpielerZug() {
        return spielerZug;
    }

    public boolean getGegnerZug() {
        return gegnerZug;
    }

    //Setter
    public void setZugEingabe(char zugEingabe) {
        this.zugEingabe = zugEingabe;
    }

    public void setGegnerZugEingabe(char gegnerZugEingabe) {
        this.gegnerZugEingabe = gegnerZugEingabe;
    }

    public void setSpielerZug(boolean spielerZug) {
        this.spielerZug = spielerZug;
    }

    public void setGegnerZug(boolean gegnerZug) {
        this.gegnerZug = gegnerZug;
    }
}
