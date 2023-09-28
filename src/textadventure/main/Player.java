package textadventure.main;

//Extends meaning inherit from superclass "Character"
public class Player extends Character{

    //integers to store number of upgrades/skills in each path
    public int numAtkUpgrades, numDefUpgrades;

    //Arrays to store skill names
    public String[] atkUpgrades = {"Strength", "Power", "Might", "Godlike Strenght"};
    public String[] defUpgrades = {"Heavy Bones", "Stoneskin", "Scale Armor", "Scale Armor", "Holy Aura"};


    //Player specific constructor (maxHp and xp will be hard coded)
    public Player(String name) {
        //calling constructor of superclass
        super(name,  100, 0);
        //Setting up upgrades to 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        //let the player choose a trait when creating a new character
        chooseTrait();
    }

    //Player specific methods
    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

    //let the player choose a trait of either skill path
    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait:");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        //players choice
        int input = GameLogic.readInt("-->", 2);
        GameLogic.clearConsole();
        //player choose atk, def Upgrades
        if(input == 1){
            GameLogic.printHeading("You choose " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        }else {
            GameLogic.printHeading("You chose " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
    }
}
