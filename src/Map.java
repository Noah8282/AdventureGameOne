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
    }

    private void createRooms() {
        room1 = new Room("Room 1", "Room with no distinct features, except two doors","You wake up in a strange room. It has no distinct features, except two doors");
        room2 = new Room("Room 2", "Bright Room with two doors","As you enter this room, you are greeted by an almost blinding light that covers the whole room. This room also has two doors, the one you came through and one ahead of you.");
        room3 = new Room("Room 3", "A lit room, with two doors","This room is full of people, and has disco lights flaring everywhere. The room, just like the others, has two doors");
        room4 = new Room("Room 4", "A very dark room, with two doors","You are met with a ");
        room5 = new Room("Room 5", "A very quiet room, with two door","");
        room6 = new Room("Room 6", "A very smelly room, with two doors","");
        room7 = new Room("Room 7", "A slightly dark room, with two doors","");
        room8 = new Room("Room 8", "A room with no distinct feature, that has two doors","");
        room9 = new Room("Room 9", "A lightly lit room, with two doors","");
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

    public void RandomizeLocks() {
        for (int i = 0; i < 4 ; i++) {
            System.out.println(i);
        }


    }

}

