import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Player {
    //Attribute
    private Room currentRoom;
    private Set<Room> lockChecked;

    //Constructor
    public Player(Room firstRoom) {
        lockChecked = new HashSet<>();
        this.currentRoom = firstRoom;
    }
    public String look() {
        StringBuilder roomDescription = new StringBuilder(currentRoom.getName() + ": " + currentRoom.getLongDesc());
        ArrayList<Item> roomItems = currentRoom.getItems();

        if (roomItems.isEmpty()) {
            roomDescription.append("\nThere are no items in this room.");
        } else {
            roomDescription.append("\nItems in the room:");
            for (Item item : roomItems) {
                roomDescription.append("\n- ").append(item.getLongName());
            }
        }

        return roomDescription.toString();
    }


    public String goDirection(String dir) {
        Room wantedDir = null;
        boolean lockStatus = false;
        switch (dir) {
            case "w" -> {wantedDir = currentRoom.getWest(); lockStatus = currentRoom.isLockedWest();}
            case "e" -> {wantedDir = currentRoom.getEast(); lockStatus = currentRoom.isLockedEast();}
            case "n" -> {wantedDir = currentRoom.getNorth(); lockStatus = currentRoom.isLockedNorth();}
            case "s" -> {wantedDir = currentRoom.getSouth(); lockStatus = currentRoom.isLockedSouth();}
        }

        if(wantedDir == null) {
            return "you cannot go that way";
        }

        if(lockStatus) {
            lockChecked.add(wantedDir);
            return "The door is locked! You can continue to explore, or type unlock to unlock the door!";
        }

        lockChecked.clear();
        currentRoom = wantedDir;

        return look();
    }

    public String unLock(String dir) {
        Room wantedUnlock = null;

        switch (dir) {
            case "w" -> wantedUnlock = currentRoom.getWest();
            case "e" -> wantedUnlock = currentRoom.getEast();
            case "n" -> wantedUnlock = currentRoom.getNorth();
            case "s" -> wantedUnlock = currentRoom.getSouth();
        }

        if(!lockChecked.contains(wantedUnlock)) {
            return "There is no knowlegde of a door being locked here.";
        }

        switch (dir) {
            case "w" -> currentRoom.unlockWest();
            case "e" -> currentRoom.unlockEast();
            case "n" -> currentRoom.unlockNorth();
            case "s" -> currentRoom.unlockSouth();
        }

        return "The door has been unlocked!";

        public class Player {
            private Room currentRoom;
            private ArrayList<Item> inventory;

            public Player(Room startingRoom) {
                currentRoom = startingRoom;
                inventory = new ArrayList<>();
            }

            public void setCurrentRoom(Room room) {
                currentRoom = room;
            }

            public Room getCurrentRoom() {
                return currentRoom;
            }

            public void takeItem(Item item) {
                currentRoom.removeItem(item);
                inventory.add(item);
            }

            public void dropItem(Item item) {
                inventory.remove(item);
                currentRoom.addItem(item);
            }

            public ArrayList<Item> getInventory() {
                return inventory;
            }
        }

    }



}



