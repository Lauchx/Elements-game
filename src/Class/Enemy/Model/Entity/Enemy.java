package Class.Enemy.Model.Entity;

import Class.Character.model.entity.Character;

public class Enemy extends Character {
    public int positionX;
    public int positionY;

    public Enemy(int x, int y)
    {
        this.positionX = x;
        this.positionY = y;
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
}
