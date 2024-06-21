package Class.Enemy.Model.Repository;

import Class.Enemy.Model.Entity.Enemy;

import java.util.Random;

public class EnemyRepository {
    public Enemy[] enemyArray;

    public EnemyRepository(int amountEnemys)
    {
        enemyArray = new Enemy[amountEnemys];
    }

    public Enemy[] getEnemyArray() {
        return enemyArray;
    }

    public void setEnemyArray(Enemy[] enemyArray) {
        this.enemyArray = enemyArray;
    }

    public void addEnemys()
    {
        for (int i = 0; i < this.enemyArray.length; i++){
            int x = (int)(Math.random()*8);
            int y = (int)(Math.random()*7+2);

            Enemy enemy = new Enemy(x, y);
            this.enemyArray[i] = enemy ;
        }
    }
}
