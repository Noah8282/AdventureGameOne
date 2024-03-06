public class Adventure {

    ////////// ATTRIBUTES //////////
    private Map map;
    private Player player;

    public Adventure() {
        map = new Map();
        player = new Player(map.getFirstRoom());
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


}

