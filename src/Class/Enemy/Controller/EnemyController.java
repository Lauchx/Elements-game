package Class.Enemy.Controller;

import Class.Enemy.Model.Entity.Enemy;
import Class.Enemy.Model.Repository.EnemyRepository;
import Class.Enemy.View.EnemyView;

public class EnemyController {
    private EnemyRepository enemyRepository;
    private EnemyView enemyView;

    public EnemyController(EnemyRepository enemyRepository, EnemyView enemyView)
    {
        this.enemyRepository = enemyRepository;
        this.enemyView = enemyView;
    }
    public void showEnemy(){
        this.enemyView.showEnemy(this.enemyRepository);
    }
    public void addEnemys()
    {
        this.enemyRepository.addEnemys();
    }
    public Enemy returnEnemy()
    {
        return this.enemyRepository.returnEnemy();
    }
}
