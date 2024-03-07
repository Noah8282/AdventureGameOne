import java.util.ArrayList;
public class Room {
     private String description;
        private ArrayList<Item> items;

        public Room(String description) {
            this.description = description;
            items = new ArrayList<>();
        }

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


    ////////// CONSTRUCTOR //////////
    public Room(String name, String shortDesc, String longDesc) {
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
    }

    public void setEast(Room east) {
        if(this.east != east) {
            this.east = east;
            east.setWest(this);
        }

    }

    public void setWest(Room west) {
        if(this.west != west) {
            this.west = west;
            west.setEast(this);
        }
    }

    public void setNorth(Room north) {
        if(this.north != north) {
            this.north = north;
            north.setSouth(this);
        }
    }

    public void setSouth(Room south) {
        if(this.south != south) {
            this.south = south;
            south.setNorth(this);
        }
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

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public void lockEast() {
        lockedEast = true;
    }

    public void lockWest() {
        lockedWest = true;
    }

    public void lockNorth() {
        lockedNorth = true;
    }

    public void lockSouth() {
        lockedSouth = true;
    }

    public void unlockEast() {
        lockedEast = false;
    }

    public void unlockWest() {
        lockedWest = false;
    }

    public void unlockNorth() {
        lockedNorth = false;
    }

    public void unlockSouth() {
        lockedSouth = false;
    }



    public boolean isLockedEast() {
        return lockedEast;
    }

    public boolean isLockedWest() {
        return lockedWest;
    }

    public boolean isLockedNorth() {
        return lockedNorth;
    }

    public boolean isLockedSouth() {
        return lockedSouth;
    }


    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getDescription() {
        return description;
    }

}
