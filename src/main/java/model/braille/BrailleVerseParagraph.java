package model.braille;

import model.process.Paragraph;
import model.view.Verse;

public class BrailleVerseParagraph extends BrailleParagraph implements Verse {
    private String value;
    private String num;

    public BrailleVerseParagraph(String value, String num) {
        this.value = value;
        this.num = num;
    }

    public String getValue() {
        return value;
    }

    public String getNum() {
        return num;
    }

    @Override
    protected String internalToString() {
        return num + " " + value;
    }
}
