package textadventure.main;

import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static Player player;
    public static boolean isRunning;

    //random encounters
    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest", "Rest"};

    //enemy names
    public static String[] enemies = {"Orge", "Orge", "Dark Mage", "Goblin", "Goblin Knight" };

    //Story elements
    public static int place = 0, act = 1;
    public static String[] places = {"Wandering Plains", "Eldoria Town Square", "The Hidden Sanctuary, Draken's Frontier Fortress"};

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

    //method that changes the games values based on player xp
    public static void checkAct(){
        if(player.xp >= 0 && act == 1){
            //increment act and place
            act = 2;
            place = 1;
            //Story
            Story.printFirstOutro();
            //level the player up
            player.chooseTrait();
            //Story
            Story.printSecondIntro();
        }else if(player.xp >= 10 && act == 2){
            act = 3;
            place = 2;
            Story.printSecondOutro();
            player.chooseTrait();
            Story.printThirdIntro();
            //assign new values to enemies
            enemies[0] = "Evil Mercenary";
            enemies[1] = "Goblin";
            enemies[2] = "Wolve Pack";
            enemies[3] = "Goblin Knight";
            enemies[4] = "Scary Stranger";
            //assign new values to encounters;
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";
            //fully health the player
            player.hp = player.maxHp;
        }else if(player.xp >= 20 && act == 3){
            act = 4;
            place = 3;
            Story.printThirdOutro();
            player.chooseTrait();
            Story.printFourthIntro();
            //fully health the player
            player.hp = player.maxHp;
            //calling the final battle
            finalBattle();
        }
    }

    //method to calculate a random encounter
    public static void randomEncounter(){
        //random number between 0 and lenght of encounters array
        int encounter = (int)(Math.random()* encounters.length);
        //calling the respective methods
        if(encounters[encounter].equals("Battle")){
            randomBattle();
        }else if(encounters[encounter].equals("Rest")){
            takeRest();
        }else if(encounters[encounter].equals("Shop")){
            shop();
        }
        else{
            continueJourney();
        }
    }

    //creating a random battle
    public static void randomBattle(){
        clearConsole();
        printHeading("You encountered an evil minded creature. You'll have to fight it!");
        anythingToContinue();
        //creating new enemy
        battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], player.xp));
    }

    //methods that gets called when the player is dead
    public static void playerDied(){
        clearConsole();
        printHeading("You died...");
        System.out.println("You earned " + player.xp + " XP on your journey. Try to earn more next time!");
        System.out.println("Thank you for playing my game.");
        anythingToContinue();
        isRunning = false;
    }

    //The main battle method
    public static void battle(Enemy enemy){
        while(true){
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Choose an action:");
            printSeperator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Run Away");
            int input = readInt("-> ", 3);
            //react accordingly to player input
            if(input == 1){
                //Fight
                //calculate dmg and dmgTook (dmg enemy deals to player)
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                //check that dmg and dmgTook isnt negative
                if(dmgTook < 0){
                    //add some dmg if player defends well
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if(dmg < 0){
                    dmg = 0;
                }
                //deal damage to both parties
                player.hp -= dmgTook;
                enemy.hp -= dmg;
                //print the info of this battle round
                clearConsole();
                printHeading("BATTLE");
                System.out.println("You dealt " + dmg + " damage to the " + enemy.name + ".");
                printSeperator(15);
                System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
                anythingToContinue();
                //check if the player is still alive or dead
                if(player.hp <= 0){
                    playerDied();
                    break;
                }else if(enemy.hp <= 0){
                    //player won battle
                    clearConsole();
                    printHeading("You defeated the " + enemy.name + "!");
                    player.xp += enemy.xp;
                    System.out.println("You earned " + enemy.xp + " XP!");
                    //random drops
                    boolean addRest = (Math.random()*5 + 1 <= 2.25);
                    int goldEarned = (int)(Math.random()*enemy.xp);
                    if(addRest){
                        player.restsLeft++;
                        System.out.println("You earned the the chance to get an additional rest!");
                    }
                    if(goldEarned > 0){
                        player.gold += goldEarned;
                        System.out.println("You collect " + goldEarned + " gold from the " + enemy.name + "'s corpse!");
                    }
                    anythingToContinue();
                    break;
                }
            }else if(input == 2){
                //use portion
                clearConsole();
                if (player.pots > 0 && player.hp < player.maxHp){
                    //player CAN take a potion
                    //make sure player wants to drink the potion
                    printHeading("Do you want to drink a potion? (" + player.pots + " left).");
                    System.out.println("(1) Yes\n(2) No, maybe later");
                    input = readInt("-> ", 2 );
                    if (input == 1){
                        //player took the potion
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("You drank a magic potion. It restored your health back to " + player.maxHp);
                        anythingToContinue();
                    }
                }else {
                    //player CANT take a potion
                    printHeading("You don't have any potions or you're at full health.");
                    anythingToContinue();
                }
            }else{
                //Run away
                clearConsole();
               //check that player isnt in last act(final boss battle)
                if(act != 4) {
                    //chance of 35% to escape
                    if(Math.random()*10 + 1 <= 3.5){
                        printHeading("You ran away from the " + enemy.name + "!");
                        anythingToContinue();
                        break;
                    }else{
                        printHeading("You didn't manage to escape");
                        int dmgTook = enemy.attack();
                        System.out.println("In your hurry you took " + dmgTook + " damage!");
                        player.hp -= dmgTook;
                        anythingToContinue();
                        //check if the player still alive
                        if(player.hp <= 0)
                            playerDied();
                    }
                }else{
                    printHeading("YOU CAN'T ESCAPE FROM THE BOSS!");
                    anythingToContinue();
                }
            }
        }
    }

    //method to continue the journey
    public static void continueJourney(){
        //check if act must be increased
        checkAct();
        //check if game isnt in last act
        if(act != 4){
            randomEncounter();
        }
    }

    //printing out the most important information about the player character
    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeperator(20);
        //player xp and gold
        System.out.println("XP: " + player.xp + "\tGold: " + player.gold);
        printSeperator(20);
        //pots
        System.out.println("Numbers of Potions: " + player.pots);
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

    //shopping / encountering a travelling trader
    public static void shop(){
        clearConsole();
        printHeading("SHOP");
        printHeading("You meet a mysterious stranger. \nHe offers you someting:");
        int price = (int)(Math.random()*(10 + player.pots*3) + 10 + player.pots);
        System.out.println("- Magic Potion: " + price + " gold.");
        printSeperator(20);
        //ask the player to buy one
        System.out.println("Do you want to buy one?\n(1) Yes!\n(2) No, thanks maybe later.");
        int input = readInt("-> ", 2);
        //check if player wants to buy
        if(input == 1){
            clearConsole();
            //check if player has enough gold
            if(player.gold >= price){
                printHeading("You bought a magical potion for " + price + "gold.");
                player.pots++;
                player.gold -= price;
            }else{
                printHeading("You don't have enough gold to buy the potion...");
                anythingToContinue();
            }
        }
    }

    //taking a rest
    public static void takeRest(){
        clearConsole();
        if(player.restsLeft >= 1){
            System.out.println("REST");
            printHeading("Do you want to take a rest? (" + player.restsLeft + " rest(s) left).");
            System.out.println("(1) Yes\n(2) No, not now.");
            int input = readInt("-> ", 2);
            if(input == 1){
                //player takes rest
                clearConsole();
                if(player.hp < player.maxHp){
                    int hpRestored = (int)(Math.random()* (player.xp/4 + 1) + 10);
                    player.hp += hpRestored;
                    if(player.hp > player.maxHp)
                        player.hp = player.maxHp;
                    System.out.println("You took a rest and restored up to " + hpRestored + " health.");
                    System.out.println("You're now at " + player.hp + "/" + player.maxHp + " health.");
                    player.restsLeft--;
                    anythingToContinue();
                }
            }else{
                clearConsole();
                System.out.println("You are on full health or you don't have rests left!");
                anythingToContinue();
            }
        }
    }

    //the final (last) battle of the entire game
    public static void finalBattle(){
        battle(new Enemy("THE EVIL EMPEROR DRAKEN", 300));
        Story.printEnd(player);
        isRunning = false;
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
                //isRunning = false;
                continueJourney();
            }
        }
    }
}

