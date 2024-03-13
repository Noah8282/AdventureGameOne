import java.util.Random;

public class Food extends Item {
    private int healthPoints;

    public Food(String longName, String shortName) {
        super(longName, shortName);
        this.healthPoints = setHealthRandom();
    }

    public Food(String longName) {
        super(longName);
        this.healthPoints = setHealthRandom();
    }

    public int getHealthPoints() {
        return healthPoints;
    }


    private int setHealthRandom() {
        Random rn = new Random();
        double num = rn.nextInt(10, 100);

        if (num % 10 < 5) {
            return (int) Math.floor(num / 5) * 5;
        } else {
            return (int) Math.ceil(num / 5) * 5;
        }
    }
}








