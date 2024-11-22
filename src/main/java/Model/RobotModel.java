package Model;

public class RobotModel {
    private String name;
    private String symbol;
    private int skillpoints;
    private int life;
    private int energy;
    private int shield;
    private int damage;
    private int range;
    private int damageZone;
    private int accuracy;
    private int mobility;
    private int health;

    //Konstruktor
    public RobotModel(String name, String symbol, int skillpoints, int life, int energy, int shield, int damage, int range, int damageZone, int accuracy, int mobility,  int health) {
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
        this.health = health;
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

    public int getHealth() {
        return health;
    }

    //Setter
    public void setSkillpoints(int skillpoints) {
        this.skillpoints = skillpoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setDamageZone(int damageZone) {
        this.damageZone = damageZone;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setMobility(int mobility) {
        this.mobility = mobility;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
