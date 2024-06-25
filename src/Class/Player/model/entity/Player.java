package Class.Player.model.entity;

import Class.Character.model.entity.Character;
import Class.Superpower.Model.Entity.Superpower;
import Class.Superpower.Model.Repository.SuperpowerRepository;

public class Player extends Character {
    public Integer id;
    public SuperpowerRepository superpowerRepository;


    public Player(String name) {
    super.setName(name);
    super.setMaxHP(100);
    super.setCurrentHp(99);
    super.setArmour(0);
    super.setMaxDamage(30);
    super.setCurrentDamage(10);
    this.superpowerRepository = new SuperpowerRepository();
    super.positionX = 0;
    super.positionY = 0;
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

    public SuperpowerRepository getSuperpowerRepository() {
        return superpowerRepository;
    }

    public void setSuperpowerRepository(SuperpowerRepository superpowerRepository) {
        this.superpowerRepository = superpowerRepository;
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
