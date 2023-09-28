package textadventure.main;

//class that does nothing but storing methods to print out every part of the story
public class Story {

    public static void printIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("STORY");
        GameLogic.printSeperator(30);
        System.out.println("In a land where hope was once abundant, shadows begin to creep over its territories. The Evil Emperor, known as Draken, has risen to power, causing despair and chaos to spread.");
        System.out.println("As a young wanderer, you find yourself entangled in a destiny bigger than you could have ever imagined.");
        System.out.println("Rumors tell of an ancient power, forgotten and hidden, which might have the strength to overthrow Draken. Your journey begins here.");
        GameLogic.anythingToContinue();
    }

    public static void printFirstIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT I - INTRO");
        GameLogic.printSeperator(30);
        System.out.println("Upon reaching the town of Eldoria, you learn of Draken's spies, who are everywhere.");
        System.out.println("The locals, fearful but resilient, tell tales of a hidden sanctuary deep in the Forbidden Woods where rebels plan and gather.");
        System.out.println("You decide to seek it out, hoping to find allies or, at least, some answers.");
        GameLogic.anythingToContinue();
    }

    public static void printFirstOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT I - OUTRO");
        GameLogic.printSeperator(30);
        System.out.println("Navigating the treacherous paths of the Forbidden Woods, you finally discover the hidden sanctuary.");
        System.out.println("It's a camp bustling with warriors, mages, and scholars, all united against Draken. ");
        System.out.println("Here, you meet Lyria, a mage who speaks of an ancient prophecy and believes you to be the key to its fulfillment.");
        GameLogic.anythingToContinue();
    }

    public static void printSecondIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT II - INTRO");
        GameLogic.printSeperator(30);
        System.out.println("With Lyria as your guide, you embark on a quest to retrieve the first Shard of Hope, a relic believed to have the power to weaken Draken.");
        System.out.println("Rumors lead you to the Caverns of Desolation, guarded by creatures corrupted by Draken's dark magic.");
        GameLogic.anythingToContinue();
    }

    public static void printSecondOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT II - OUTRO");
        GameLogic.printSeperator(30);
        System.out.println("After facing numerous challenges and puzzles within the caverns, you secure the Shard of Hope.");
        System.out.println("Yet, its power remains dormant. Lyria suggests seeking out the Oracle of Luminara, an age-old entity said to possess the knowledge to unlock the shard's energy.");
        GameLogic.anythingToContinue();
    }

    public static void printThirdIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT III - INTRO");
        GameLogic.printSeperator(30);
        System.out.println("The journey to find the Oracle takes you across treacherous mountains and through haunted valleys.");
        System.out.println("All the while, Draken's forces are in pursuit, his awareness of your threat growing.");
        GameLogic.anythingToContinue();
    }

    public static void printThirdOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT III - OUTRO");
        GameLogic.printSeperator(30);
        System.out.println("Reaching the Oracle's temple, you undergo a series of trials. Proving your worth, the Oracle enlightens you about the remaining shards and the ritual to awaken their power.");
        System.out.println("But a war is brewing, and time is running short.");
        GameLogic.anythingToContinue();
    }
    public static void printFourthIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT IV - INTRO");
        GameLogic.printSeperator(30);
        System.out.println("Situated on the border of his expanding empire, the towering fortress represents Draken's tightening grip on the realm.");
        System.out.println("Protected by massive walls, moats, and legions of his elite guards, the fortress is believed to house the second Shard of Hope.");
        System.out.println("As you approach, it becomes clear that this will be your most challenging mission yet. Espionage might be a wiser choice over a direct assault.");
        System.out.println("With Lyria by your side, you plot a stealthy infiltration, hoping to retrieve the shard before Draken can use it for his dark purposes.");
        GameLogic.anythingToContinue();
    }
    public static void printFourthOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT IV - OUTRO");
        GameLogic.printSeperator(30);
        System.out.println("Deep within the bowels of the fortress lies the dungeon - a grim place where prisoners of importance are kept. After successfully navigating the fortress's defenses, you find yourself here, not as an infiltrator, but as a prisoner.");
        System.out.println("The Shard of Hope was a trap, a ruse set up by Draken to capture you.");
        System.out.println("Bound by chains, you meet an old sage named Elreon, another prisoner. He speaks of a hidden passage, an escape route known only to a few. Together, you must find a way to break free, retrieve the Shard, and continue your quest to end Draken's reign.");
        GameLogic.anythingToContinue();
    }


    // tbt
    public static void printEnd(Player player){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("STORY");
        System.out.println("But a war is brewing, and time is running short.");
        GameLogic.anythingToContinue();
    }

}
