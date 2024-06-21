package Class.Map.Controller;

import Class.Map.Model.Repository.MapRepository;
import Class.Map.Vista.MapView;
import Class.Player.controller.PlayerControler;

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
                noMoveMore(this.mapRepository.positionMapX(this.mapRepository.mapArray[1], playerControler, level, move));
                break;
            case "a":
                noMoveMore(this.mapRepository.positionMapY(this.mapRepository.mapArray[1], playerControler, level, move));
                break;
            case "s":
                noMoveMore(this.mapRepository.positionMapX(this.mapRepository.mapArray[1], playerControler, level, move));
                break;
            case "d":
                noMoveMore(this.mapRepository.positionMapY(this.mapRepository.mapArray[1], playerControler, level, move));
                break;
            default:
                break;
        }
    }
    public void noMoveMore(boolean yesornot)
    {
        this.mapView.noMoveMore(yesornot);
    }
}
