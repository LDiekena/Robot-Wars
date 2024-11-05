public class Robot {
    private final String name;
    private final String symbol;
    private int skillpoints;
    private int life;
    private int energy;
    private int shield;
    private int damage;
    private int range;
    private int damageZone;
    private int accuracy;
    private int mobility;

    //Konstruktor
    public Robot(String name, String symbol, int skillpoints, int life, int energy, int shield, int damage, int range, int damageZone, int accuracy, int mobility) {
        this.name = name;
        this.symbol = symbol;
        this.skillpoints = skillpoints;
        this.life = life;
        this.energy = energy;
        this.shield = shield;
        this.damage = damage;
        this.range = range;
        this.damageZone = damageZone;
        this.accuracy = accuracy;
        this.mobility = mobility;
    }

    //Getter
    public int getMobility() {
        return mobility;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getDamageZone() {
        return damageZone;
    }

    public int getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }

    public int getShield() {
        return shield;
    }

    public int getEnergy() {
        return energy;
    }

    public int getLife() {
        return life;
    }

    public int getSkillpoints() {
        return skillpoints;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public int getAttribute(int attributeInput) {
        if (attributeInput == 1) {
            return this.life;
        } else if (attributeInput == 2) {
            return this.shield;
        } else if (attributeInput == 3) {
            return this.energy;
        } else if (attributeInput == 4) {
            return this.damage;
        } else if (attributeInput == 5) {
            return this.damageZone;
        } else if (attributeInput == 6) {
            return this.range;
        } else if (attributeInput == 7) {
            return this.accuracy;
        } else if (attributeInput == 8) {
            return this.mobility;
        } else {
            return 0;
        }
    }

    public void printStats() {
        System.out.println("1. Leben: " + life);
        System.out.println("2. Schild: " + shield);
        System.out.println("3. Energie: " + energy);
        System.out.println("4. Schaden: " + damage);
        System.out.println("5. Schadenreichweite: " + damageZone);
        System.out.println("6. Trefferreichweite: " + range);
        System.out.println("7. Treffsicherheit: " + accuracy);
        System.out.println("8. Bewegungsrate: " + mobility);
        System.out.println("\nVerbleibende Anzahl an Skillpunkten: " + skillpoints + "\n");
    }

    public void changeStats() {
        //Eingabe Attributauswahl
        System.out.println("Bitte gebe das Attribut an das du verändern möchtest: ");
        int attributAuswahl = runGame.sc.nextInt();

        //Wiederholung der Eingabe Attributauswahl falls diese falsch ist
        while (attributAuswahl < 1 || attributAuswahl > 8) {
            System.out.println("Fehlerhafte Eingabe, bitte versuchen Sie es erneut: ");
            attributAuswahl = runGame.sc.nextInt();
        }

        //Eingabe Steigerung oder Senkung
        System.out.println("Bitte gebe nun ein ob du den Wert erhöhen (+) oder senken (-) möchtest: ");
        char attributChangeType = runGame.sc.next().charAt(0);

        //Wiederholung der Eingabe Steigerung/ Senkung falls diese falsch ist
        while (attributChangeType != '+' && attributChangeType != '-') {
            System.out.println("Fehlerhafte Eingabe, bitte versuchen Sie es erneut: ");
            attributChangeType = runGame.sc.next().charAt(0);
        }

        //Eingabe Veränderungswert
        System.out.println("Bitte gebe nun den Wert an um den du das gewählte Attribut ändern möchtest: ");
        int numberToChange = runGame.sc.nextInt();

        //Wiederholung der Eingabe je nach Fehlerfall
        while (numberToChange > skillpoints && attributChangeType == '+' || attributChangeType == '-' && getAttribute(attributAuswahl) == 1 ||
                attributChangeType == '-' && getAttribute(attributAuswahl) - numberToChange < 1) {
            //Abfrage Eingabe übersteigt Skillpunkte
            if (numberToChange > skillpoints && attributChangeType == '+') {
                System.out.println("Die eingegebene Anzahl übersteigt deine noch vorhandenen Skillpunkte, bitte versuche es erneut: ");
                numberToChange = runGame.sc.nextInt();
            //Abfrage gewähltes Attribut hat bereits Minimalwert
            } else if (attributChangeType == '-' && getAttribute(attributAuswahl) == 1) {
                System.out.println("Das ausgewählte Attribut ist bereits auf dem Minimalwert und kann nicht noch weiter gesenkt werden! Bitte gebe einen Wert ein um den du erhöhen" +
                        " möchtest:");
                attributChangeType = '+';
                numberToChange = runGame.sc.nextInt();
            //Abfrage Senkung unterschreitet nicht den Minimalwert
            } else if (attributChangeType == '-' && getAttribute(attributAuswahl) - numberToChange < 1) {
                System.out.println("Der eingegebene Wert würde den Minimalwert unterschreiten, bitte versuche es erneut: ");
                numberToChange = runGame.sc.nextInt();
            }
        }

        //Wertsteigerung des Attributes
        if (attributChangeType == '+') {
            skillIncrease(attributAuswahl, numberToChange);
            System.out.println("Das ausgewählte Attribut wurde erfolgreich um " + numberToChange + " erhöht. Deine Verteilung" +
                    " sieht nun wie folgt aus:");
            printStats();

        //Wertminderung des Attributes
        } else if (attributChangeType == '-') {
            skillDecrease(attributAuswahl, numberToChange);
            System.out.println("Das ausgewählte Attribut wurde erfolgreich um " + numberToChange + " gesenkt. Deine Verteilung" +
                    " sieht nun wie folgt aus:");
            printStats();
        } else {
            System.out.println("Fehler bei der Nutzung der Skillpunkte.");
        }
    }

    public void skillIncrease(int attribute, int numberToIncrease) {
        if (attribute == 1) {
            life = life + numberToIncrease;
            skillpoints = skillpoints - numberToIncrease;
        } else if (attribute == 2) {
            shield = shield + numberToIncrease;
            skillpoints = skillpoints - numberToIncrease;
        } else if (attribute == 3) {
            energy = energy + numberToIncrease;
            skillpoints = skillpoints - numberToIncrease;
        } else if (attribute == 4) {
            damage = damage + numberToIncrease;
            skillpoints = skillpoints - numberToIncrease;
        } else if (attribute == 5) {
            damageZone = damageZone + numberToIncrease;
            skillpoints = skillpoints - numberToIncrease;
        } else if (attribute == 6) {
            range = range + numberToIncrease;
            skillpoints = skillpoints - numberToIncrease;
        } else if (attribute == 7) {
            accuracy = accuracy + numberToIncrease;
            skillpoints = skillpoints - numberToIncrease;
        } else if (attribute == 8) {
            mobility = mobility + numberToIncrease;
            skillpoints = skillpoints - numberToIncrease;
        } else {
            System.out.println("Fehler bei der Zuweisung der Skillpunkte");
        }
    }

    public void skillDecrease(int attribute, int numberToDecrease) {
        if (attribute == 1) {
            life = life - numberToDecrease;
            skillpoints = skillpoints + numberToDecrease;
        } else if (attribute == 2) {
            shield = shield - numberToDecrease;
            skillpoints = skillpoints + numberToDecrease;
        } else if (attribute == 3) {
            energy = energy - numberToDecrease;
            skillpoints = skillpoints + numberToDecrease;
        } else if (attribute == 4) {
            damage = damage - numberToDecrease;
            skillpoints = skillpoints + numberToDecrease;
        } else if (attribute == 5) {
            damageZone = damageZone - numberToDecrease;
            skillpoints = skillpoints + numberToDecrease;
        } else if (attribute == 6) {
            range = range - numberToDecrease;
            skillpoints = skillpoints + numberToDecrease;
        } else if (attribute == 7) {
            accuracy = accuracy - numberToDecrease;
            skillpoints = skillpoints + numberToDecrease;
        } else if (attribute == 8) {
            mobility = mobility - numberToDecrease;
            skillpoints = skillpoints + numberToDecrease;
        } else {
            System.out.println("Fehler bei der Zuweisung der Skillpunkte");
        }
    }

}
