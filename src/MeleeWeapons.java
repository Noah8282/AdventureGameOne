public class MeleeWeapons extends Weapons{


    public MeleeWeapons(String shortName, String longName, int damage, int uses) {
        super(shortName, longName, damage, uses);
    }

    public MeleeWeapons(String longName, int damage, int uses) {
        super(longName, damage, uses);
    }

    @Override
    public String useWeapon() {
        return null;
    }
}
