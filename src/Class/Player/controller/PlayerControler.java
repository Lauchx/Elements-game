package Class.Player.controller;

import Class.Player.model.entity.Player;
import Class.Player.model.repository.PlayerRepository;
import Class.Player.view.PlayerView;

public class PlayerControler {
    public PlayerRepository playerRepository;
    public PlayerView playerView;

    public PlayerControler(PlayerRepository playerRepository,PlayerView playerView )
    {
        this.playerRepository = playerRepository;
        this.playerView = playerView;
    }
    public void addPlayer()
    {
        this.playerRepository.addPlayer(this.playerView.addPlayer());
    }
    public void ShowPlayer()
    {
        this.playerView.ShowPlayer(this.playerRepository);
    }
    public Player returnPlayer()
    {
        return this.playerRepository.returnPlayer();
    }
}
