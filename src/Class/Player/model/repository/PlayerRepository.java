package Class.Player.model.repository;

import Class.Player.model.entity.Player;

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

    }
