package model.process;

import model.view.ViewPattern;

import java.util.Optional;

public abstract class Paragraph implements ViewPattern {
    protected abstract String internalToString();

    public String toString(Optional<Paragraph> beforeParagraph, Optional<Paragraph> afterParagraph) {
        return this.getPrevious(beforeParagraph) + this.internalToString() + this.getNext(afterParagraph);
    }
}
