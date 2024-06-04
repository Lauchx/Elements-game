package Character.model.entity;

import Player.model.entity.Player;

public class Character{
    protected String name;
    protected int maxHP;
    protected int currentHp;
    protected int armour;
    protected int maxDamage;
    protected int currentDamage;
    
    public Character(String name)
    {
        this.name = name;
        this.maxHP = 100;
        this.currentHp = 99;
        this.armour = 0;
        this.maxDamage = 50;
        this.currentDamage = 10;
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





}
