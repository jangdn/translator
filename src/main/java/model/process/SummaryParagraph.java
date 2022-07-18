package model.process;

import model.view.Summary;
import org.apache.commons.lang3.StringUtils;

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
        if (StringUtils.isEmpty(this.title)) {
            return this.subtitle;
        }
        if (StringUtils.isEmpty(this.subtitle)) {
            return this.title;
        }
        return this.title + '\n' + this.subtitle;
    }
}
