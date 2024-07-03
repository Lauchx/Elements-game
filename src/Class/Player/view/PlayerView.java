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
        System.out.println("𝓝𝖔𝖒𝖇𝖗𝖊 𝖉𝖊 𝖙𝖚 𝖕𝖊𝖘𝖔𝖓𝖆𝖏𝖊:");
        String name = this.scanner.nextLine();
        return new Player(name);

    }


    public void ShowPlayer(PlayerRepository playerRepository)
    {
        for (Player p: playerRepository.playerList)
        {
            System.out.println("𝓣𝖚 𝖕𝖊𝖗𝖘𝖔𝖓𝖆𝖏𝖊 𝖘𝖊 𝖑𝖑𝖆𝖒𝖆: " + p.getName() );
            System.out.println("𝓥𝖎𝖉𝖆: " + p.getCurrentHp());
            System.out.println("𝓐𝖗𝖒𝖆𝖉𝖚𝖗𝖆: " + p.getArmour() );
            System.out.println("𝓖𝖔𝖑𝖕𝖊: " + p.getCurrentDamage());
            System.out.println("--------------------------------");
        }
    }
    public void upgradeSuperpower(boolean trueOrFalse){
        if(!trueOrFalse){
            System.out.println("¡𝓐𝖑𝖈𝖆𝖓𝖘𝖆𝖘𝖙𝖊 𝖊𝖑 𝖒á𝖝𝖎𝖒𝖔 𝖓𝖎𝖛𝖊𝖑!");
        }
    }
}
