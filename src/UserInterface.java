import java.util.Scanner;

public class UserInterface {

    //ATTRIBUTES//
    private String input;
    private Adventure adventure;

    //CONSTRUCTOR//
    public UserInterface() {

        adventure = new Adventure();
        asciiStart();
        menu();
        print(adventure.look());

    }

    //METHOD TO START UI AND GAME//
    public void startUI() {
        do {
            print("What do you want to do?");
            input = getInput();
            print(input);
            switch (input) {
                case "go north", "north", "n" -> print(adventure.goDirection("n"));
                case "go south", "south", "s" -> print(adventure.goDirection("s"));
                case "go west", "west", "w" -> print(adventure.goDirection("w"));
                case "go east", "east", "e" -> print(adventure.goDirection("e"));
                case "help" -> menu();
                case "unlock" -> unlockUI();
                case "look" -> print(adventure.look());
                case "toggle light","toggle","light" -> print(adventure.toggleDark());
                case "xyzzy" -> print(adventure.teleport());
                default -> {
                    if (!input.equals("exit")) {
                        print("You did not type anything correct. Type help to get instructions.");
                    }
                }
            }
            System.out.println();
        } while (!input.equals("exit"));
    }

    //Print method. Does System.out.println. Method to avoid doing sout every print statement.
    private void print(String print) {
        System.out.println(print);
    }

    private void menu() {
        print("""
                ////////// Instructions & Commands //////////
                Help: Get a list of instructions and commands
                Look: Get name and description of the room you are in.
                Unlock: Unlock a door
                Go North/North/N: Go the the room in the northern direction
                Go South/South/s: Go the the room in the southern direction
                Go West/West/W: Go the the room in the western direction
                Go East/East/E: Go the the room in the northern direction
                Exit: Exit the game/program.
                """);
    }

    private void unlockUI() {
        print("""
                ////////// Type following to unlock //////////
                Unlock North/North/N: Go the the room in the northern direction
                Unlock South/South/s: Go the the room in the southern direction
                Unlock West/West/W: Go the the room in the western direction
                Unlock East/East/E: Go the the room in the northern direction
                """);
        input = getInput();
        switch (input) {
            case "unlock north", "go north", "north", "n" -> print(adventure.unLock("n"));
            case "unlock south", "go south", "south", "s" -> print(adventure.unLock("s"));
            case "unlock west", "go west", "west", "w" -> print(adventure.unLock("w"));
            case "unlock east", "go east", "east", "e" -> print(adventure.unLock("e"));
            default -> print("That was not a valid input. Please try again");
        }
    }

    private void asciiStart() {
        print("""                
                              _                 _                   _____                     \s
                     /\\      | |               | |                 / ____|                    \s
                    /  \\   __| |_   _____ _ __ | |_ _   _ _ __ ___| |  __  __ _ _ __ ___   ___\s
                   / /\\ \\ / _` \\ \\ / / _ \\ '_ \\| __| | | | '__/ _ \\ | |_ |/ _` | '_ ` _ \\ / _ \\
                  / ____ \\ (_| |\\ V /  __/ | | | |_| |_| | | |  __/ |__| | (_| | | | | | |  __/
                 /_/    \\_\\__,_| \\_/ \\___|_| |_|\\__|\\__,_|_|  \\___|\\_____|\\__,_|_| |_| |_|\\___|
                                                                                              \s
                                                                                              \s
                """);
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String input = scanner.next().toLowerCase().trim();
        scanner.close();
        return input;
    }


}
