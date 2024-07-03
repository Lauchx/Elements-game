package Class.Superpower.Model.Repository;

import Class.Character.model.entity.Character;
import Class.Superpower.Controller.SuperpowerController;
import Class.Superpower.Model.Entity.Superpower;

import java.util.ArrayList;
import java.util.List;

public class SuperpowerRepository {
    public List<Superpower> superpowerList;

    public SuperpowerRepository() {
        this.superpowerList = new ArrayList();
    }

    public void addSuperpower(Superpower superpower) {
        this.superpowerList.add(superpower);
    }

    public Superpower ReturnRandomSuperpower() {
        Integer random = (int) (Math.random() * 4);
        Superpower superpower = new Superpower();
        for (Superpower s : this.superpowerList) {
            if (s.getId().equals(random)) {
                superpower = s;
            }

        }
        return superpower;
    }

    public Superpower getFire(){
        return this.superpowerList.get(0);
    }
    public Superpower getWater(){
        return this.superpowerList.get(1);
    }
    public Superpower getWind(){
        return this.superpowerList.get(2);
    }
    public Superpower getEarth(){
        return this.superpowerList.get(3);
    }

}

