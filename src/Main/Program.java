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
import Class.Superpower.Controller.SuperpowerController;
import Class.Superpower.Model.Repository.SuperpowerRepository;
import Class.Superpower.View.SuperpowerView;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        PlayerRepository playerRepository = new PlayerRepository();
        PlayerView playerView = new PlayerView();
        PlayerControler playerControler = new PlayerControler(playerRepository, playerView);
        MapRepository mapRepository = new MapRepository(4);
        MapView mapView = new MapView();
        MapController mapController = new MapController(mapRepository, mapView);
        EnemyView enemyView = new EnemyView();
        EnemyRepository enemyRepository = new EnemyRepository();
        EnemyController enemyController = new EnemyController(enemyRepository, enemyView);
        SuperpowerController  superpowerController= new SuperpowerController();
        MenuGame(playerControler, mapController, enemyController,superpowerController );



    }
    static void MenuGame(PlayerControler playerControler, MapController mapController,EnemyController enemyController, SuperpowerController  superpowerController)
    {
        playerControler.addPlayer();
        superpowerController.addSuperpower();
        playerControler.createSuperpowers(superpowerController.superpowerRepository);
        playerControler.ShowPlayer();
        //String uno = "1";
        Scanner scanner = new Scanner(System.in);
        int level = scanner.nextInt();
        scanner = new Scanner(System.in);
        boolean finished;
        enemyController.addEnemys(level);
        // en lugar de uin switch ya es el mismo codigo, tendria un if(level == 1 || level == 2 || level == 3 ) {un unico codigo} else { sout("no existe ese nivel");
        if(level == 1 || level == 2 || level == 3 ){
            mapController.CreateMap(level, playerControler, enemyController);
            do {
                superpowerController.showSuperpower();
                playerControler.ShowPlayer();
                enemyController.showEnemy();
                finished = mapController.show_MapLevel(level, enemyController, playerControler);
                if (finished) {
                    mapController.playerMove(playerControler, level, enemyController, superpowerController);
                    mapController.EnemyMove(enemyController, level);
                }
            }while(finished);

        }else{
            System.out.println("NO existen mas niveles perrito malvado");
        }
//        switch (level)
//        {
//            case 1:
//                // level 1
//                mapController.CreateMap(level, playerControler, enemyController);
//                do {
//                    superpowerController.showSuperpower();
//                    playerControler.ShowPlayer();
//                    enemyController.showEnemy();
//                    finished = mapController.show_MapLevel(level, enemyController, playerControler);
//                    if (finished) {
//                        mapController.playerMove(playerControler, level, enemyController, superpowerController);
//                        mapController.EnemyMove(enemyController, level);
//                    }
//                }while(finished);
//                break;
//            case 2:
//                // level 2
//                mapController.CreateMap(level, playerControler, enemyController);
//                do {
//                    superpowerController.showSuperpower();
//                    playerControler.ShowPlayer();
//                    enemyController.showEnemy();
//                    finished = mapController.show_MapLevel(level, enemyController, playerControler);
//                    if (finished) {
//                        mapController.playerMove(playerControler, level, enemyController, superpowerController);
//                        mapController.EnemyMove(enemyController, level);
//                    }
//                }while(finished);
//                break;
//            case 3:
//                // level 3
//                mapController.CreateMap(level, playerControler, enemyController);
//                do {
//                    superpowerController.showSuperpower();
//                    playerControler.ShowPlayer();
//                    enemyController.showEnemy();
//                    finished = mapController.show_MapLevel(level, enemyController, playerControler);
//                    if (finished) {
//                        mapController.playerMove(playerControler, level, enemyController, superpowerController);
//                        mapController.EnemyMove(enemyController, level);
//                    }
//                }while (finished);
//                break;
//            default:
//                System.out.println("NO existen mas niveles perrito malvado");
//        }
//        do
//        {
//            //PARA NO SER TAN ROMPE, TENDIRA QUE MOSTRAR SOLAMENTE SI ESCRIBE  i. Porque hay mucha info.
//            superpowerController.showSuperpower();
//            playerControler.ShowPlayer();
//            enemyController.showEnemy();
//           if(mapController.show_MapLevel(1, enemyController, playerControler))
//            {
//                mapController.playerMove(playerControler, 1, enemyController, superpowerController);
//                mapController.EnemyMove(enemyController, 1);
//            }
//        }while(uno.equals("1"));


        /* Fuego te aumenta el daño
        viento aumenta la vida
        tierra aumenta la armadura
        agua (aumenta el daño? te protege ? otro disparo a larga distancia? )

        podria tener ultis de nivel 5 (solamente si apretas una tecla. [NO hacer automatico])
        fuego --> disparo a larga distancia  ¿ tendria uno o más ? ( quema al enemigo ? )
        viento --> aumenta la vida al maximo
        tierra --> inmune a los golpes ¿por cuantos turnos?
        agua --> no se que puede ser (inmunidad contra la bola de fuego ?, ahogar al enemigo?)



        IDEA:
        FUEGO --> larga distancia eje y (columnas) si disparas al enemigo lo quemas, va perdiendo vida por 2 turnos
        AGUA --> larga distancia eje x (filas) si disparas al enemigo lo ahogas,va perdiendo vida por 2 turnos



         */


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
