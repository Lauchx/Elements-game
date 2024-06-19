package Class.Character.model.entity;

public class Character{
    public String name;
    protected int maxHP;
    protected int currentHp;
    protected int armour;
    protected int maxDamage;
    protected int currentDamage;
    
    public Character()
    {
        this.name = "";
        this.maxHP = 0;
        this.currentHp = 0;
        this.armour = 0;
        this.maxDamage = 0;
        this.currentDamage = 0;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public int getCurrentHp() {
        return this.currentHp;
    }

    public int getArmour() {
        return this.armour;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public int getCurrentDamage() {
        return this.currentDamage;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public void setCurrentDamage(int currentDamage) {
        this.currentDamage = currentDamage;
    }
    @Override
    public String toString()
    {

        return "|---|";
    }

}
