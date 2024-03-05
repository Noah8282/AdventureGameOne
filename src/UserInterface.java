import java.util.Scanner;

public class UserInterface {


    Scanner scanner;
    String input;

    public UserInterface() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Game has started");
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
                case "go north","north","n" -> System.out.println("typed north");
                case "go south","south","s" -> System.out.println("typed south");
                case "go west","west","w" -> System.out.println("typed west");
                case "go east","east","e" -> System.out.println("type east");
                case "help" -> System.out.println("typed help");
                case "look" -> System.out.println("typed look");
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
