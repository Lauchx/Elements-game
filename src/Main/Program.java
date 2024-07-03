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
        SuperpowerController superpowerController = new SuperpowerController();
        MenuGame(playerControler, mapController, enemyController, superpowerController);


    }

    static void MenuGame(PlayerControler playerControler, MapController mapController, EnemyController enemyController, SuperpowerController superpowerController) {
        playerControler.addPlayer();
        superpowerController.addSuperpower();
        playerControler.createSuperpowers(superpowerController.superpowerRepository);
        //String uno = "1";
        Scanner scanner = new Scanner(System.in);
        System.out.println("〘𝕷𝖊𝖛𝖊𝖑 1〙〘𝕷𝖊𝖛𝖊𝖑 2〙〘𝕷𝖊𝖛𝖊𝖑 3〙〘𝑨𝒚𝒖𝒅𝒂 0〙");
        int level = scanner.nextInt();
        scanner = new Scanner(System.in);
        boolean finished;
        enemyController.addEnemys(level);
        // en lugar de uin switch ya es el mismo codigo, tendria un if(level == 1 || level == 2 || level == 3 ) {un unico codigo} else { sout("no existe ese nivel");
        if (level == 1 || level == 2 || level == 3) {
            System.out.println( "'𝖎' 𝖒á𝖘 𝖎𝖓𝖋𝖔𝖗𝖒𝖆𝖈𝖎ó𝖓.\n𝓟𝖆𝖗𝖆 𝖒𝖔𝖛𝖊𝖗𝖘𝖊 𝖚𝖘𝖆𝖗 𝖑𝖆𝖘 𝖙𝖊𝖈𝖑𝖆𝖘: \n╚» 𝓦 «╝ ▲ \n╚» 𝓐 «╝ ◀ \n╚» 𝓢 «╝ ▼ \n╚» 𝓓 «╝ ▶");
            mapController.CreateMap(level, playerControler, enemyController);
            do {
                finished = mapController.show_MapLevel(level, enemyController, playerControler);
                if (finished) {

                    mapController.playerMove(playerControler, level, enemyController, superpowerController);
                    mapController.EnemyMove(enemyController, level, playerControler);
                }
            } while (finished);

        } else if (level == 0) {
            System.out.println("-𝕰𝖑 𝖊𝖓𝖊𝖒𝖎𝖌𝖔 𝖘𝖊 𝖒𝖔𝖛𝖊𝖗á 𝖘𝖊𝖌ú𝖓 𝖊𝖑 𝖓𝖎𝖛𝖊𝖑 𝖉𝖊 𝖉𝖎𝖋𝖎𝖈𝖚𝖑𝖙𝖆𝖉, 𝖕𝖚𝖊𝖉𝖊 𝖘𝖊𝖗 1 𝖔 𝖛𝖆𝖗𝖎𝖆𝖘 𝖈𝖆𝖘𝖎𝖑𝖑𝖆𝖘 𝖆 𝖑𝖆 𝖛𝖊𝖟. \n -𝕰𝖑 𝖏𝖚𝖌𝖆𝖉𝖔𝖗 𝖘𝖔𝖑𝖔 𝖘𝖊 𝖕𝖔𝖉𝖗á 𝖒𝖔𝖛𝖊𝖗 𝖚𝖓𝖆 𝖈𝖆𝖘𝖎𝖑𝖑𝖆, 𝖓𝖔 𝖕𝖔𝖉𝖗á 𝖒𝖔𝖛𝖊𝖗𝖘𝖊 𝖊𝖓 𝖉𝖎𝖆𝖌𝖔𝖓𝖆𝖑. \n-𝕷𝖔𝖘 𝖘𝖚𝖕𝖊𝖗𝖕𝖔𝖉𝖊𝖗𝖊𝖘 𝖆𝖕𝖆𝖗𝖊𝖈𝖊𝖗á 𝖈𝖚𝖆𝖓𝖉𝖔 𝖆𝖈𝖎𝖊𝖗𝖙𝖊𝖘 𝖊𝖓 𝖊𝖑 𝖈𝖆𝖘𝖎𝖑𝖑𝖊𝖗𝖔 𝖊𝖓𝖊𝖒𝖎𝖌𝖔, 𝖘𝖎 𝖊𝖘 𝖖𝖚𝖊 𝖓𝖔 𝖊𝖝𝖎𝖘𝖙𝖊 𝖚𝖓 𝖘𝖚𝖕𝖊𝖗𝖕𝖔𝖉𝖊𝖗 𝖊𝖓 𝖊𝖑 𝖒𝖆𝖕𝖆. \n-𝖘𝖊𝖌𝖚𝖎𝖗");
        } else {
            System.out.println("𝓝𝖔 𝖊𝖝𝖎𝖘𝖙𝖊𝖓 𝖒𝖆𝖘 𝖓𝖎𝖛𝖊𝖑𝖊𝖘");
        }
    }
}


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

