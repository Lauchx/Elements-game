package Class.Map.Model.Repository;

import Class.Character.model.entity.Character;
import Class.Map.Model.Entity.Map;
import Class.Player.controller.PlayerControler;
import Class.Player.model.entity.Player;

public class MapRepository {
    public Map[] mapArray;

    public MapRepository(int n)
    {
        mapArray = new Map[n];
    }
    public void CreateMap(int level, PlayerControler playerControler)
    {
        Map map = new Map();
        map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = playerControler.returnPlayer() ;
        this.addMapLevel(map, level);
    }
    void addMapLevel(Map map, int level)
    {
        this.mapArray[level] = map;
    }
    public void positionMap(Map map, PlayerControler playerControler, int level)
    {
        map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
        map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() + 1] = playerControler.returnPlayer();
        this.addMapLevel(map, level);
    }
}
