package model.process;

import model.view.Verse;

public class VerseParagraph extends Paragraph implements Verse {
    private String value;
    private Integer num;

    public VerseParagraph(String value, Integer num) {
        this.value = value;
        this.num = num;
    }

    public String getValue() {
        return value;
    }

    public Integer getNum() {
        return num;
    }

    @Override
    protected String internalToString() {
        return this.num.toString() + " " + this.value;
    }
}
