import java.util.ArrayList;
import java.util.Random;

public class Map {

    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;
    private Room[] roomList;
    private ArrayList<Item> items;

    private Random rn;
    public Map() {
        rn = new Random();
        items = new ArrayList<>();
        createRooms();
        setRoomConnections();
        randomizeLocks();
        randomizeDark();
        createItems();
        assignItemsRandomized();
    }

    private void createRooms() {
        room1 = new Room("Room 1", "Room with no distinct features, except two doors", "You wake up in a strange room. It has no distinct features, except two doors");
        room2 = new Room("Room 2", "Bright Room with two doors", "As you enter this room, you are greeted by an almost blinding light that covers the whole room. This room also has two doors, the one you came through and one ahead of you.");
        room3 = new Room("Room 3", "A lit room, with two doors", "This room is full of people, and has disco lights flaring everywhere. The room, just like the others, has two doors");
        room4 = new Room("Room 4", "A very dark room, with two doors", "You are met with a deep darkness as you enter the room. The darkness embraces you and it is almost suffocating. You are just able to make out that there are two doors in this room.");
        room5 = new Room("Room 5", "A very quiet room, with two door", "You enter an empty room with no sounds. As you close the door behind, no sound is made when it closes. There is only one door in this room and that is the room that you came from.");
        room6 = new Room("Room 6", "A very smelly room, with two doors", "When you enter the room, one whiff of the place is enough to make you through up. When you quickly eventually hold your breath, you gain clarity and notice the door doors that a present in the room.");
        room7 = new Room("Room 7", "A slightly dark room, with two doors", "The room is dark when you enter it. While it is not pitch black, the darkness in this room has an uncanny feeling to it. The room also has two doors.");
        room8 = new Room("Room 8", "A room with no distinct feature, that has two doors", "When you enter this room, a feeling deju vu overcomes you. This room has no distinct features, just like the first room you woke up in. This room, unlike most others, has three doors");
        room9 = new Room("Room 9", "A lightly lit room, with two doors", "As you enter the room, you are met with a dark room that a small light that lightly illuminates the room. This room also has two doors");

        roomList = new Room[]{room1, room2, room3, room4, room5, room6, room7, room8, room9};


    }

    private void setRoomConnections() {
        room1.setNextRoom("e", room2);
        room2.setNextRoom("e", room3);
        room3.setNextRoom("s", room6);
        room6.setNextRoom("s", room9);
        room9.setNextRoom("w", room8);
        room5.setNextRoom("s", room8);
        room8.setNextRoom("w", room7);
        room7.setNextRoom("n", room4);
        room4.setNextRoom("n", room1);
    }


    public Room[] getRoomList() {
        return roomList;
    }
    public Room getFirstRoom() {
        return room1;
    }

    private void randomizeLocks() {
        //25% chance of a locked door
        final int MAX = 4;
        for (Room room : roomList) {
            if (rn.nextInt(MAX) == 0 && room.getNextRoom("w") != null) {
                room.lockRoom("w");
            }
            if (rn.nextInt(MAX) == 0 && room.getNextRoom("e") != null) {
                room.lockRoom("e");
            }
            if (rn.nextInt(MAX) == 0 && room.getNextRoom("s") != null) {
                room.lockRoom("s");
            }
            if (rn.nextInt(MAX) == 0 && room.getNextRoom("n") != null) {
                room.lockRoom("n");
            }
        }
    }
    private void randomizeDark() {
        for (Room room : roomList) {
            final int MAX = 3;
            if(rn.nextInt(MAX) == 0) {
                room.toggleDark();
            }
        }
    }

    private void createItems() {
        items.add(new Item("A shiny brass lamp"));
        items.add(new Item("A heavy sword"));
        items.add(new Item("A rusty axe"));
        items.add(new Item("A hunters bow"));
        items.add(new Item("A damaged helmet"));
        items.add(new Item("A worn chestplate"));
        items.add(new Item("A pierced set of leggings"));
        items.add(new Item("A shiny pair of boots"));
        items.add(new Item("A worn chestplate"));
        items.add(new Item("A decaying bone"));
        items.add(new Item("A bone potato"));
    }

    public void assignItemsRandomized() {
        for (int i = 0; i < roomList.length; i++) {
            for (Item item : items) {
                if(rn.nextInt(5) == 0) {
                    roomList[i].addItem(item);
                }
            }
        }


    }



}