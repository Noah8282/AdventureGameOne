import java.util.*;

public class Player {
    //Attribute
    private Room currentRoom;
    private Set<Room> lockChecked;
    private Set<Room> visited;
    private String lastDir;
    private Room lastTeleport;
    private AudioPlayer wavPlayer;

    //Constructor
    public Player(Room firstRoom, AudioPlayer wavPlayer) {
        this.wavPlayer = wavPlayer;
        lockChecked = new HashSet<>();
        visited = new HashSet<>();
        currentRoom = firstRoom;
        lastTeleport = firstRoom;
        lastDir = "";
        wavPlayer.startAudio(currentRoom);
    }

    public String look() {
        String desc;
        visited.add(currentRoom);
        if(currentRoom.isDark()) {
            return "The room is too dark to see anything. You can only go back the way you came.";
        }

        if(!visited.contains(currentRoom)) {
            desc = currentRoom.getLongDesc();
        } else {
            desc = currentRoom.getShortDesc();
        }


        StringBuilder roomDescription = new StringBuilder(currentRoom.getName() + ": " + desc);
        ArrayList<Item> roomItems = new ArrayList<>(List.of(new Item("hey", "hey")));
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
        if(currentRoom.isDark() && (!lastDir.equals(revertDir(dir)) || lastDir.isBlank())) {
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
        wavPlayer.stopAudio();
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
        return "xyzzy!\n"+look();
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

}







