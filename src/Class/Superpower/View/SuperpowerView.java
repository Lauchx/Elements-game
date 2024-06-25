package Class.Superpower.View;

import Class.Superpower.Model.Entity.Superpower;
import Class.Superpower.Model.Repository.SuperpowerRepository;

import java.util.Scanner;

public class SuperpowerView {
    private Scanner scanner;

    public SuperpowerView()
    {
        this.scanner = new Scanner(System.in);
    }
    public void ShowSuperpower(SuperpowerRepository superpowerRepository)
    {
        int i =0;
        for(Superpower s: superpowerRepository.superpowerList)
        {
            System.out.println(s);
            System.out.println(s.getId() + " Level:" + s.getLevel() + " Name:" + s.getName());
            System.out.println(superpowerRepository.superpowerList.get(i).getId() + " Level:" + superpowerRepository.superpowerList.get(i).getLevel() + " Name:" + superpowerRepository.superpowerList.get(i).getName());
            i++;
        }
    }
}
