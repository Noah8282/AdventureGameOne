public abstract class Character {

    //ATTRIBUTES
    private int health;
    private Weapon equipped;
    private String name;

    public Character(int health, String name) {
        this.health = health;
        this.equipped = null;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Weapon getEquipped() {
        return equipped;
    }

    public void setEquipped(Weapon equipped) {
        this.equipped = equipped;
    }

    public String getName() {
        return name;
    }

    public abstract String attack(Character character);

}
