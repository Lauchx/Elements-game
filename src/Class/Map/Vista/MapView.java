package Class.Map.Vista;



import Class.Map.Model.Repository.MapRepository;
import Class.Character.model.entity.Character;
import java.util.Scanner;

public class MapView {
    public Scanner scanner;

    public MapView()
    {
        this.scanner = new Scanner(System.in);
    }

    public void ShowMap(MapRepository mapRepository, int level)
    {
        for(int i = 0; i < mapRepository.mapArray[level].map.length;i++)
        {
            for(int j = 0; j < mapRepository.mapArray[level].map.length;j++)
            {
                Character character = new Character();
                character = mapRepository.mapArray[level].map[i][j];
                if(character == null)
                {
                    System.out.print("|   |");
                }else
                {
                    System.out.print(character.toString());
                }
            }
            System.out.println("");
            System.out.println("----------------------------------------");
        }

    }
    public String playerMove()
    {
        return this.scanner.nextLine().toLowerCase();
    }
    public void noMoveMore(boolean yesornot)
    {
        if (!yesornot)
        {
            System.out.println("No podes atravesar paredes!... Por ahora...");
        }
    }
}
