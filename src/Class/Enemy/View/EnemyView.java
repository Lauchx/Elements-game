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
        if(enemyRepository.returnEnemy() != null) {
            System.out.println("𝓔𝖓𝖊𝖒𝖎𝖌𝖔: " + enemyRepository.returnEnemy().getName());
            System.out.println("𝓥𝖎𝖉𝖆: " + enemyRepository.returnEnemy().getCurrentHp());
            System.out.println("𝓐𝖗𝖒𝖆𝖉𝖚𝖗𝖆: " + enemyRepository.returnEnemy().getArmour());
            System.out.println("𝓖𝖔𝖑𝖕𝖊: " + enemyRepository.returnEnemy().getCurrentDamage());
            System.out.println("--------------------------------");
        }
    }
}
