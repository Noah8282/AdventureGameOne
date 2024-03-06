public class Player {
    //Attribute
    private Room currentRoom;

    //Constructor
    public Player(Room firstRoom) {
        this.currentRoom = firstRoom;
    }

    public String look() {
        return currentRoom.getName() + ": " + currentRoom.getLongDesc();
    }


    public String goDirection(String dir) {
        if (dir.equals("w") && currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
        } else if (dir.equals("e") && currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
        } else if (dir.equals("n") && currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
        } else if (dir.equals("s") && currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
        } else {
            return "you cannot go that way";
        }
        return look();
    }
}



