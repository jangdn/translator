package model.braille;

import model.view.ViewPattern;

public abstract class BrailleParagraph implements ViewPattern {
    protected abstract String internalToString();

    public String toString() {
        return this.getPrevious() + this.internalToString() + this.getNext();
    }
}
