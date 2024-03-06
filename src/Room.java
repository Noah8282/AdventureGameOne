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
            west.setSouth(this);
        }
    }

    public void setSouth(Room south) {
        if(this.south != south) {
            this.south = south;
            west.setNorth(this);
        }
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
