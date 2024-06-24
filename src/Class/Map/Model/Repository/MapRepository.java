package Class.Map.Model.Repository;

import Class.Enemy.Controller.EnemyController;
import Class.Map.Model.Entity.Map;
import Class.Player.controller.PlayerControler;
import Class.Superpower.Controller.SuperpowerController;
import Class.Superpower.Model.Entity.Superpower;

public class MapRepository {
    public Map[] mapArray;

    public MapRepository(int n)
    {
        mapArray = new Map[n];
    }
    public void CreateMap(int level, PlayerControler playerControler, EnemyController enemyController)
    {
        Map map = new Map();
        map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = playerControler.returnPlayer();
        map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY()] = enemyController.returnEnemy();
        this.addMapLevel(map, level);


    }
    void addMapLevel(Map map, int level)
    {
        this.mapArray[level] = map;
    }
    public boolean playerPositionMapY(Map map, PlayerControler playerControler, EnemyController enemyController , int level, String move, SuperpowerController superpowerController)
    {
        if(move.equals("a"))
        {
            if (playerControler.returnPlayer().getPositionY() - 1 >= 0) {
                if(map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() - 1] == null) {
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() - 1] = playerControler.returnPlayer();
                    playerControler.returnPlayer().setPositionY(playerControler.returnPlayer().getPositionY() - 1);
                    this.addMapLevel(map, level);
                }
                else
                {

                    // superpowerController.superpowerRepository.SearchSuperpower(map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() - 1]);
                    
                    if(map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() - 1].equals(enemyController.returnEnemy()))
                    {
                        playerControler.playerRepository.fight(enemyController);
                        int x = (int)(Math.random()*7);
                        int y = (int)(Math.random()*7);
                        Superpower superpower = new Superpower();
                        superpower = superpowerController.getSuperpowerRepository().ReturnRandomSuperpower();
                        map.map[x][y] = superpower;
                        map.map[x][y].setSuperpower(superpower);
                        // no se para que puede servir pero........
                        if(map.map[x][y].getSuperpower() != null)
                        {
                        }
                        if(map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() - 1].getSuperpower() != null){

                        }
                    }
                    else
                    {
                        map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                        map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() - 1] = playerControler.returnPlayer();
//                        playerControler.playerRepository.returnPlayer().setSuperpower(); // necesito un superpoder

                    }
                        
                }
            }
        } else {
            return false;
        }else // arreglar esto
        {
            if(playerControler.returnPlayer().getPositionY() + 1 < 8)
            {
                if(map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() + 1] == null) {
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY() + 1] = playerControler.returnPlayer();
                    playerControler.returnPlayer().setPositionY(playerControler.returnPlayer().getPositionY() + 1);
                    this.addMapLevel(map, level);
                }
                else {
                    playerControler.playerRepository.fight(enemyController);
                    map.map[(int)(Math.random()*7)][(int)(Math.random()*7)] = superpowerController.getSuperpowerRepository().ReturnRandomSuperpower();
                }
            }
            else{
                return false;
            }

        }
        return true;
    }

    public boolean playerPositionMapX(Map map, PlayerControler playerControler, int level, String move, EnemyController enemyController, SuperpowerController superpowerController)
    {
        if(move.equals("w"))
        {
            if(playerControler.returnPlayer().getPositionX() - 1 >= 0)
            {
                if(map.map[playerControler.returnPlayer().getPositionX() - 1][playerControler.returnPlayer().getPositionY()] == null) {
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                    map.map[playerControler.returnPlayer().getPositionX() - 1][playerControler.returnPlayer().getPositionY()] = playerControler.returnPlayer();
                    playerControler.returnPlayer().setPositionX(playerControler.returnPlayer().getPositionX() - 1);
                    this.addMapLevel(map, level);
                }
                else
                {
                    playerControler.playerRepository.fight(enemyController);
                    map.map[(int)(Math.random()*7)][(int)(Math.random()*7)] = superpowerController.getSuperpowerRepository().ReturnRandomSuperpower();   //.equals((int)(Math.random()*4));
                    //SuperpowerController.
                }
            }
            else{
                return false;
            }
        }
        else
        {
            if(playerControler.returnPlayer().getPositionX() + 1 < 8)
            {
                if(map.map[playerControler.returnPlayer().getPositionX() + 1][playerControler.returnPlayer().getPositionY()] == null) {
                    map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                    map.map[playerControler.returnPlayer().getPositionX() + 1][playerControler.returnPlayer().getPositionY()] = playerControler.returnPlayer();
                    playerControler.returnPlayer().setPositionX(playerControler.returnPlayer().getPositionX() + 1);
                    this.addMapLevel(map, level);
                }
                else {
                    playerControler.playerRepository.fight(enemyController);
                    map.map[(int)(Math.random()*7)][(int)(Math.random()*7)] = superpowerController.getSuperpowerRepository().ReturnRandomSuperpower();

                }
            }
            else{
                return false;
            }

        }
        return true;

    }
    public boolean enemyPositionMapY(Map map, EnemyController enemyController, int level)
    {
        int azar = (int)(Math.random()*2);
        if(azar >= 1) {
            if (enemyController.returnEnemy().getPositionY() - level >= 0) {
                if (map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY() - level] == null) {
                    map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY()] = null;
                    map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY() - level] = enemyController.returnEnemy();
                    enemyController.returnEnemy().setPositionY(enemyController.returnEnemy().getPositionY() - level);
                    this.addMapLevel(map, level);
                    return true;
                }

            }
        }
        else{
            if(enemyController.returnEnemy().getPositionY() + level < 8)
            {
                if(map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY() + level] == null) {
                    map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY()] = null;
                    map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY() + level] = enemyController.returnEnemy();
                    enemyController.returnEnemy().setPositionY(enemyController.returnEnemy().getPositionY() + level);
                    this.addMapLevel(map, level);
                    return true;
                }
            }
        }
        return false;

    }


    public boolean enemyPositionMapX(Map map, EnemyController enemyController, int level)
    {
        int azar = (int)(Math.random()*2);
        if(azar >= 1) {
            if (enemyController.returnEnemy().getPositionX() - level >= 0) {
                if (map.map[enemyController.returnEnemy().getPositionX() - level][enemyController.returnEnemy().getPositionY()] == null) {
                    map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY()] = null;
                    map.map[enemyController.returnEnemy().getPositionX() - level][enemyController.returnEnemy().getPositionY()] = enemyController.returnEnemy();
                    enemyController.returnEnemy().setPositionX(enemyController.returnEnemy().getPositionX() - level);
                    this.addMapLevel(map, level);
                    return true;
                }

            }
        }
        else{
            if(enemyController.returnEnemy().getPositionX() + level < 8)
            {
                if(map.map[enemyController.returnEnemy().getPositionX() + level][enemyController.returnEnemy().getPositionY()] == null) {
                    map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionY()] = null;
                    map.map[enemyController.returnEnemy().getPositionX() + level][enemyController.returnEnemy().getPositionY()] = enemyController.returnEnemy();
                    enemyController.returnEnemy().setPositionX(enemyController.returnEnemy().getPositionX() + level);
                    this.addMapLevel(map, level);
                    return true;
                }
            }
        }
        return false;
    }

}
