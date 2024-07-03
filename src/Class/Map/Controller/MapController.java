package Class.Map.Controller;

import Class.Enemy.Controller.EnemyController;
import Class.Enemy.Model.Entity.Enemy;
import Class.Map.Model.Repository.MapRepository;
import Class.Map.Vista.MapView;
import Class.Player.controller.PlayerControler;
import Class.Superpower.Controller.SuperpowerController;

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

    public boolean show_MapLevel(int level, EnemyController enemyController, PlayerControler playerControler)
    {
        return this.mapView.ShowMap(this.mapRepository, level, enemyController, playerControler);
    }
    public void playerMove(PlayerControler playerControler, int level, EnemyController enemyController, SuperpowerController superpowerController)
    {
        String move = "";
        do {
            move = this.mapView.playerMove();
            switch (move) {
                case "w":
                    noMoveMore(this.mapRepository.playerPositionMapX(this.mapRepository.mapArray[level], playerControler, level, move, enemyController, superpowerController));
                    break;
                case "a":
                    noMoveMore(this.mapRepository.playerPositionMapY(this.mapRepository.mapArray[level], playerControler, enemyController, level, move, superpowerController));
                    break;
                case "s":
                    noMoveMore(this.mapRepository.playerPositionMapX(this.mapRepository.mapArray[level], playerControler, level, move, enemyController, superpowerController));
                    break;
                case "d":
                    noMoveMore(this.mapRepository.playerPositionMapY(this.mapRepository.mapArray[level], playerControler, enemyController, level, move, superpowerController));
                    break;
                case "i":
                    playerControler.ShowPlayer();
                    enemyController.showEnemy();
                    superpowerController.showSuperpower();
                    break;
                case "r":
                    break;
                default:
                    break;
            }
        }while (move.equals("i"));
    }
    public void EnemyMove(EnemyController enemyController, int level, PlayerControler playerControler)
    {
        Enemy enemy = new Enemy();
        if(enemyController.returnEnemy() != enemy){
        this.mapRepository.enemyPositionMapX(this.mapRepository.mapArray[level], enemyController, level, playerControler);
        this.mapRepository.enemyPositionMapY(this.mapRepository.mapArray[level], enemyController, level, playerControler);
        }
    }
    public void noMoveMore(boolean yesornot)
    {
        this.mapView.noMoveMore(yesornot);
    }
}
