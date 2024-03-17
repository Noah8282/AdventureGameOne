public class MeleeWeapons extends Weapons{
    private final String useName;

    public MeleeWeapons(String shortName, String longName, int damage, int uses) {
        super(shortName, longName, damage, uses);
        useName = "durability";
    }

    public MeleeWeapons(String longName, int damage, int uses) {
        super(longName, damage, uses);
        useName = "durability";
    }

    @Override
    public String useWeapon() {
        return null;
    }

    @Override
    public String useName() {
        return useName;
    }
}
