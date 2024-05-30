package Character.view;

import Character.model.entity.Character;
import java.util.Scanner;

public class Console {
    protected Scanner keyboard;
    
    public Console()
    {
        this.keyboard = new Scanner(System.in);
    }
    public String writeName()
    {
        System.out.println("Ingrese su nombre!");
        String name = this.keyboard.nextLine();
        return name;
    }
    public void viewCharacter(Character c)
    {
        System.out.println("Tu pj se llama: " + c.getName() );
        System.out.println("maxhp: " + c.getMaxHP());
        System.out.println("Currenthp: " + c.getCurrentHp());
        System.out.println("Armour: " + c.getArmour() );
        System.out.println("maxDamage: " + c.getMaxDamage());
        System.out.println("CurrentDamage: " + c.getcurrentDamage());
    }
    
}
