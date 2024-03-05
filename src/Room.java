public class Room {

    ////////// ATTRIBUTES //////////
    //Name of the room
    private String name;
    //Description of room and rooms contents.
    private String description;

    //The 4 neighbouring rooms. If null then there is no room to that orientation.
    private Room east;
    private Room west;
    private Room north;
    private Room south;


    ////////// CONSTRUCTOR //////////
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        east = null;
        west = null;
        north = null;
        south = null;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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
}
