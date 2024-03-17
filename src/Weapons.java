public abstract class Weapons extends Item{

    private int damage;
    private int remainingUses;

    public Weapons(String shortName, String longName, int damage, int remainingUses) {
        super(shortName, longName);
        this.damage = damage;
        this.remainingUses = remainingUses;
    }

    public Weapons(String longName, int damage, int remainingUses) {
        super(longName);
        this.damage = damage;
        this.remainingUses = remainingUses;
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

    public int getRemainingUses() {
        return remainingUses;
    }

    public abstract String useWeapon();
    public abstract String useName();


}
