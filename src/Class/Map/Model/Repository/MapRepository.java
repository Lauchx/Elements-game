package Class.Map.Model.Repository;

import Class.Map.Model.Entity.Map;

public class MapRepository {
    public Map[] mapArray;

    public MapRepository()
    {
        mapArray = new Map[3];
    }
    public void addMap(Map map, int n)
    {
     this.mapArray[n] = map;
    }
}
