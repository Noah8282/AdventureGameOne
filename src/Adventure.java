import java.util.ArrayList;

public class Adventure {

    ////////// ATTRIBUTES //////////
    private Map map; // En attribut til at holde et objekt af typen Map
    private Player player; // En attribut til at holde et objekt af typen Player
    private AudioPlayer wavPlayer; // En attribut til at holde et objekt af typen AudioPlayer

    // Konstruktør der initialiserer attributterne map, player og wavPlayer
    public Adventure() throws CloneNotSupportedException {
        map = new Map(); // Opretter et nyt Map objekt
        wavPlayer = new AudioPlayer(map.getRoomList()); // Opretter et nyt AudioPlayer objekt med en liste af rum fra map objektet
        player = new Player(map.getFirstRoom(), wavPlayer); // Opretter et nyt Player objekt med det første rum fra map objektet og wavPlayer objektet
    }

    // Metode til at flytte spilleren i en given retning
    public String goDirection(String direction) {
        return player.goDirection(direction);
    }

    // Metode til at kigge rundt i det aktuelle rum
    public String look() {
        return player.look();
    }

    public String attack() {
        return player.attack();
    }

    // Metode til at låse op for en given retning
    public String unLock(String direction) {
        return player.unLock(direction);
    }

    // Metode til at skifte mellem lyse og mørke tilstande
    public String toggleDark() {
        return player.toggleDark();
    }

    // Metode til at samle et objekt op
    public String pickUpItem(ArrayList<String> input) {
        return player.pickUpItem(input);
    }

    // Metode til at droppe et objekt
    public String dropItem(ArrayList<String> input) {
        return player.dropItem(input);
    }

    // Metode til at spise et madobjekt
    public String eatItem(Food input) {
        return player.eatItem(input);
    }

    // Metode til at forsøge at spise et madobjekt
    public ArrayList<Object> tryEatItem(ArrayList<String> input) {
        return player.tryEatItem(input);
    }

    // Metode til at teleportere spilleren til et andet rum
    public String teleport() {
        return player.teleport();
    }

    public String equipWeapon(ArrayList<String> input) {
        return player.equipWeapon(input);
    }

    // Metode til at få en oversigt over spillerens inventory
    public String getInv() {
        return player.getInv();
    }

    // Metode til at få spillerens helbredstilstand
    public String getHealth() {
        return player.getHealth();
    }

    // Metode til at lade brugeren skifte musikken
    public String userToggleMusic() {
        return wavPlayer.userToggleMusic();
    }

}
