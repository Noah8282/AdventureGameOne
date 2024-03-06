public class Adventure {

    ////////// ATTRIBUTES //////////
    Room room1;
    Room room2;
    Room room3;
    Room room4;
    Room room5;
    Room room6;
    Room room7;
    Room room8;
    Room room9;
    Room currentRoom;


    public Adventure() {
        //Create rooms
        createRooms();
        setRoomConnections();
        currentRoom = room1;
    }


    public String look () {
        return currentRoom.getName() + ": "+ currentRoom.getDescription();
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

    private void createRooms() {
        room1 = new Room("Room 1", "Room with no distinct features, except two doors");
        room2 = new Room("Room 2", "Bright Room with two doors");
        room3 = new Room("Room 3", "A lightly lit room, with two doors");
        room4 = new Room("Room 4", "A very dark room, with two doors");
        room5 = new Room("Room 5", "A very quiet room, with two door");
        room6 = new Room("Room 6", "A very smelly room, with two doors");
        room7 = new Room("Room 7", "A slightly dark room, with two doors");
        room8 = new Room("Room 8", "A room with no distinct feature, that has two doors");
        room9 = new Room("Room 9", "A lightly lit room, with two doors");
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

}

