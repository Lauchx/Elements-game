package Class.Superpower.Model.Entity;

import Class.Character.model.entity.Character;

public class Superpower extends Character {
    public int level;
    public String name;
    public Integer id;

    public Superpower(){}
    public Superpower(String name, Integer id)
    {
        this.level = 0;
        this.name = name;
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    @Override
    public String toString()
    {
        if(getId().equals(0))
        {
            return "| 火 |";
        }
        if(getId().equals(1))
        {
            return "| 水 |";
        }
        if(getId().equals(2))
        {
            return "| 風 |";
        }
        if(getId().equals(3))
        {
            return "| 陸 |";
        }
        return "Level:" + getLevel() + " // String: " + getName() + " // ID:" + id;
    }
}
