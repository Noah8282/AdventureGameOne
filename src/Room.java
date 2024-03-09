import java.util.ArrayList;

public class Room {
    private String description;
    private ArrayList<Item> items;


    ////////// ATTRIBUTES //////////
    //Name of the room
    private String name;
    //Description of room and rooms contents.
    private String shortDesc;
    private String longDesc;


    //The 4 neighbouring rooms. If null then there is no room to that orientation.
    private Room east;
    private Room west;
    private Room north;
    private Room south;

    //Lock Status directions
    private boolean lockedEast;
    private boolean lockedWest;
    private boolean lockedNorth;
    private boolean lockedSouth;

    //Darkness status
    private boolean dark;


    ////////// CONSTRUCTOR //////////
    public Room(String name, String shortDesc, String longDesc) {
        items = new ArrayList<>();
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        east = null;
        west = null;
        north = null;
        south = null;
        lockedEast = false;
        lockedWest = false;
        lockedNorth = false;
        lockedSouth = false;
        dark = false;
    }

    public String getName() {
        return name;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public boolean isDark() {
        return dark;
    }

    public void toggleDark() {
        this.dark = !dark;
    }

    public void setNextRoom(String dir, Room room) {
        switch (dir) {
            case "w" -> {
                if (west != room) {
                    west = room;
                    west.setNextRoom("e",this);
                }
            }
            case "e" -> {
                if (east != room) {
                    east = room;
                    east.setNextRoom("w",this);
                }
            }
            case "n" -> {
                if (north != room) {
                    north = room;
                    north.setNextRoom("s",this);
                }
            }
            case "s" -> {
                if (south != room) {
                    south = room;
                    south.setNextRoom("n",this);
                }
            }
            default -> throw new IllegalStateException("setNextRoom: Unexpected value: " + dir);
        };
    }

    public Room getNextRoom(String dir) {
        return switch (dir) {
            case "w" -> west;
            case "e" -> east;
            case "n" -> north;
            case "s" -> south;
            default -> throw new IllegalStateException("getNextRoom: Unexpected value: " + dir);
        };

    }

    public void unlockRoom(String dir) {
        switch (dir) {
            case "w" -> lockedWest = false;
            case "e" -> lockedEast = false;
            case "n" -> lockedNorth = false;
            case "s" -> lockedSouth = false;
            default -> throw new IllegalStateException("unlockRoom: Unexpected value: " + dir);
        };
    }

    public void lockRoom(String dir) {
        switch (dir) {
            case "w" -> lockedWest = true;
            case "e" -> lockedEast = true;
            case "n" -> lockedNorth = true;
            case "s" -> lockedSouth = true;
            default -> throw new IllegalStateException("lockRoom: Unexpected value: " + dir);
        };
    }

    public boolean isLocked(String dir) {
        return switch (dir) {
            case "w" -> lockedWest;
            case "e" -> lockedEast;
            case "n" -> lockedNorth;
            case "s" -> lockedSouth;
            default -> throw new IllegalStateException("isLocked: Unexpected value: " + dir);
        };
    }
}
