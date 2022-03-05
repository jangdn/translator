package model.process;

import model.view.Verse;

public class VerseParagraph extends Paragraph implements Verse {
    private String value;
    private String num;

    public VerseParagraph(String value, String num) {
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
        return this.num.toString() + " " + this.value;
    }
}
