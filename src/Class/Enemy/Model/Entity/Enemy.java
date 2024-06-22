package Class.Enemy.Model.Entity;

import Class.Character.model.entity.Character;

public class Enemy extends Character {
    public int positionX;
    public int positionY;
    public boolean dead;

    public Enemy(int x, int y, String name)
    {
        super.name = name;
        super.maxHP = 10;
        super.currentHp = 10;
        super.armour = 10;
        super.maxDamage = 10;
        super.currentDamage = 10;
        this.positionX = x;
        this.positionY = y;
        this.dead = false;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public boolean getDead()
    {
        return this.dead;
    }
    @Override
    public String toString()
    {
        return "| ✩ |";
    }

}
