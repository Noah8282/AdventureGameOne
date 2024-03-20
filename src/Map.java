import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
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
    private ArrayList<Enemy> enemies;
    private Enemy boss;
    private Random rn;

    public Map() throws CloneNotSupportedException {
        rn = new Random();
        items = new ArrayList<>();
        enemies = new ArrayList<>();
        createRooms();
        setRoomConnections();
        randomizeLocks();
        randomizeDark();
        createItems();
        createEnemies();
        assignItemsRandomized();
        assignEnemyRandomized();
    }

    private void createRooms() {
        room1 = new Room(1, "Room with no distinct features, except two doors", "You wake up in a strange room. It has no distinct features, except two doors",1);
        room2 = new Room(2, "Bright Room with two doors", "As you enter this room, you are greeted by an almost blinding light that covers the whole room. This room also has two doors, the one you came through and one ahead of you.",2);
        room3 = new Room(3, "A lit room, with two doors", "This room is full of people, and has disco lights flaring everywhere. The room, just like the others, has two doors",2);
        room4 = new Room(5, "A very dark room, with two doors", "You are met with a deep darkness as you enter the room. The darkness embraces you and it is almost suffocating. You are just able to make out that there are two doors in this room.",2);
        room5 = new Room(5, "A very quiet room, with two door", "You enter an empty room with no sounds. As you close the door behind, no sound is made when it closes. There is only one door in this room and that is the room that you came from.",5);
        room6 = new Room(6, "A very smelly room, with two doors", "When you enter the room, one whiff of the place is enough to make you through up. When you quickly eventually hold your breath, you gain clarity and notice the door doors that a present in the room.",3);
        room7 = new Room(7, "A slightly dark room, with two doors", "The room is dark when you enter it. While it is not pitch black, the darkness in this room has an uncanny feeling to it. The room also has two doors.",2);
        room8 = new Room(8, "A room with no distinct feature, that has two doors", "When you enter this room, a feeling deju vu overcomes you. This room has no distinct features, just like the first room you woke up in. This room, unlike most others, has three doors",4);
        room9 = new Room(9, "A lightly lit room, with two doors", "As you enter the room, you are met with a dark room that a small light that lightly illuminates the room. This room also has two doors",3);

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
            if (rn.nextInt(MAX) == 0) {
                room.toggleDark();
            }
        }
    }

    private void createItems() {

        items.add(new Item("A shiny brass lamp"));
        items.add(new Item("A damaged helmet"));
        items.add(new Item("A worn chestplate"));
        items.add(new Item("A pierced set of leggings"));
        items.add(new Item("A shiny pair of boots"));
        items.add(new Item("A decaying bone"));
        items.add(new Food("A baked potato"));
        items.add(new Food("A raw steak"));
        items.add(new Food("A dry piece of pork"));
        items.add(new Food("A half eaten apple"));
        items.add(new Food("A half can of beans"));
        items.add(new Food("a shiny apple"));
        items.add(new Food("a ripe banana"));
        items.add(new Food("a loaf of bread"));

        items.add(new MeleeWeapon("A rusty axe"));
        items.add(new MeleeWeapon("A heavy sword"));
        items.add(new MeleeWeapon("A rusty iron shovel"));

        items.add(new RangedWeapon("A hunters bow", "", "arrows"));
        items.add(new RangedWeapon("A old AK-47"));
        items.add(new RangedWeapon("A factory new Glock-17"));
    }

    private void createEnemies() throws CloneNotSupportedException {
        enemies.add(new Enemy(100,"Ogre"));
        enemies.add(new Enemy(100,"Goblin"));
        enemies.add(new Enemy(100,"Bandit"));
        enemies.add(new Enemy(100,"Moleman"));
        enemies.add(new Enemy(100,"Joker"));
        enemies.add(new Enemy(100,"Zombie"));
        enemies.add(new Enemy(100,"Skeleton"));
        boss = new Enemy(200,"BOSS - Bigfoot");




    }

    private void assignItemsRandomized() throws CloneNotSupportedException {
        for (Room room : roomList) {
            int count = 0;
            while (count < 5) {
                if (room.getId() == 1 && count == 0) {
                    Weapon firstWeapon = new MeleeWeapon("A rusty iron shovel");
                    firstWeapon.setDamage(10);
                    firstWeapon.setRandomUses();
                    room.addItem(firstWeapon);
                } else {
                    if(rn.nextInt(0,3) != 0) {
                        Item pickedItem = items.get(rn.nextInt(0,items.size()));
                        if(pickedItem instanceof Weapon) {
                            Weapon clonedWeapon = (Weapon)pickedItem.clone();
                            clonedWeapon.setRandomUses();
                            clonedWeapon.setRandomDamage(room.getDifficulty());
                            room.addItem(clonedWeapon);
                        } else {
                            Item clonedItem = (Item)pickedItem.clone();
                            room.addItem(clonedItem);
                        }
                    }
                }
                count++;
            }

        }


    }

    private void assignEnemyRandomized() throws CloneNotSupportedException {
        Enemy picked;
        for (int i = 1; i < roomList.length; i++) {
            int id = roomList[i].getId();
            if(id == 2 || id == 4) {
                picked = getRandomEnemyClone();
                picked.setDifficulty(1);
                roomList[i].addEnemy(picked);
            } else if(id == 3 || id == 7) {
                for (int j = 1; j <= 2; j++) {
                    picked = getRandomEnemyClone();
                    picked.setDifficulty(2);
                    roomList[i].addEnemy(picked);
                }
            } else if(id == 6 || id == 9) {
                for (int j = 1; j <= 3; j++) {
                    picked = getRandomEnemyClone();
                    picked.setDifficulty(3);
                    roomList[i].addEnemy(picked);
                }
            } else if(id == 8) {
                for (int j = 1; j <= 4; j++) {
                    picked = getRandomEnemyClone();
                    picked.setDifficulty(4);
                    roomList[i].addEnemy(picked);
                }

            } else {
                //BOSS ROOM
                boss.setDifficulty(8);
                roomList[i].addEnemy(boss);
            }

        }


    }

    private Enemy getRandomEnemyClone() throws CloneNotSupportedException {
        return (Enemy)enemies.get(rn.nextInt(0,enemies.size())).clone();

    }


    //Look metoden skal fortælle hvilke enemies der er.
    //Attack metoden skal virke, kunne angribe nærmeste enemy eller angribe enemy of choice.
    //Attack hos enemy skal angribe spilleren tilbage, når spilleren selv angriber.
    //Når enemy dør, skal den drop dens våben.
    //Når Playeren dør, skal spillet stoppe. Evt. sige at spilleren døde.
    //Difficulty skal integreres ind i Enemy objektet, og ændre på health og/eller weapon Damage.
    //Evt. gøre så spilleren ikke kan gå videre i rum, når alle enemies ikke er døde.



}