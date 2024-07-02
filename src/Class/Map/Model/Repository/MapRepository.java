package Class.Map.Model.Repository;

import Class.Character.model.entity.Character;
import Class.Enemy.Controller.EnemyController;
import Class.Enemy.Model.Entity.Enemy;
import Class.Map.Model.Entity.Map;
import Class.Player.controller.PlayerControler;
import Class.Superpower.Controller.SuperpowerController;
import Class.Superpower.Model.Entity.Superpower;

public class MapRepository {
    public Map[] mapArray;

    public MapRepository(int n) {
        mapArray = new Map[n];
    }

    public void CreateMap(int level, PlayerControler playerControler, EnemyController enemyController) {
        Map map = new Map(level);
        map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = playerControler.returnPlayer();
        map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY()] = enemyController.returnEnemy();
        this.addMapLevel(map, level);


    }

    void addMapLevel(Map map, int level) {
        this.mapArray[level] = map;
    }

    public boolean playerPositionMapY(Map map, PlayerControler playerControler, EnemyController enemyController, int level, String move, SuperpowerController superpowerController) {
        if (move.equals("a")) {
            if (playerControler.returnPlayer().getPositionY() - 1 >= 0) {
                if (map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() - 1] == null) {
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() - 1] = playerControler.returnPlayer();
                    playerControler.returnPlayer().setPositionY(playerControler.returnPlayer().getPositionY() - 1);
                    //map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()].setSuperpower(null);
                    this.addMapLevel(map, level);
                } else if (map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() - 1].equals(enemyController.returnEnemy())) {

                    if (!this.searchSuperpower_InMap(map, superpowerController)) {
                        int x;
                        int y;
                        do {
                            x = (int) (Math.random() * map.map.length);
                            y = (int) (Math.random() * map.map.length);
                        }while (x == playerControler.returnPlayer().getPositionX() && y == playerControler.returnPlayer().getPositionY() || ( x == enemyController.returnEnemy().getPositionX() && y == enemyController.returnEnemy().getPositionY() ));
                        Superpower superpower = new Superpower();
                        superpower = superpowerController.getSuperpowerRepository().ReturnRandomSuperpower();
                        map.map[x][y] = superpower;
                        map.map[x][y].setSuperpower(superpower);
                    }
                    playerControler.playerRepository.fight(enemyController, playerControler, playerControler.playerRepository.UseMaxLevel());
                } else {
                    playerControler.upgradeSuperpower(map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() - 1].getSuperpower(), superpowerController.superpowerRepository);
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() - 1] = playerControler.returnPlayer();
                    playerControler.returnPlayer().setPositionY(playerControler.returnPlayer().getPositionY() - 1);
                    //map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()].setSuperpower(null);
                }
            } else {
                return false;
            }
        } else {
            if (playerControler.returnPlayer().getPositionY() + 1 < map.map.length) {
                if (map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() + 1] == null) {
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() + 1] = playerControler.returnPlayer();
                    playerControler.returnPlayer().setPositionY(playerControler.returnPlayer().getPositionY() + 1);
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()].setSuperpower(null);
                    this.addMapLevel(map, level);
                } else if (map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() + 1].equals(enemyController.returnEnemy())) {

                    if (!this.searchSuperpower_InMap(map, superpowerController)) {
                        int x;
                        int y;
                        do {
                            x = (int) (Math.random() * map.map.length);
                            y = (int) (Math.random() * map.map.length);
                        }while ( (x == playerControler.returnPlayer().getPositionX() && y == playerControler.returnPlayer().getPositionY() ) || ( x == enemyController.returnEnemy().getPositionX() && y == enemyController.returnEnemy().getPositionY() ));
                        Superpower superpower = new Superpower();
                        superpower = superpowerController.getSuperpowerRepository().ReturnRandomSuperpower();
                        map.map[x][y] = superpower;
                        map.map[x][y].setSuperpower(superpower);
                    }
                    playerControler.playerRepository.fight(enemyController, playerControler, playerControler.playerRepository.UseMaxLevel());
                } else {
                    playerControler.upgradeSuperpower(map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() + 1].getSuperpower(), superpowerController.superpowerRepository);
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() + 1] = playerControler.returnPlayer();
                    playerControler.returnPlayer().setPositionY(playerControler.returnPlayer().getPositionY() + 1);
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()].setSuperpower(null);
                }
            } else {
                return false;
            }

        }
        return true;
    }

    public boolean playerPositionMapX(Map map, PlayerControler playerControler, int level, String move, EnemyController enemyController, SuperpowerController superpowerController) {
        if (move.equals("w")) {
            if (playerControler.returnPlayer().getPositionX() - 1 >= 0) {
                if (map.map[playerControler.returnPlayer().getPositionX() - 1][playerControler.returnPlayer().getPositionY()] == null) {
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                    map.map[playerControler.returnPlayer().getPositionX() - 1][playerControler.returnPlayer().getPositionY()] = playerControler.returnPlayer();
                    playerControler.returnPlayer().setPositionX(playerControler.returnPlayer().getPositionX() - 1);
                    this.addMapLevel(map, level);
                } else if (map.map[playerControler.returnPlayer().getPositionX() - 1][playerControler.returnPlayer().getPositionY()].equals(enemyController.returnEnemy())) {
                    if (!this.searchSuperpower_InMap(map, superpowerController)) {

                        int x;
                        int y;
                        do {
                            x = (int) (Math.random() * map.map.length);
                            y = (int) (Math.random() * map.map.length);
                        }while (x == playerControler.returnPlayer().getPositionX() && y == playerControler.returnPlayer().getPositionY() || ( x == enemyController.returnEnemy().getPositionX() && y == enemyController.returnEnemy().getPositionY() ));
                        Superpower superpower = new Superpower();
                        superpower = superpowerController.getSuperpowerRepository().ReturnRandomSuperpower();
                        map.map[x][y] = superpower;
                        map.map[x][y].setSuperpower(superpower);
                    }
                    playerControler.playerRepository.fight(enemyController, playerControler, playerControler.playerRepository.UseMaxLevel());
                } else {
                    playerControler.upgradeSuperpower(map.map[playerControler.returnPlayer().getPositionX() - 1][playerControler.returnPlayer().getPositionY()].getSuperpower(), superpowerController.superpowerRepository);
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                    playerControler.returnPlayer().setPositionX(playerControler.returnPlayer().getPositionX() - 1);
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = playerControler.returnPlayer();
                }
            } else {
                return false;
            }
        } else {
            if (playerControler.returnPlayer().getPositionX() + 1 < map.map.length) {
                if (map.map[playerControler.returnPlayer().getPositionX() + 1][playerControler.returnPlayer().getPositionY()] == null) {
                    // Lugar vacio, el juegador se mueve, y se setea el mapa
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                    playerControler.returnPlayer().setPositionX(playerControler.returnPlayer().getPositionX() + 1);
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = playerControler.returnPlayer();
                    this.addMapLevel(map, level);
                } else if (map.map[playerControler.returnPlayer().getPositionX() + 1][playerControler.returnPlayer().getPositionY()].equals(enemyController.returnEnemy())) {
                    // crea un superpoder solamente si no existe uno en el mapa.
                    if (!this.searchSuperpower_InMap(map, superpowerController)) {
                        int x;
                        int y;
                        do {
                            x = (int) (Math.random() * map.map.length);
                            y = (int) (Math.random() * map.map.length);
                        }while (x == playerControler.returnPlayer().getPositionX() && y == playerControler.returnPlayer().getPositionY() || ( x == enemyController.returnEnemy().getPositionX() && y == enemyController.returnEnemy().getPositionY() ));
                        Superpower superpower = new Superpower();
                        superpower = superpowerController.getSuperpowerRepository().ReturnRandomSuperpower();
                        map.map[x][y] = superpower;
                        map.map[x][y].setSuperpower(superpower);
                    }
                    //existe un enemigo en el lugar donde se quiere mover, hay pelea.
                    playerControler.playerRepository.fight(enemyController, playerControler, playerControler.playerRepository.UseMaxLevel());
                } else {
                    // Aqui entra en caso de que el personaje se mueve a un superpoder, upgradea el superpoder correspondiente
                    playerControler.upgradeSuperpower(map.map[playerControler.returnPlayer().getPositionX() + 1][playerControler.returnPlayer().getPositionY()].getSuperpower(), superpowerController.superpowerRepository);
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                    playerControler.returnPlayer().setPositionX(playerControler.returnPlayer().getPositionX() + 1);
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = playerControler.returnPlayer();
                    this.addMapLevel(map, level);
                    // Metodo en el player, para upgradear el nivel. Tendria que pasarle por parametro el setSuperpower de map.map[][]. antes de que sea null
                }
            } else {
                return false;
            }

        }
        return true;

    }

    public boolean searchSuperpower_InMap(Map map, SuperpowerController superpowerController) {
        Enemy enemy = new Enemy();
        for (int i = 0; i < map.map.length; i++) {
            for (int j = 0; j < map.map.length; j++) {

                if (map.map[i][j] != enemy && ( map.map[i][j] == superpowerController.superpowerRepository.getFire() || map.map[i][j] == superpowerController.superpowerRepository.getWater() || map.map[i][j] == superpowerController.superpowerRepository.getWind() || map.map[i][j] == superpowerController.superpowerRepository.getEarth())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean enemyPositionMapY(Map map, EnemyController enemyController, int level) // Revisar si el método tiene que ser void!.
    {
        if (enemyController.returnEnemy() != null) {
            int azar = (int) (Math.random() * 2);
            if (azar >= 1) {
                if (enemyController.returnEnemy().getPositionY() - level > 0) {
                    if (map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY() - level] == null) {
                        map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY()] = null;
                        map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY() - level] = enemyController.returnEnemy();
                        enemyController.returnEnemy().setPositionY(enemyController.returnEnemy().getPositionY() - level);
                        this.addMapLevel(map, level);
                        return true;
                    }

                }
            } else {
                if (enemyController.returnEnemy().getPositionY() + level < map.map.length) {
                    if (map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY() + level] == null) {
                        map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY()] = null;
                        map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY() + level] = enemyController.returnEnemy();
                        enemyController.returnEnemy().setPositionY(enemyController.returnEnemy().getPositionY() + level);
                        this.addMapLevel(map, level);
                        return true;
                    }
                }
            }
        }
        return false;

    }


    public boolean enemyPositionMapX(Map map, EnemyController enemyController, int level) {
        if (enemyController.returnEnemy() != null) {
            int azar = (int) (Math.random() * 2);
            if (azar >= 1) {
                if (enemyController.returnEnemy().getPositionX() - level >= 0) {
                    if (map.map[enemyController.returnEnemy().getPositionX() - level][enemyController.returnEnemy().getPositionY()] == null) {
                        map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY()] = null;
                        map.map[enemyController.returnEnemy().getPositionX() - level][enemyController.returnEnemy().getPositionY()] = enemyController.returnEnemy();
                        enemyController.returnEnemy().setPositionX(enemyController.returnEnemy().getPositionX() - level);
                        this.addMapLevel(map, level);
                        return true;
                    }

                }
            } else {
                if (enemyController.returnEnemy().getPositionX() + level < map.map.length) {
                    if (map.map[enemyController.returnEnemy().getPositionX() + level][enemyController.returnEnemy().getPositionY()] == null) {
                        map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY()] = null;
                        map.map[enemyController.returnEnemy().getPositionX() + level][enemyController.returnEnemy().getPositionY()] = enemyController.returnEnemy();
                        enemyController.returnEnemy().setPositionX(enemyController.returnEnemy().getPositionX() + level);
                        this.addMapLevel(map, level);
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
