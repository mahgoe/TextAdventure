package textadventure.main;

import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static Player player;
    public static boolean isRunning;

    //Story elements
    public static int place = 0, act;
    public static String[] places = {"Wandering Plains", " Eldoria Town Square", "The Hidden Sanctuary, Forbidden Woods", "Outskirts of the Caverns of Desolation", " Shadow Valley", "Oracle's Temple atop Luminara Peak"};

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

        //print story intro
        Story.printIntro();

        //create new player object with the name
        player = new Player(name);

        //print act 1 story intro
        Story.printFirstIntro();

        //setting isRunning true
        isRunning = true;

        //start main game loop
        gameLoop();
    }

    //method to continue the journey
    public static void continueJourney(){

    }

    //printing out the most important information about the player character
    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeperator(20);
        System.out.println("XP: " + player.xp);
        printSeperator(20);

        //printing the chosen traits
        if(player.numAtkUpgrades > 0){
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeperator(20);
        }
        if(player.numDefUpgrades > 0){
            System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
        }
        anythingToContinue();
    }


    //printing the main menu
    public static void printMenu(){
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action:");
        printSeperator(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
    }

    //main game loop
    public static void gameLoop() {
        while (isRunning){
            printMenu();
            int input = readInt("->", 3);
            if (input == 1){
                continueJourney();
            }else if(input == 2){
                characterInfo();
            }else{
                isRunning = false;
            }
        }
    }
}

