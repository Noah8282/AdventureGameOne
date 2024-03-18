import java.util.Random;

public class MeleeWeapon extends Weapon {
    private final String useName;
    private Random rn;
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
        return null;
    }

    @Override
    public String getUseName() {
        return useName;
    }

}
