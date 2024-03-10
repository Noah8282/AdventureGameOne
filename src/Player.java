import java.util.*;

public class Player {
    //Attribute
    private Room currentRoom;
    private Set<Room> lockChecked;
    private Set<Room> visited;
    private String lastDir;
    private Room lastTeleport;
    private AudioPlayer wavPlayer;
    private ArrayList<Item> inventory;

    //Constructor
    public Player(Room firstRoom, AudioPlayer wavPlayer) {
        this.wavPlayer = wavPlayer;
        lockChecked = new HashSet<>();
        visited = new HashSet<>();
        inventory = new ArrayList<>();
        currentRoom = firstRoom;
        lastTeleport = firstRoom;
        lastDir = "";
        wavPlayer.startAudio(currentRoom);
    }

    public String look(String returnMessage) {
        String desc;
        visited.add(currentRoom);
        if (currentRoom.isDark()) {
            return "The room is too dark to see anything. You can only go back the way you came.";
        }

        if (!visited.contains(currentRoom)) {
            desc = currentRoom.getLongDesc();
        } else {
            desc = currentRoom.getShortDesc();
        }


        StringBuilder roomDescription = new StringBuilder(currentRoom.getName() + ": " + desc);
        ArrayList<Item> roomItems = currentRoom.getItems();
        if (roomItems.isEmpty()) {
            roomDescription.append("\nThere are no items in this room.");
        } else {
            roomDescription.append("\nItems in the room:");
            for (Item item : roomItems) {
                roomDescription.append("\n- ").append(item.getLongName());
            }
        }

        return returnMessage + "\n" + roomDescription.toString();
    }

    public String look() {
        return look("");
    }


    public String goDirection(String dir) {
        if (currentRoom.isDark() && (!lastDir.equals(revertDir(dir)) || lastDir.isBlank())) {
            return look();
        }


        Room wantedDir = currentRoom.getNextRoom(dir);

        if (wantedDir == null) {
            return "you cannot go that way";
        }

        if (currentRoom.isLocked(dir)) {
            lockChecked.add(wantedDir);
            return "The door is locked! You can continue to explore, or type unlock to unlock the door!";
        }

        lockChecked.clear();
        currentRoom = wantedDir;
        lastDir = dir;
        currentRoom.unlockRoom(revertDir(lastDir));
        wavPlayer.toggleAudio();
        wavPlayer.startAudio(currentRoom);

        return look();
    }

    public String unLock(String dir) {
        Room wantedUnlock = currentRoom.getNextRoom(dir);

        if (!lockChecked.contains(wantedUnlock)) {
            return "There is no knowlegde of a door being locked here.";
        }

        currentRoom.unlockRoom(dir);

        return "The door has been unlocked!";

    }

    public String toggleDark() {
        currentRoom.toggleDark();
        return look();
    }

    public String teleport() {
        Room tempRoom = currentRoom;
        currentRoom = lastTeleport;
        lastTeleport = tempRoom;
        return "xyzzy!\n" + look();
    }


    private String revertDir(String dir) {
        return switch (dir) {
            case "w" -> "e";
            case "e" -> "w";
            case "s" -> "n";
            case "n" -> "s";
            default -> throw new IllegalStateException("switchDir: Unexpected value: " + dir);
        };
    }

    public String pickUpItem(ArrayList<String> input) {
        int beforePickUpInvSize = inventory.size();
        ArrayList<Item> itemsInCurrentRoom = new ArrayList<>(currentRoom.getItems());

        for (Item item : itemsInCurrentRoom) {
            for (String inputString : input) {
                if (inputString.equalsIgnoreCase(item.getShortName())) {
                    inventory.add(item);
                    currentRoom.removeItem(item);
                }
            }
        }
        if (beforePickUpInvSize == inventory.size()) {
            return look("The item you wished to pickup could not be found. Please try again");
        }
        return look("Item was successfully added to your inventory!");
    }

    public String getInv() {
        StringBuilder invString = new StringBuilder();
        if(inventory.isEmpty()) {
            return "Your inventory is empty.";
        }
        for (Item item : inventory) {
            invString.append("- "+item.getLongName()+"\n");
        }

        return invString.toString();

    }

    public String dropItem(ArrayList<String> input) {
        String itemName = "";
        ArrayList<Item> inventoryCopy = new ArrayList<>(inventory);
        for (String inputString : input) {
            for (Item item : inventoryCopy) {
                if(item.getShortName().equalsIgnoreCase(inputString)) {
                    itemName = item.getLongName();
                    inventory.remove(item);
                    currentRoom.addItem(item);
                    break;
                }
            }
        }

        if(itemName.isBlank()) {
            return "You do not have such and item in your inventory.";
        }

        return look(itemName+" has been removed from your inventory.");

    }

}







