import java.util.Random;

public abstract class Weapon extends Item {

    private int damage;
    private String useName;
    private int remainingUses;
    private int decrement;
    private final Random rn = new Random();
    private final int MIN_USES = 20;
    private final int MAX_USES = 50;

    public Weapon(String longName, String shortName, int decrement) {
        super(longName, shortName);
        this.decrement = decrement;
        setRandomUses();
    }

    public Weapon(String longName, int decrement) {
        super(longName);
        this.decrement = decrement;
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

    public void setRandomDamage(int difficulty) {
        int difficultyMulti = (int) (difficulty*0.75);

        this.damage = rn.nextInt(10*difficulty,31*difficulty);
    }

    public int getRemainingUses() {
        return remainingUses;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getUseName() {
        return useName;
    }



    public String useWeapon(Character character) {
        if (remainingUses > 0 || character instanceof Enemy) {
            // Decreasing the amount of ammo after each use
            setRemainingUses(remainingUses-decrement);
            character.setHealth(character.getHealth() - damage);
            int displayHealth = character.getHealth();
            if(character.getHealth() < 0) {
                displayHealth = 0;
            }

            return character.getName() + " was damaged by "+damage+" and now has "+displayHealth+" health.";
        } else {
            // Returning message when the ranged weapon has no ammo left
            return getLongName()+ " out of "+useName+"!";
        }
    }





}
