package Class.Player.model.repository;

import Class.Enemy.Controller.EnemyController;
import Class.Player.model.entity.Player;
import Class.Superpower.Model.Entity.Superpower;
import Class.Superpower.Model.Repository.SuperpowerRepository;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    public List<Player> playerList; // Si yo no necesitara muchos, para que me sirve un repositorio, yo solo quiero uno


    public PlayerRepository()
    {
        this.playerList = new ArrayList();
    }
    public void addPlayer(Player player)
    {
        this.playerList.add(player);

    }
    public List<Player> getPlayerList() {
        return playerList;
    }
    public Player returnPlayer()
    {
        for(Player p: playerList)
        {
            if(p.getId().equals(1)){
                return p;
            }
        }
        return null;
    }
    public void createSuperpowers(SuperpowerRepository superpowerRepository)
    {
        this.returnPlayer().setSuperpowerRepository(superpowerRepository);
    }
    public void fight(EnemyController enemyController){
        int azar = (int) (Math.random()*6);
        if(azar == 5)
        {
            enemyController.returnEnemy().setCurrentHp(enemyController.returnEnemy().getCurrentDamage() - this.returnPlayer().getMaxDamage());
        }else
        {
            enemyController.returnEnemy().setCurrentHp(enemyController.returnEnemy().getCurrentHp() - this.returnPlayer().getCurrentDamage());
            //FALTA ARMADURA Y COMPLEJIZAR UN TOQUE MÁS
            // ARMAS, SUPERPODER BOOOLEANO, ETC... 
        }





        //        if(azar==5)
//        {
//            this.returnPlayer().setCurrentHp(returnPlayer().getCurrentHp() - enemyController.returnEnemy().getMaxDamage());
//            System.out.println("critico");
//        }else {
//            this.returnPlayer().setCurrentHp(returnPlayer().getCurrentHp() - enemyController.returnEnemy().getCurrentDamage());
//            System.out.println("normal");
//        }
//        }

    }
    public void upgradeSuperpower(Superpower superpower, SuperpowerRepository superpowerRepository)
    {


            if (superpower.getId().equals(0)) {
                superpower.setLevel(superpower.getLevel() +1);
                System.out.println("up 0");
            } else if (superpower.getId().equals(1)) {
                superpower.setLevel(superpower.getLevel() +1);
                System.out.println("up 1");
            } else if (superpower.getId().equals(2)) {
                superpower.setLevel(superpower.getLevel() +1);
                System.out.println("up 2");
            } else if (superpower.getId().equals(3)) {
                superpower.setLevel(superpower.getLevel() +1);
                System.out.println("up 3");
            }

    }
}
