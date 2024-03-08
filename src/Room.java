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
    }

    public void setEast(Room east) {
        if (this.east != east) {
            this.east = east;
            east.setWest(this);
        }

    }

    public void setWest(Room west) {
        if (this.west != west) {
            this.west = west;
            west.setEast(this);
        }
    }

    public void setNorth(Room north) {
        if (this.north != north) {
            this.north = north;
            north.setSouth(this);
        }
    }

    public void setSouth(Room south) {
        if (this.south != south) {
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

    public void addInitialItems() {
        // Tilføj de ønskede genstande til dette rum ved oprettelse
        Item lamp = new Item("A shiny brass lamp", "lamp");
        Item key = new Item("A small rusty key", "key");
        Item hammer = new Item("A big hammer", "hammer");
        Item shovel = new Item("A shovel", "shovel");
        Item sword = new Item("A shiny sword", "sword");

        // Tilføj genstande til rummets liste over genstande
        items.add(lamp);
        items.add(key);
        items.add(hammer);
        items.add(shovel);
        items.add(sword);

// Det der står herned er bare en anden måde vi måske kan lave Arraylist(Bare en anbefaling)
        /*
        String[] Item = new String[3];
        Item[0] = "lamp";
        Item[1] = "key";
        Item[2] = "hammer";


        System.out.println(Item[1]);
        ArrayList ItemList = new ArrayList();
        ItemList.add("lamp");
        ItemList.add("key");
        ItemList.add("hammer");
        System.out.println(ItemList);
        */


    }
}
