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

    public String attack(Character character) {
        String msg = getEquipped().useWeapon(character);
        return msg;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
        setHealth((int)Math.ceil(rn.nextDouble(1)*difficulty*50));
        getEquipped().setDamage((int)Math.ceil(rn.nextDouble(1))*difficulty*10);

    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
