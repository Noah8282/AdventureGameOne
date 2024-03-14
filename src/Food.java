import java.util.Random;

// Food klassen udvider Item klassen
public class Food extends Item {
    private int healthPoints; // Attribut til at holde antallet af sundhedspoint for madobjektet

    // Konstruktør der tager en lang og kort navn for madobjektet som input
    public Food(String longName, String shortName) {
        super(longName, shortName); // Kalder superklassens konstruktør med de givne navne
        this.healthPoints = setHealthRandom(); // Initialiserer healthPoints attributten ved at kalde metoden setHealthRandom()
    }

    // Konstruktør der tager kun et langt navn for madobjektet som input
    public Food(String longName) {
        super(longName); // Kalder superklassens konstruktør med det givne navn
        this.healthPoints = setHealthRandom(); // Initialiserer healthPoints attributten ved at kalde metoden setHealthRandom()
    }

    // Metode til at få antallet af sundhedspoint for madobjektet
    public int getHealthPoints() {
        return healthPoints;
    }

    // Metode til at generere et tilfældigt antal sundhedspoint for madobjektet
    private int setHealthRandom() {
        Random rn = new Random(); // Opretter et nyt Random objekt
        double num = rn.nextInt(10, 100); // Genererer et tilfældigt tal mellem 10 og 100

        // Afrunder tallet til det nærmeste multiplum af 5 og returnerer det som antallet af sundhedspoint
        if (num % 10 < 5) {
            return (int) Math.floor(num / 5) * 5;
        } else {
            return (int) Math.ceil(num / 5) * 5;
        }
    }
}
