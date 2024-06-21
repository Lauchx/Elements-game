package Class.Player.model.entity;

import Class.Character.model.entity.Character;

public class Player extends Character {
    public int positionX;
    public int positionY;
    public Integer id;


    public Player(String name) {
    super.setName(name);
    super.setMaxHP(100);
    super.setCurrentHp(99);
    super.setArmour(0);
    super.setMaxDamage(30);
    super.setCurrentDamage(10);
    this.positionX = 0;
    this.positionY = 0;
    this.id = 1;
}
    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Integer getId() {
        return id;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }


    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString()
    {
        // "[Player] Nombre:" + this.name + "Vida" + this.currentHp + "Armadura" + this.armour + "Daño" + this.currentDamage + "Pruebas maxhp" + this.maxHP + " maxdmg" + this.maxDamage;
        return "| ✦ |";
    }




    // I do have an overwrite, at toString, on character. In this case, I don´t have to overwrite toString on two classes (player, enemy).

    
    
}
