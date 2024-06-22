package Main;


import Class.Enemy.Controller.EnemyController;
import Class.Enemy.Model.Repository.EnemyRepository;
import Class.Enemy.View.EnemyView;
import Class.Map.Controller.MapController;
import Class.Map.Model.Entity.Map;
import Class.Map.Model.Repository.MapRepository;
import Class.Map.Vista.MapView;
import Class.Player.controller.PlayerControler;
import Class.Player.model.repository.PlayerRepository;
import Class.Player.view.PlayerView;

public class Program {

    public static void main(String[] args) {
        PlayerRepository playerRepository = new PlayerRepository();
        PlayerView playerView = new PlayerView();
        PlayerControler playerControler = new PlayerControler(playerRepository, playerView);
        MapRepository mapRepository = new MapRepository(3);
        MapView mapView = new MapView();
        MapController mapController = new MapController(mapRepository, mapView);
        EnemyView enemyView = new EnemyView();
        EnemyRepository enemyRepository = new EnemyRepository();
        EnemyController enemyController = new EnemyController(enemyRepository, enemyView);
        MenuGame(playerControler, mapController, enemyController);



    }
    static void MenuGame(PlayerControler playerControler, MapController mapController,EnemyController enemyController)
    {
        playerControler.addPlayer();
        enemyController.addEnemys();
        playerControler.ShowPlayer(playerControler.playerRepository);
        mapController.CreateMap(1, playerControler, enemyController);
        String uno = "1";
        do
        {

            enemyController.showEnemy();
            mapController.show_MapLevel(1);
            mapController.playerMove(playerControler, 1, enemyController);
            mapController.EnemyMove(enemyController, 1);
        }while(uno.equals("1"));





        // IDEA:
//        switch (number)
//        {
//            case 1:
//                level 1;
//                    break;
//            case 2:
//                level 2;
//                break;
//            case 3:
//                level 3;
//                break;
//            default:
//                System.out.println("NO existen mas niveles perrito malvado");
//        }

    }
    
}
