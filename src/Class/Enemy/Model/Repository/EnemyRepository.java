package Class.Enemy.Model.Repository;

import Class.Enemy.Model.Entity.Enemy;

import java.util.ArrayList;
import java.util.List;

public class EnemyRepository {
    public List<Enemy> enemyList;

    public EnemyRepository()
    {
        enemyList = new ArrayList();
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(List<Enemy> enemyList) {
        this.enemyList = enemyList;
    }

    public void addEnemys()
    {
        String[] names = new String[3];
        names[0] = "Mateicopulus";
        names[1] = "Leites Dulsus";
        names[2] = "Asasadolokus";
        for (int i = 0; i < 3; i++){


            Enemy enemy = new Enemy(names[i]);

            this.enemyList.add(enemy);
        }

    }
    public Enemy returnEnemy()
    {
            for (Enemy e : this.enemyList) {
                if (!e.getDead()) {
                    return e;
                }
            }
        return null;
    }
}
