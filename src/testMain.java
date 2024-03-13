import java.util.Random;

public class testMain {
    static int healthPoints;

    public static void main(String[] args) {
        System.out.println(setHealthRandom());
    }

    private static int setHealthRandom() {
        Random rn = new Random();
        double num = rn.nextInt(3, 5);
        ;
        if (num % 10 < 5) {
            healthPoints = (int) Math.floor(num / 5) * 5;
        } else {
            healthPoints = (int) Math.ceil(num / 5) * 5;
        }
        return  healthPoints;
    }
}