import java.util.Scanner;

public class UserInterface {


    Scanner scanner;
    String input;
    Adventure adventure;

    public UserInterface() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Game has started");
        adventure = new Adventure();
        startUI();

    }

    /*
    West = 1
    North = 2
     */

    public void startUI() {
        do {
            input = scanner.next().toLowerCase();
            switch (input) {
                case "go north","north","n" -> System.out.println(adventure.goDirection("n"));
                case "go south","south","s" -> System.out.println(adventure.goDirection("s"));
                case "go west","west","w" -> System.out.println(adventure.goDirection("w"));
                case "go east","east","e" -> System.out.println(adventure.goDirection("e"));
                case "help" -> System.out.println(
                        "////////// Instructions & Commands //////////\n" +
                        "Help: Get a list of instructions and commands\n" +
                        "Look: Get name and description of the room you are in.\n" +
                        "Go North/North/N: Go the the room in the northern direction\n" +
                        "Go South/South/s: Go the the room in the southern direction\n" +
                        "Go West/West/W: Go the the room in the western direction\n" +
                        "Go East/East/E: Go the the room in the northern direction\n" +
                        "Exit: Exit the game/program.");
                case "look" -> System.out.println(adventure.look());
                default -> {
                    if(!input.equals("exit")) {
                        System.out.println("You did not type anything correct. Type help to get instructions.");
                    }
                }
            }


            System.out.println();
        } while (!input.equals("exit"));
    }


}
