package textadventure.main;

public abstract class  Character {

    //Attributes for all characters
    public String name;
    public int maxHp, hp, xp;

    //Constructor for character
    public Character(String name, int maxHp, int xp) {
        this.name = name;
        this.maxHp = maxHp;
        this.xp = xp;
        this.hp = maxHp;
    }

    //methods every character has
    public abstract int attack();
    public abstract int defend();
}
