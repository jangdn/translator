package act.translator.character;

import java.util.Arrays;

public class CharacterList implements CharacterGetter {
    public CharacterList(Character[] elements) {
        this.elements = elements;
    }

    private Character[] elements;

    @Override
    public String getString() {
        return Arrays.toString(this.elements);
    }
}
