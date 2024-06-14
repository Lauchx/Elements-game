package Main;


import Class.Map.Model.Entity.Map;
import Class.Map.Vista.MapView;
import Class.Player.controller.PlayerControler;
import Class.Player.model.repository.PlayerRepository;
import Class.Player.view.PlayerView;

public class Program {

    public static void main(String[] args) {
        PlayerRepository playerRepository = new PlayerRepository();
        PlayerView playerView = new PlayerView();
        PlayerControler playerControler = new PlayerControler(playerRepository, playerView);
        MenuGame(playerControler);
        MapView mapView = new MapView();
        Map map = new Map();
        mapView.ShowMap(map);


    }
    static void MenuGame(PlayerControler playerControler)
    {
        playerControler.addPlayer();
        playerControler.ShowPlayer(playerControler.playerRepository);


    }
    
}
