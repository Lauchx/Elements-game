package Class.Player.view;

import Class.Player.model.entity.Player;
import Class.Player.model.repository.PlayerRepository;

import java.util.Scanner;

public class PlayerView {
    public Scanner scanner;

    public PlayerView()
    {
        this.scanner = new Scanner(System.in);
    }
    public Player addPlayer()
    {
        System.out.println("Nombre de tu pesonaje:");
        String name = this.scanner.nextLine();
        return new Player(name);

    }


    public void ShowPlayer(PlayerRepository playerRepository)
    {
        for (Player p: playerRepository.playerList)
        {

            System.out.println("Tu pj se llama: " + p.getName() );
            System.out.println("maxhp: " + p.getMaxHP());
            System.out.println("Currenthp: " + p.getCurrentHp());
            System.out.println("Armour: " + p.getArmour() );
            System.out.println("maxDamage: " + p.getMaxDamage());
            System.out.println("CurrentDamage: " + p.getCurrentDamage());
        }
    }
}
