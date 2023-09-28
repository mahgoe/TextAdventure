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
        System.out.println("STORY");
        GameLogic.printSeperator(30);
        System.out.println("After facing numerous challenges and puzzles within the caverns, you secure the Shard of Hope.");
        System.out.println("Yet, its power remains dormant. Lyria suggests seeking out the Oracle of Luminara, an age-old entity said to possess the knowledge to unlock the shard's energy.");
        GameLogic.anythingToContinue();
    }

    public static void printThirdIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("STORY");
        GameLogic.printSeperator(30);
        System.out.println("The journey to find the Oracle takes you across treacherous mountains and through haunted valleys.");
        System.out.println("All the while, Draken's forces are in pursuit, his awareness of your threat growing.");
        GameLogic.anythingToContinue();
    }

    public static void printThirdOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("STORY");
        GameLogic.printSeperator(30);
        System.out.println("Reaching the Oracle's temple, you undergo a series of trials. Proving your worth, the Oracle enlightens you about the remaining shards and the ritual to awaken their power.");
        System.out.println("But a war is brewing, and time is running short.");
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
