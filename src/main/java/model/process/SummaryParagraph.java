package model.process;

import model.view.Summary;

public class SummaryParagraph extends Paragraph implements Summary {
    private String title;
    private String subtitle;

    public SummaryParagraph(String title, String subtitle) {
        super();
        this.title = title;
        this.subtitle = subtitle;
    }

    @Override
    protected String internalToString() {
        return this.title + '\n' + this.subtitle;
    }
}
