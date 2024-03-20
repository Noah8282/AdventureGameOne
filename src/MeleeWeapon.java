public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String longName, String shortName, String useName) {
        super(longName, shortName, 10);
        setUseName(useName);

    }
    public MeleeWeapon(String longName) {
        super(longName, 10);
        setUseName("durability");
    }
    public MeleeWeapon(String longName, String shortName) {
        super(longName, shortName, 10);
        setUseName("durability");
    }


}
