package act.processor;

import model.input.InputParagraph;
import model.process.Paragraph;

public interface Processor<T extends InputParagraph> {
    Paragraph process(T inputParagraph);
    Class getMyProcessType();
}
