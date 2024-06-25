package Class.Player.controller;

import Class.Player.model.entity.Player;
import Class.Player.model.repository.PlayerRepository;
import Class.Player.view.PlayerView;
import Class.Superpower.Model.Entity.Superpower;
import Class.Superpower.Model.Repository.SuperpowerRepository;

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
    public void createSuperpowers(SuperpowerRepository superpowerRepository)
    {
        this.playerRepository.createSuperpowers(superpowerRepository);
    }
    public void upgradeSuperpower(Superpower superpower, SuperpowerRepository superpowerRepository)
    {
        this.playerRepository.upgradeSuperpower(superpower, superpowerRepository);
    }
    // metodo para aumentar los atributos o tener la ulti de fuego. para llamarlo desde el main o desde el map
}
