import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface extends Adventure {

    //ATTRIBUTES//
    private String input;
    private final Adventure adventure;
    private final Scanner scanner;
    private static boolean gameRunning;
    private final boolean musicEnabled = true;


    //CONSTRUCTOR//
    public UserInterface() throws CloneNotSupportedException {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        adventure = new Adventure();
        gameRunning = true;
        print(asciiStart());
        print(menu());
        print(adventure.look());
    }

    //METHOD TO START UI AND GAME//
    public void startUI() {
        if(musicEnabled) {
            adventure.userToggleMusic();
        }
        do {
            print("What do you want to do?");
            input = getInput();
            switch (input) {
                case "go north", "north", "n" -> print(adventure.goDirection("n"));
                case "go south", "south", "s" -> print(adventure.goDirection("s"));
                case "go west", "west", "w" -> print(adventure.goDirection("w"));
                case "go east", "east", "e" -> print(adventure.goDirection("e"));
                case "help" -> print(menu());
                case "unlock e", "unlock w", "unlock n", "unlock s" -> print(unlockHandling());
                case "look" -> print(adventure.look());
                case "toggle light", "toggle", "light" -> print(adventure.toggleDark());
                case "xyzzy" -> print(adventure.teleport());
                case "music" -> print(adventure.userToggleMusic());
                case "inv", "inventory", "i" -> print(adventure.getInv());
                case "health", "get health" -> print(adventure.getHealth());
                case "exit" -> { print("The game has ended"); gameRunning = false; }
                default -> {
                    if (input.startsWith("pickup") || input.startsWith("drop") || input.startsWith("eat") || input.startsWith("equip") || input.startsWith("attack")) {
                        print(itemHandling());
                    } else {
                        print("You did not type anything correct. Type help to get instructions.");
                    }
                }
            }
        } while (gameRunning);
    }

    //Print method. Does System.out.println. Method to avoid doing sout every print statement.
    private void print(String print) {
        System.out.println(print);
    }

    private String menu() {
        return """
                ////////// Instructions & Commands //////////
                Go North/North/N: Go the the room in the northern direction
                Go South/South/s: Go the the room in the southern direction
                Go West/West/W: Go the the room in the western direction
                Go East/East/E: Go the the room in the northern direction
                Help: Get a list of instructions and commands
                Attack: (name of enemy): Attack an enemy. Type just "Attack" to attack closest enemy.
                Eat (name of food item): Eat a food item and gain health... probably.
                Equip (Name of weapon): Equip a weapon from your inventory.
                Look: Get name and description of the room you are in.
                Unlock w/e/n/s: Unlock a door
                Toggle: Switch the light on/off (toggle the light)
                Inv: See your inventory
                Pickup (name of item): Pickup an item.
                Drop (name of item): Drop an item.
                Music: Toogle music on and off.
                Exit: Exit the game/program.
                """;
    }

    private String unlockHandling() {
        String[] splittedUnlockInput = input.trim().split(" ");
        return adventure.unLock(splittedUnlockInput[1]);
    }

    private String itemHandling() {
        ArrayList<String> splittedPickUpInput = new ArrayList<>(List.of(input.trim().split(" ")));
        String startsWith = splittedPickUpInput.get(0);
        splittedPickUpInput.remove(0);
        if (startsWith.equals("pickup")) {
            return adventure.pickUpItem(splittedPickUpInput);
        } else if (startsWith.equals("drop")) {
            return adventure.dropItem(splittedPickUpInput);
        } else if (startsWith.equals("equip")) {
            return adventure.equipWeapon(splittedPickUpInput);
        } else if(startsWith.equals("attack")) {
            return adventure.attack(splittedPickUpInput);
        } else if (startsWith.equals("eat")) {
            ArrayList<Object> eatReturnParameters = adventure.tryEatItem(splittedPickUpInput);
            if ((boolean) eatReturnParameters.get(1)) {
                String msg = "";
                while (msg.isBlank()) {
                    print((String) eatReturnParameters.get(0));
                    input = getInput();
                    msg = switch (input) {
                        case "yes" -> adventure.eatItem((Food) eatReturnParameters.get(2));
                        case "no" -> "You did not eat the food item";
                        default -> "";
                    };
                    if (msg.isBlank()) {
                        print("I did not understand that input. Please try again");
                    }
                }
                return msg;

            }
            return (String) eatReturnParameters.get(0);


        }
        return "How did we get here?";

    }

    private String asciiStart() {
        return """                
                              _                 _                   _____                     \s
                     /\\      | |               | |                 / ____|                    \s
                    /  \\   __| |_   _____ _ __ | |_ _   _ _ __ ___| |  __  __ _ _ __ ___   ___\s
                   / /\\ \\ / _` \\ \\ / / _ \\ '_ \\| __| | | | '__/ _ \\ | |_ |/ _` | '_ ` _ \\ / _ \\
                  / ____ \\ (_| |\\ V /  __/ | | | |_| |_| | | |  __/ |__| | (_| | | | | | |  __/
                 /_/    \\_\\__,_| \\_/ \\___|_| |_|\\__|\\__,_|_|  \\___|\\_____|\\__,_|_| |_| |_|\\___|
                                                                                              \s
                                                                                              \s
                """;
    }

    private String getInput() {
        return scanner.next().toLowerCase().trim();
    }

    public static void endGame() {
        gameRunning = false;
    }


}
