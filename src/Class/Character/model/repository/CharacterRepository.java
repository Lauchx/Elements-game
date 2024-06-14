package Class.Character.model.repository;

import java.util.ArrayList;
import java.util.List;
import  Class.Character.model.entity.Character;

public class CharacterRepository {
    public List<Character> characterList;

    public CharacterRepository(List<Character> listCharacter)
    {
        this.characterList = new ArrayList();
    }


}
