package Class.Map.Controller;

import Class.Character.model.entity.Character;
import Class.Map.Model.Repository.MapRepository;
import Class.Map.Vista.MapView;
import Class.Player.controller.PlayerControler;
import Class.Player.model.entity.Player;

public class MapController {
    public MapRepository mapRepository;
    public MapView mapView;

    public MapController(MapRepository mapRepository, MapView mapView)
    {
        this.mapView = mapView;
        this.mapRepository = mapRepository;
    }
    public void CreateMap(int level, PlayerControler playerControler)
    {
        this.mapRepository.CreateMap(level, playerControler);
    }

    public void show_MapLevel(int level)
    {
        this.mapView.ShowMap(this.mapRepository, level);
    }
    public void playerMove(PlayerControler playerControler, int level)
    {
        String move = this.mapView.playerMove();
        switch (move)
        {
            case "w":

                break;
            case "a":
                break;
            case "s":
                break;
            case "d":
                this.mapRepository.positionMap(this.mapRepository.mapArray[1], playerControler, level);
                break;
            default:
                break;
        }
    }
}
