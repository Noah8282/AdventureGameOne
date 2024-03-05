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
        room1 = new Room("Room 1","");
        room2 = new Room("Room 2","");
        room3 = new Room("Room 3","");
        room4 = new Room("Room 4","");
        room5 = new Room("Room 5","");
        room6 = new Room("Room 6","");
        room7 = new Room("Room 7","");
        room8 = new Room("Room 8","");
        room9 = new Room("Room 9","");

        currentRoom = room1;

        room1.setEast(room2);
    }



}
