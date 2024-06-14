package Class.Map.Controller;

import Class.Map.Model.Entity.Map;
import Class.Map.Model.Repository.MapRepository;

public class MapController {
    public Map map;
    public MapRepository mapRepository;

    public MapController(Map map, MapRepository mapRepository)
    {
        this.map = map;
        this.mapRepository = mapRepository;
    }
}
