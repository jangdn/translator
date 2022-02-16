package model.process;

import model.view.ViewPattern;

public abstract class Paragraph implements ViewPattern {
    protected abstract String internalToString();
    public String toString() {
        return this.getPrevious() + this.internalToString() + this.getNext();
    }
}
