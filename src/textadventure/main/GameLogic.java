package textadventure.main;

import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static Player player;

    // method to get user input from console
    public static int readInt(String prompt, int userChoices) {
        int input;

        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception ex) {
                input = -1;
                System.out.println("Please enter an number!");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    // method to clear out the console
    public static void clearConsole(){
        for(int i = 0; i < 100; i++){
            System.out.println();
        }

    }
    // method to print a seperator with lenght n
    public static void printSeperator(int n){
        for(int i = 0; i < n; i++){
            System.out.print("-");
        }
        System.out.println();
    }
    // method to print heading
    public static void printHeading(String title){
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);
    }

    //method to stop the game until user enters anything
    public static void anythingToContinue(){
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }

    //method to start the game
    public static void startGame(){
        boolean nameSet = false;
        String name;
        //print title screen
        clearConsole();

        System.out.println("AGE OF THE EVIL EMPEROR");
        System.out.println("TEXT RPG BY /mahgoe");

        anythingToContinue();

        //getting the player name
        do {
            clearConsole();
            printHeading("Whats your name?");
            name = scanner.next();
            //asking the player if he wants to correct his choice
            clearConsole();
            printHeading("Your name is " + name + ".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change my name.");
            int input = readInt("->", 2);
                    if(input == 1)
                        nameSet = true;
        }while(!nameSet);

        //create new player object with the name
        player = new Player(name);
    }
}

