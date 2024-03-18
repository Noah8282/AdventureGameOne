import java.util.Random;

public abstract class Weapon extends Item{

    // Attributes specific to the class Weapon
    private int damage;
    private int remainingUses;
    private final Random rn = new Random(); // Random number generator
    private final int MIN_USES = 20; // Minimum number of uses
    private final int MAX_USES = 50; // Maximum number of uses

    // Constructor for Weapon with longName and shortName
    public Weapon(String longName, String shortName) {
        // Calling the superclass constructor with longName and shortName
        super(longName, shortName);
        // Initializing remainingUses with a random value between the MIN_USES and MAX_USES that we've set
        this.remainingUses = rn.nextInt(MIN_USES,MAX_USES+1);
    }


    // Constructor for Weapon with only longName
    public Weapon(String longName) {
        // Also calling the superclass constructor with longName
        super(longName);
        // Also initializing remainingUses with a random value between MIN_USES and MAX_USES
        this.remainingUses = rn.nextInt(MIN_USES,MAX_USES+1);
    }

    // Getter method for the damage attribute
    public int getDamage() {
        return damage;
    }
    // Setter method for the damage attribute
    public void setDamage(int damage) {
        this.damage = damage;
    }

    // Setter method for remainingUses attribute
    public void setRemainingUses(int remainingUses) {
        this.remainingUses = remainingUses;
    }

    // Getter method for remainingUses attribute
    public int getRemainingUses() {
        return remainingUses;
    }

    // Abstract method for using the weapon (to be implemented by subclasses)
    public abstract String useWeapon();
    // Abstract method for getting the use name of the weapon (to be implemented by subclasses)
    public abstract String getUseName();


}
