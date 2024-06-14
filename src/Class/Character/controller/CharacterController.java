package Class.Character.controller;


import Class.Character.model.repository.CharacterRepository;
import Class.Character.view.CharacterView;

public class CharacterController {
    public CharacterRepository characterRepository;
    public CharacterView characterView;

public CharacterController(CharacterRepository characterRepository, CharacterView view)
{
    this.characterRepository = characterRepository;
    this.characterView = view;

}


public CharacterRepository getCharacterRepository() {
        return characterRepository;
}
}
