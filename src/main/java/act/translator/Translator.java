package act.translator;

import model.braille.BrailleParagraph;
import model.input.InputParagraph;
import model.process.Paragraph;

public interface Translator<T extends Paragraph> {
    BrailleParagraph translate(T paragraph);
    Class getMyProcessType();
}
