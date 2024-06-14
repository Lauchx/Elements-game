package Class.Map.Vista;



import Class.Map.Model.Repository.MapRepository;

import java.util.Scanner;

public class MapView {
    public Scanner scanner;

    public MapView()
    {
        this.scanner = new Scanner(System.in);
    }

    public void ShowMap(MapRepository[] mapRepository, int n)
    {
         for(int i = 0; i< 8; i ++)
         {
             System.out.println("________________________________");
             for(int j = 0; j< 8; j ++)
             {
                 System.out.print(mapRepository[n]);
             }
             System.out.println(" ");
         }

    }
}
