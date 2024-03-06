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

    public Map() {
        createRooms();
        setRoomConnections();
        randomizeLocks();
    }

    private void createRooms() {
        room1 = new Room("Room 1", "Room with no distinct features, except two doors","You wake up in a strange room. It has no distinct features, except two doors");
        room2 = new Room("Room 2", "Bright Room with two doors","As you enter this room, you are greeted by an almost blinding light that covers the whole room. This room also has two doors, the one you came through and one ahead of you.");
        room3 = new Room("Room 3", "A lit room, with two doors","This room is full of people, and has disco lights flaring everywhere. The room, just like the others, has two doors");
        room4 = new Room("Room 4", "A very dark room, with two doors","You are met with a deep darkness as you enter the room. The darkness embraces you and it is almost suffocating. You are just able to make out that there are two doors in this room.");
        room5 = new Room("Room 5", "A very quiet room, with two door","You enter an empty room with no sounds. As you close the door behind, no sound is made when it closes. There is only one door in this room and that is the room that you came from.");
        room6 = new Room("Room 6", "A very smelly room, with two doors","When you enter the room, one whiff of the place is enough to make you through up. When you quickly eventually hold your breath, you gain clarity and notice the door doors that a present in the room.");
        room7 = new Room("Room 7", "A slightly dark room, with two doors","The room is dark when you enter it. While it is not pitch black, the darkness in this room has an uncanny feeling to it. The room also has two doors.");
        room8 = new Room("Room 8", "A room with no distinct feature, that has two doors","When you enter this room, a feeling deju vu overcomes you. This room has no distinct features, just like the first room you woke up in. This room, unlike most others, has three doors");
        room9 = new Room("Room 9", "A lightly lit room, with two doors","As you enter the room, you are met with a dark room that a small light that lightly illuminates the room. This room also has two doors");
    }

    private void setRoomConnections() {
        room1.setEast(room2);
        room1.setSouth(room4);
        room2.setEast(room3);
        room3.setSouth(room6);
        room6.setSouth(room9);
        room9.setWest(room8);
        room8.setNorth(room5);
        room8.setWest(room7);
        room7.setNorth(room4);

    }

    public Room getFirstRoom() {
        return room1;
    }

    public void randomizeLocks() {
        Random rn = new Random();
        Room[] roomList = {room1, room2, room3, room4, room5, room6, room7, room8, room9};
        for (Room room : roomList) {
            if(rn.nextInt(4) == 1 && room.getWest() != null) {
                room.lockWest();
            }
            if(rn.nextInt(4) == 1 && room.getEast() != null) {
                room.lockEast();
            }
            if(rn.nextInt(4) == 1 && room.getSouth() != null) {
                room.lockSouth();
            }
            if(rn.nextInt(4) == 1 && room.getNorth() != null) {
                room.lockNorth();
            }
        }


    }

}

