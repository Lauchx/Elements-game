package Class.Player.model.repository;

import Class.Character.model.entity.Character;
import Class.Enemy.Controller.EnemyController;
import Class.Enemy.Model.Entity.Enemy;
import Class.Player.controller.PlayerControler;
import Class.Player.model.entity.Player;
import Class.Superpower.Model.Entity.Superpower;
import Class.Superpower.Model.Repository.SuperpowerRepository;
import Intefaces.Combat;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepository implements Combat {
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
    @Override
    public void fight(EnemyController enemyController, PlayerControler playerControler, boolean levelMax){

        if(levelMax)
        {
            if ((enemyController.returnEnemy().getCurrentHp() - this.returnPlayer().getMaxDamage()) + enemyController.returnEnemy().getArmour() > 0 ) {
            enemyController.returnEnemy().setCurrentHp((enemyController.returnEnemy().getCurrentHp() - this.returnPlayer().getMaxDamage()) + enemyController.returnEnemy().getArmour());
            }else {
                enemyController.returnEnemy().setDead(true);
            }
        }else
        {
            if((enemyController.returnEnemy().getCurrentHp() - this.returnPlayer().getCurrentDamage()) + enemyController.returnEnemy().getArmour() > 0) {
                enemyController.returnEnemy().setCurrentHp((enemyController.returnEnemy().getCurrentHp() - this.returnPlayer().getCurrentDamage()) + enemyController.returnEnemy().getArmour());
            }else {
                enemyController.returnEnemy().setDead(true);
            }
        }
    }


            //FALTA ARMADURA Y COMPLEJIZAR UN TOQUE MÁS
            // ARMAS, SUPERPODER BOOOLEANO, ETC...

            /* Fuego te aumenta el daño
                viento aumenta la vida
                tierra aumenta la armadura
                agua (aumenta el daño? te protege ? otro disparo a larga distancia? )

                podrria tener ultis de nivel 5 (solamente si apretas una tecla. [NO hacer automatico])
                fuego --> disparo a larga distancia  ¿ tendria uno o más ? ( quema al enemigo ? )
                viento --> aumenta la vida al maximo
                tierra --> inmune a los golpes ¿por cuantos turnos?
                agua --> no se que puede ser (inmunidad contra la bola de fuego ?, ahogar al enemigo?)



                IDEA:
                FUEGO --> larga distancia eje y (columnas) si disparas al enemigo lo quemas, va perdiendo vida por 2 turnos
                AGUA --> larga distancia eje x (filas) si disparas al enemigo lo ahogas,va perdiendo vida por 2 turnos



         */


    public boolean upgradeSuperpower(Superpower superpower, SuperpowerRepository superpowerRepository)
    {
        if(superpower != null) {
            if (superpower.getId().equals(0)) {
                if (superpower.getLevel() != 5) {
                    superpower.setLevel(superpower.getLevel() + 5);
                    if (this.returnPlayer().getCurrentDamage() + 5 < this.returnPlayer().getMaxDamage()) {
                        this.returnPlayer().setCurrentDamage(this.returnPlayer().getCurrentDamage() + 5);
                        return true;
                    }
                } else {
                    return false;
                }
            } else if (superpower.getId().equals(1)) {
                if (superpower.getLevel() != 5) {
                    superpower.setLevel(superpower.getLevel() + 1);
                    if (this.returnPlayer().getCurrentDamage() + 5 < this.returnPlayer().getMaxDamage()) {
                        this.returnPlayer().setCurrentDamage(this.returnPlayer().getCurrentDamage() + 5);
                        return true;
                    }
                } else {
                    return false;
                }
            } else if (superpower.getId().equals(2)) {
                if (superpower.getLevel() != 5) {
                    superpower.setLevel(superpower.getLevel() + 1);
                    if (this.returnPlayer().getCurrentHp() + 10 < this.returnPlayer().getMaxHP()) {
                        this.returnPlayer().setCurrentHp(this.returnPlayer().getCurrentHp() + 10);
                        return true;
                    }
                } else {
                    return false;
                }
            } else if (superpower.getId().equals(3)) {
                if (superpower.getLevel() != 5) {
                    superpower.setLevel(superpower.getLevel() + 1);
                    this.returnPlayer().setArmour(this.returnPlayer().getArmour() + 2);
                    return true;
                } else {
                    return false;
                }
            }
        }
            return false;
    }
    public boolean UseMaxLevel(){
       // if(this.returnPlayer().superpowerRepository.);
        for(Superpower s: this.returnPlayer().superpowerRepository.superpowerList){

            if (s.getLevel() == 5) {
                if (s.getId().equals(0)){
                    s.setLevel(0);
                    s.setMaxDamage(s.getMaxDamage() + 5);
                    System.out.println("entro a fuego");
                    return true;
                }
                if (s.getId().equals(1)){
                    s.setLevel(0);
                    s.setMaxDamage(s.getMaxDamage() + 5);
                    return true;
                }
                if (s.getId().equals(2)){
                    s.setLevel(0);
                    s.setMaxHP(s.getMaxHP() + 5);
                    return true;
                }
                if (s.getId().equals(3)){
                    s.setLevel(0);
                    // tendria que ser automatico cuando quieren pegarle
                    return true;
                }

            }
        }
        return false;
    }


}
