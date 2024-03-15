public abstract class Weapons extends Item{

    public Weapons(String shortName, String longName, int damageMultiplier) {
        super(shortName, longName);
    }

    public Weapons(String longName, int damageMultiplier) {
        super(longName);
    }

    public abstract String durability();

    public abstract String attack();


}
