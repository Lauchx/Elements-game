package Intefaces;

import Class.Enemy.Controller.EnemyController;
import Class.Player.controller.PlayerControler;

public interface Combat {

abstract void fight(EnemyController enemyController, PlayerControler playerControler, boolean levelMax);
}
