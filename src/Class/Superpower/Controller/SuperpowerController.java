package Class.Superpower.Controller;

import Class.Superpower.Model.Entity.Superpower;
import Class.Superpower.Model.Repository.SuperpowerRepository;
import Class.Superpower.View.SuperpowerView;

public class SuperpowerController {
    public SuperpowerRepository superpowerRepository;
    public SuperpowerView superpowerView;

    public SuperpowerController()
    {
        this.superpowerRepository = new SuperpowerRepository();
        this.superpowerView = new SuperpowerView();
    }

    public SuperpowerRepository getSuperpowerRepository() {
        return superpowerRepository;
    }

    public SuperpowerView getSuperpowerView() {
        return superpowerView;
    }

    public void addSuperpower()
    {
        String[] name = new String[4];
        name[0] = "Fire";
        name[1] = "Water";
        name[2] = "Wind";
        name[3] = "Earth";
        for(int i = 0; i < name.length ; i++)
        {
            Superpower superpower = new Superpower(name[i], i);
            this.superpowerRepository.addSuperpower(superpower);
        }
    }
    public void showSuperpower()
    {
        this.superpowerView.ShowSuperpower(this.superpowerRepository);
    }
}
