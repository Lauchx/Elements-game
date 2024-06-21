package Class.Enemy.View;

import Class.Enemy.Model.Repository.EnemyRepository;

import java.util.Scanner;

public class EnemyView {
    private Scanner scanner;

    public EnemyView()
    {
        this.scanner = new Scanner(System.in);
    }
    public void showEnemy(EnemyRepository enemyRepository)
    {
        System.out.println("Enemigo:" + enemyRepository.returnEnemy().getName());
        System.out.println("maxhp: " + enemyRepository.returnEnemy().getMaxHP() );
        System.out.println("Currenthp: " + enemyRepository.returnEnemy().getCurrentHp());
        System.out.println("Armour: " + enemyRepository.returnEnemy().getArmour());
        System.out.println("maxDamage: " + enemyRepository.returnEnemy().getMaxDamage());
        System.out.println("CurrentDamage: " + enemyRepository.returnEnemy().getCurrentDamage());
    }
}
