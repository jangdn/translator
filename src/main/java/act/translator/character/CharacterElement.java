package act.translator.character;

public class CharacterElement implements CharacterGetter {
    public CharacterElement(Character element) {
        this.element = element;
    }

    private Character element;

    @Override
    public String getString() {
        return String.valueOf(this.element);
    }
}
