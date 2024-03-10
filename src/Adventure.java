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

    public String teleport() {
        return player.teleport();
    }

    public String userToggleMusic() {
        return wavPlayer.userToggleMusic();
    }


}

