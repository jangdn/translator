package model.braille;

import model.process.Paragraph;

public class BrailleVerseParagraph extends BrailleParagraph {
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
}
