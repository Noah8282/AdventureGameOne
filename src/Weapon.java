import java.util.Random;

public abstract class Weapon extends Item {

    private int damage;
    private int remainingUses;
    private final Random rn = new Random();
    private final int MIN_USES = 20;
    private final int MAX_USES = 50;

    public Weapon(String longName, String shortName) {
        super(longName, shortName);
        setRandomUses();
    }

    public Weapon(String longName) {
        super(longName);
        setRandomUses();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    public void setRemainingUses(int remainingUses) {
        this.remainingUses = remainingUses;
    }

    public void setRandomUses() {
        this.remainingUses = rn.nextInt(MIN_USES,MAX_USES+1);
    }

    public int getRemainingUses() {
        return remainingUses;
    }

    public abstract String useWeapon();
    public abstract String getUseName();




}
