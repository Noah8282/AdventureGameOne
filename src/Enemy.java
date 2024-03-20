import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Character implements Cloneable {

    private ArrayList<Weapon> weaponList = new ArrayList<>();
    private Random rn;
    private int difficulty;
    public Enemy(int health, String name) throws CloneNotSupportedException {
        super(health, name);
        difficulty = 0;
        rn = new Random();
        addWeapons();
        setEquipped((Weapon)weaponList.get(rn.nextInt(0,weaponList.size())).clone());
    }

    private void addWeapons() {
        weaponList.add(new MeleeWeapon("A rusty axe"));
        weaponList.add(new MeleeWeapon("A heavy sword"));
        weaponList.add(new MeleeWeapon("A rusty iron shovel"));

        weaponList.add(new RangedWeapon("A hunters bow", "", "arrows"));
        weaponList.add(new RangedWeapon("A old AK-47"));
        weaponList.add(new RangedWeapon("A factory new Glock-17"));
    }

    @Override
    public String attack(Character character) {
        return null;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
        //Ændre health.
        //setHealth();
        //Ændre weapon damage.
        //getEquipped().setDamage();

        setHealth(100*rn.nextInt()*difficulty);
        getEquipped().setDamage(100*rn.nextInt()*difficulty);
        if(difficulty == 1) {
            setHealth(rn.nextInt(20,51));
            getEquipped().setDamage(rn.nextInt(10,40));
        } else if(difficulty == 2) {
            setHealth(rn.nextInt(40,81));
            getEquipped().setDamage(rn.nextInt(30,60));
        }
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
