package gamethefacts;
import gamethefacts.view.Console;
import gamethefacts.chars.Character;

public class Program {

    public static void main(String[] args) {
       Console workWrite = new Console();
       String name = workWrite.writeName();
       Character c = new Character();
       c.Character(name);
       workWrite.viewCharacter(c);
       if(this.nombre.equals(per.nombre) == false)
       {
           return false;
       }
       /*Es igual a  if(!this.nombre.equals(per.nombre)) quiere decir que mi nombre es distinto*/
    }
    
}
