import java.util.ArrayList;

public class Adventure {

    ////////// ATTRIBUTES //////////
    private Map map;
    private Player player;
    private AudioPlayer wavPlayer;

    public Adventure() {
        map = new Map();
        wavPlayer = new AudioPlayer(map.getRoomList());
        player = new Player(map.getFirstRoom(), wavPlayer);
    }

    public String goDirection(String direction) {
        return player.goDirection(direction);
    }

    public String look() {
        return player.look();
    }

    public String unLock(String direction) {
        return player.unLock(direction);
    }

    public String toggleDark() {
        return player.toggleDark();
    }
    public String pickUpItem(ArrayList<String> input) {
        return player.pickUpItem(input);
    }
    public String dropItem(ArrayList<String> input) {
        return player.dropItem(input);
    }
    public String eatItem(Food input) {
        return player.eatItem(input);
    }

    public ArrayList<Object> tryEatItem(ArrayList<String> input) {
        return player.tryEatItem(input);
    }

    public String teleport() {
        return player.teleport();
    }

    public String userToggleMusic() {
        return wavPlayer.userToggleMusic();
    }

    public String getInv() {
        return player.getInv();
    }

    public String getHealth() {
        return player.getHealth();
    }



}

