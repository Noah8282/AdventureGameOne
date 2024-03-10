import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    //ATTRIBUTES//
    private String input;
    private Adventure adventure;
    Scanner scanner;


    //CONSTRUCTOR//
    public UserInterface() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        adventure = new Adventure();
        print(asciiStart());
        print(menu());
        print(adventure.look());

    }

    //METHOD TO START UI AND GAME//
    public void startUI() {
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
                case "toggle light","toggle","light" -> print(adventure.toggleDark());
                case "xyzzy" -> print(adventure.teleport());
                case "music" -> print(adventure.userToggleMusic());
                case "inv","inventory","i" -> print(adventure.getInv());
                default -> {
                    if(input.startsWith("pickup")) {
                        print(itemHandling(true));
                    } else if(input.startsWith("drop")) {
                        print(itemHandling(false));
                    } else if (!input.equals("exit")) {
                        print("You did not type anything correct. Type help to get instructions.");
                    }
                }
            }
        } while (!input.equals("exit"));
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

    private String itemHandling(boolean pickUp) {
        ArrayList<String> splittedPickUpInput = new ArrayList<>(List.of(input.trim().split(" ")));
        splittedPickUpInput.remove(0);
        if(pickUp) {
            return adventure.pickUpItem(splittedPickUpInput);
        } else {
            return adventure.dropItem(splittedPickUpInput);
        }

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


}
