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
    private int health;

    //Constructor
    public Player(Room firstRoom, AudioPlayer wavPlayer) {
        health = 100;
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
        if (inventory.isEmpty()) {
            return "Your inventory is empty.";
        }
        for (Item item : inventory) {
            invString.append("- " + item.getLongName() + "\n");
        }
        return invString.toString();

    }

    public String dropItem(ArrayList<String> input) {
        String itemName = "";
        ArrayList<Item> inventoryCopy = new ArrayList<>(inventory);
        for (String inputString : input) {
            for (Item item : inventoryCopy) {
                if (item.getShortName().equalsIgnoreCase(inputString)) {
                    itemName = item.getLongName();
                    currentRoom.addItem(item);
                    inventory.remove(item);
                    break;
                }
            }
        }

        if (itemName.isBlank()) {
            return "You do not have such and item in your inventory.";
        }

        return look(itemName + " has been removed from your inventory.");

    }


    public String eatItem(Food foodItem) {
        String itemName = foodItem.getLongName();
        String msg = setHealth(foodItem.getHealthPoints()) + " ";
        inventory.remove(foodItem);
        return look(msg + itemName + " has been removed from your inventory.");

    }

    public ArrayList<Object> tryEatItem(ArrayList<String> input) {
        String itemName = "";
        ArrayList<Object> returnParameters = new ArrayList<>();
        for (String inputString : input) {
            for (Item item : inventory) {
                if (item.getShortName().equalsIgnoreCase(inputString) && item instanceof Food) {
                    itemName = item.getLongName();
                    if (((Food) item).getHealthPoints() < 0) {
                        returnParameters.add(0, itemName+" seems it might be poisonous. Are you sure you want to consume it?");
                        returnParameters.add(1, true);
                        returnParameters.add(2, item);
                    } else {
                        returnParameters.add(0, eatItem((Food) item));
                        returnParameters.add(1, false);
                    }
                    break;
                }
            }
        }

        if (itemName.isBlank()) {
            returnParameters.add(0, "You do not have such a food item in your inventory.");
            returnParameters.add(1,false);
        }
        return returnParameters;

    }

    public String getHealth() {
        String msg;
        if (health <= 100 && health >= 80) {
            msg = "You're in good health!";
        } else if (health < 80 && health >= 50) {
            msg = "You're okay, but could be doing better!";
        } else if (health < 50 && health >= 30) {
            msg = "You're a bit shabby, but you are hanging in there!";
        } else if (health < 30 && health > 10) {
            msg = "You're very low on health and should seek food and medical supplies immediately!";
        } else {
            msg = "You're almost dead! Get food now!";
        }
        return "Health: " + health + ". " + msg;


    }

    private String setHealth(int health) {
        int healthDisplay = health;
        this.health += health;
        if (this.health > 100) {
            healthDisplay = health - (this.health % 100);
            this.health = 100;
        }
        if (health > 0) {
            return "You gained " + healthDisplay + " Health points!";

        } else if (health < 0) {
            return "You lost " + Math.abs(health) + " Health points!";
        } else {
            return "This item didn't seem to give you any health";
        }

    }


}



