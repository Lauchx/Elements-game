package Class.Character.view;

import Class.Character.model.entity.Character;
import Class.Player.model.repository.PlayerRepository;
import Class.Player.view.PlayerView;

import java.util.Scanner;

public class CharacterView {
    protected Scanner keyboard;
    
    public CharacterView()
    {
        this.keyboard = new Scanner(System.in);
    }
    public String writeName()
    {
        System.out.println("Ingrese su nombre!");
        String name = this.keyboard.nextLine();
        return name;
    }
//    public void viewCharacter(PlayerRepository playerRepository)
//    {
//        System.out.println("Tu pj se llama: " + c.getName() );
//        System.out.println("maxhp: " + c.getMaxHP());
//        System.out.println("Currenthp: " + c.getCurrentHp());
//        System.out.println("Armour: " + c.getArmour() );
//        System.out.println("maxDamage: " + c.getMaxDamage());
//        System.out.println("CurrentDamage: " + c.getCurrentDamage());
//    }
//
}
