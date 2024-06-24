package Class.Character.model.entity;

import Class.Superpower.Model.Entity.Superpower;
import Class.Superpower.Model.Repository.SuperpowerRepository;

public class Character{
    public String name;
    protected int maxHP;
    protected int currentHp;
    protected int armour;
    protected int maxDamage;
    protected int currentDamage;
    protected Superpower superpower;
    public int positionX;
    public int positionY;
    
    public Character()
    {
        this.name = "";
        this.maxHP = 0;
        this.currentHp = 0;
        this.armour = 0;
        this.maxDamage = 0;
        this.currentDamage = 0;
        this.positionX = 0;
        this.positionY = 0;
        this.superpower = null;
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

    public Superpower getSuperpower() {
        return superpower;
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

    public void setSuperpower(Superpower superpower) {
        this.superpower = superpower;
    }

    @Override
    public String toString()
    {

        return "|---|";
    }

}
