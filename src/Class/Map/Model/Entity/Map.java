package Class.Map.Model.Entity;

import Class.Character.model.entity.Character;

public class Map {
    public Character[][] map;

    public Map()
    {
        this.map = new Character[8][8];
    }

    public Character[][] getMap() {
        return map;
    }

    public void setMap(Character[][] map) {
        this.map = map;
    }
    @Override
    public String toString()
    {

        return "|--|";

    }
}
