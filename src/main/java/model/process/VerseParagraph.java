package model.process;

import model.process.Paragraph;

public class VerseParagraph extends Paragraph {
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
}
