package Class.Map.Model.Repository;

import Class.Enemy.Controller.EnemyController;
import Class.Map.Controller.MapController;
import Class.Map.Model.Entity.Map;
import Class.Player.controller.PlayerControler;

import java.util.Arrays;

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
        map.map[enemyController.returnEnemy().getPositionX()][enemyController.returnEnemy().getPositionX()] = enemyController.returnEnemy();
        this.addMapLevel(map, level);


    }
    void addMapLevel(Map map, int level)
    {
        this.mapArray[level] = map;
    }
    public boolean positionMapY(Map map, PlayerControler playerControler, EnemyController enemyController ,int level, String move)
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
            } else {
                return false;
            }
        }
        else
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
                    this.Fight(playerControler, enemyController);
                }
            }
            else{
                return false;
            }

        }
        return true;
    }
    public boolean positionMapX(Map map, PlayerControler playerControler, int level, String move)
    {
        if(move.equals("w"))
        {
            if(playerControler.returnPlayer().getPositionX() - 1 >= 0)
            {
                map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                map.map[playerControler.returnPlayer().getPositionX() - 1][playerControler.returnPlayer().getPositionY()] = playerControler.returnPlayer();
                playerControler.returnPlayer().setPositionX(playerControler.returnPlayer().getPositionX() - 1);
                this.addMapLevel(map, level);
            }
            else{
                return false;
            }
        }
        else
        {
            if(playerControler.returnPlayer().getPositionX() + 1 < 8)
            {
                map.map[playerControler.returnPlayer().getPositionX()][playerControler.returnPlayer().getPositionY()] = null;
                map.map[playerControler.returnPlayer().getPositionX() + 1][playerControler.returnPlayer().getPositionY()] = playerControler.returnPlayer();
                playerControler.returnPlayer().setPositionX(playerControler.returnPlayer().getPositionX() + 1);
                this.addMapLevel(map, level);
            }
            else{
                return false;
            }

        }
        return true;

    }
    public void Fight(PlayerControler playerControler, EnemyController enemyController)
    {
        playerControler.returnPlayer().setCurrentHp(enemyController.returnEnemy().getCurrentDamage());
        enemyController.returnEnemy().setCurrentHp(playerControler.returnPlayer().getCurrentDamage());

    }
}
