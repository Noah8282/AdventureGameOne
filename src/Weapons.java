public abstract class Weapons extends Item{

    private int damage;
    private int uses;

    public Weapons(String shortName, String longName, int damage, int uses) {
        super(shortName, longName);
        this.damage = damage;
        this.uses = uses;
    }

    public Weapons(String longName, int damage, int uses) {
        super(longName);
        this.damage = damage;
        this.uses = uses;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    public void setUses(int uses) {
        this.uses = uses;
    }

    public int getUses() {
        return uses;
    }

    public abstract String useWeapon();


}
