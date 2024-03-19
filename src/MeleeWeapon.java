import java.util.Random;

public class MeleeWeapon extends Weapon {
    private final String useName;
    public MeleeWeapon(String longName, String shortName, String useName) {
        super(longName, shortName);
        this.useName = useName;

    }
    public MeleeWeapon(String longName) {
        super(longName);
        this.useName = "durability";
    }
    public MeleeWeapon(String longName, String shortName) {
        super(longName, shortName);
        useName = "durability";
    }

    @Override
    public String useWeapon() {
        if (getRemainingUses() > 0) {
            // Decreasing the amount of ammo after each use
            setRemainingUses(getRemainingUses()-10);
            return "Swinging with "+getLongName();
            // Returning message for when a ranged weapon shoots
        } else {
            // Returning message when the ranged weapon has no ammo left
            return getLongName()+" out of "+useName+"!";
        }
    }

    @Override
    public String getUseName() {
        return useName;
    }

}
