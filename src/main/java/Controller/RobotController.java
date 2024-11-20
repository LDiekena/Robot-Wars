package Controller;

import Model.RobotModel;
import View.RobotView;


public class RobotController {

    public int getAttribute(int input, RobotModel robot) {
        if (input == 1) {
            return robot.getLife();
        } else if (input == 2) {
            return robot.getShield();
        } else if (input == 3) {
            return robot.getEnergy();
        } else if (input == 4) {
            return robot.getDamage();
        } else if (input == 5) {
            return robot.getDamageZone();
        } else if (input == 6) {
            return robot.getRange();
        } else if (input == 7) {
            return robot.getAccuracy();
        } else if (input == 8) {
            return robot.getMobility();
        } else {
            return 0;
        }
    }

    //Methode Skillsteigerung
    public void skillIncrease(int attribute, int numberToIncrease, RobotModel robot, RobotView robotView) {
        if (attribute == 1) {
            robot.setLife(robot.getLife() + numberToIncrease);
            robot.setSkillpoints(robot.getSkillpoints() - numberToIncrease);
        } else if (attribute == 2) {
            robot.setShield(robot.getShield() + numberToIncrease);
            robot.setSkillpoints(robot.getSkillpoints() - numberToIncrease);
        } else if (attribute == 3) {
            robot.setEnergy(robot.getEnergy() + numberToIncrease);
            robot.setSkillpoints(robot.getSkillpoints() - numberToIncrease);
        } else if (attribute == 4) {
            robot.setDamage(robot.getDamage() + numberToIncrease);
            robot.setSkillpoints(robot.getSkillpoints() - numberToIncrease);
        } else if (attribute == 5) {
            robot.setDamageZone(robot.getDamageZone() + numberToIncrease);
            robot.setSkillpoints(robot.getSkillpoints() - numberToIncrease);
        } else if (attribute == 6) {
            robot.setRange(robot.getRange() + numberToIncrease);
            robot.setSkillpoints(robot.getSkillpoints() - numberToIncrease);
        } else if (attribute == 7) {
            robot.setAccuracy(robot.getAccuracy() + numberToIncrease);
            robot.setSkillpoints(robot.getSkillpoints() - numberToIncrease);
        } else if (attribute == 8) {
            robot.setMobility(robot.getMobility() + numberToIncrease);
            robot.setSkillpoints(robot.getSkillpoints() - numberToIncrease);
        } else {
            robotView.printErrorSkillpoints();
        }
    }

    //Methode Skillminderung
    public void skillDecrease(int attribute, int numberToDecrease, RobotModel robot, RobotView robotView) {
        if (attribute == 1) {
            robot.setLife(robot.getLife() - numberToDecrease);
            robot.setSkillpoints(robot.getSkillpoints() + numberToDecrease);
        } else if (attribute == 2) {
            robot.setShield(robot.getShield() - numberToDecrease);
            robot.setSkillpoints(robot.getSkillpoints() + numberToDecrease);
        } else if (attribute == 3) {
            robot.setEnergy(robot.getEnergy() - numberToDecrease);
            robot.setSkillpoints(robot.getSkillpoints() + numberToDecrease);
        } else if (attribute == 4) {
            robot.setDamage(robot.getDamage() - numberToDecrease);
            robot.setSkillpoints(robot.getSkillpoints() + numberToDecrease);
        } else if (attribute == 5) {
            robot.setDamageZone(robot.getDamageZone() - numberToDecrease);
            robot.setSkillpoints(robot.getSkillpoints() + numberToDecrease);
        } else if (attribute == 6) {
            robot.setRange(robot.getRange() - numberToDecrease);
            robot.setSkillpoints(robot.getSkillpoints() + numberToDecrease);
        } else if (attribute == 7) {
            robot.setAccuracy(robot.getAccuracy() - numberToDecrease);
            robot.setSkillpoints(robot.getSkillpoints() + numberToDecrease);
        } else if (attribute == 8) {
            robot.setMobility(robot.getMobility() - numberToDecrease);
            robot.setSkillpoints(robot.getSkillpoints() + numberToDecrease);
        } else {
            robotView.printErrorSkillpoints();
        }
    }

    //Methode zur Skillveränderung
    public void changeStats(RobotModel robot, RobotView robotView) {
        //Eingabe Attributauswahl
        int attributeAuswahl = robotView.askPlayerWhichAttribute();

        //Wiederholung der Eingabe Attributauswahl falls diese falsch ist
        while (attributeAuswahl < 1 || attributeAuswahl > 8) {
            attributeAuswahl = robotView.printErrorInputAttributeChoiceAndAskAgain();
        }

        //Eingabe Steigerung oder Senkung
        char attributChangeType = robotView.askIncreaseOrDecrease();

        //Wiederholung der Eingabe Steigerung/ Senkung falls diese falsch ist
        while (attributChangeType != '+' && attributChangeType != '-') {
            attributChangeType = robotView.printErrorIncreaseOrDecreaseAndAskAgain();
        }

        //Eingabe Veränderungswert
        int numberToChange = robotView.askNumberForSkillchange();

        //TODO: Robot Übergabe von Game? Player Robot für Skillpoints notwendig
        //Wiederholung der Eingabe je nach Fehlerfall
        while (numberToChange > robot.getSkillpoints() && attributChangeType == '+' || attributChangeType == '-' && getAttribute(attributeAuswahl, robot) == 1 ||
                attributChangeType == '-' && getAttribute(attributeAuswahl, robot) - numberToChange < 1) {

            //Abfrage Eingabe übersteigt Skillpunkte
            if (numberToChange > robot.getSkillpoints() && attributChangeType == '+') {
                robotView.printErrorInputHigherThanSkillpointsAndAskAggain();

                //Abfrage gewähltes Attribut hat bereits Minimalwert
            } else if (attributChangeType == '-' && getAttribute(attributeAuswahl, robot) == 1) {
                robotView.printErrorAtributeIsMinimalAndAskAgain();
                attributChangeType = '+'; //Veränderung der Auswahl da keine Senkung möglich

                //Abfrage Senkung unterschreitet nicht den Minimalwert
            } else if (attributChangeType == '-' && getAttribute(attributeAuswahl, robot) - numberToChange < 1) {
                robotView.printErrorInvalidDecreaseAndAskAgein();
            }
        }

        //Wertsteigerung des Attributes
        if (attributChangeType == '+') {
            skillIncrease(attributeAuswahl, numberToChange, robot, robotView);
            robotView.printSkillIncreaseSuccessful(numberToChange);
            robotView.printStats(robot);

            //Wertminderung des Attributes
        } else if (attributChangeType == '-') {
            skillDecrease(attributeAuswahl, numberToChange, robot, robotView);
            robotView.printSkillDecreaseSuccessful(numberToChange);
            robotView.printStats(robot);

            //Fehler Skillchange
        } else {
            robotView.printErrorSkillchange();
        }

    }


}
