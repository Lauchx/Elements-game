package Class.Map.Controller;

import Class.Enemy.Controller.EnemyController;
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
    public void CreateMap(int level, PlayerControler playerControler, EnemyController enemyController)
    {
        this.mapRepository.CreateMap(level, playerControler, enemyController);
    }

    public void show_MapLevel(int level)
    {
        this.mapView.ShowMap(this.mapRepository, level);
    }
    public void playerMove(PlayerControler playerControler, int level, EnemyController enemyController)
    {
        String move = this.mapView.playerMove();
        switch (move)
        {
            case "w":
                noMoveMore(this.mapRepository.playerPositionMapX(this.mapRepository.mapArray[1], playerControler, level, move));
                break;
            case "a":
                noMoveMore(this.mapRepository.playerPositionMapY(this.mapRepository.mapArray[1], playerControler,enemyController ,level, move));
                break;
            case "s":
                noMoveMore(this.mapRepository.playerPositionMapX(this.mapRepository.mapArray[1], playerControler, level, move));
                break;
            case "d":
                noMoveMore(this.mapRepository.playerPositionMapY(this.mapRepository.mapArray[1], playerControler, enemyController, level, move));
                break;
            default:
                break;
        }
    }
    public void EnemyMove(EnemyController enemyController, int level)
    {
        this.mapRepository.enemyPositionMapX(this.mapRepository.mapArray[level], enemyController, level);
        this.mapRepository.enemyPositionMapY(this.mapRepository.mapArray[level], enemyController, level);
    }
    public void noMoveMore(boolean yesornot)
    {
        this.mapView.noMoveMore(yesornot);
    }
}
