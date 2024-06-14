package Class.Player.model.entity;

import Class.Character.model.entity.Character;

public class Player extends Character {
    private int ne;
    
    public Player(String name) {
    super.setName(name);
    super.setMaxHP(100);
    super.setCurrentHp(99);
    super.setArmour(0);
    super.setMaxDamage(30);
    super.setCurrentDamage(10);
}
    @Override
    public String toString()
    {
        return "[Player] Nombre:" + this.name + "Vida" + this.currentHp + "Armadura" + this.armour + "Daño" + this.currentDamage + "Pruebas maxhp" + this.maxHP + " maxdmg" + this.maxDamage;
    }

    
    
}
