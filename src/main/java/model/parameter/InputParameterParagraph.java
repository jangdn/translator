package model.parameter;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import model.input.InputParagraph;
import model.input.SummaryInputParagraph;
import model.input.VerseInputParagraph;

import java.util.List;

public class InputParameterParagraph {
    private String title;
    private String subtitle;
    private String description;
    private List<ChapterParameter> chapters;

    public InputParameterParagraph() {
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDescription() {
        return description;
    }

    public List<ChapterParameter> getChapters() {
        return chapters;
    }

    public InputParameterParagraph(String title, String subtitle, String description, List<ChapterParameter> chapters) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.chapters = chapters;
    }

    public static class ChapterParameter {
        private String chapterNumber;
        private List<VerseGroupParameter> versesOrSummaries;

        public ChapterParameter(String chapterNumber, List<VerseGroupParameter> versesOrSummaries) {
            this.chapterNumber = chapterNumber;
            this.versesOrSummaries = versesOrSummaries;
        }

        public ChapterParameter() {
        }

        public String getChapterNumber() {
            return chapterNumber;
        }

        public List<VerseGroupParameter> getVersesOrSummaries() {
            return versesOrSummaries;
        }
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "@type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = SummaryParameter.class, name = "SUMMARY"),
            @JsonSubTypes.Type(value = VerseParameter.class, name = "VERSE")
    })
    public abstract static class VerseGroupParameter {
        protected VerseGroupParameter() {
        }
        public abstract InputParagraph toInputParagraph();
    }

    public static class SummaryParameter extends VerseGroupParameter {
        private String title;
        private String subtitle;

        public SummaryParameter(String title, String subtitle) {
            this.title = title;
            this.subtitle = subtitle;
        }

        public SummaryParameter() {
        }

        @Override
        public InputParagraph toInputParagraph() {
            return new SummaryInputParagraph(this.title, this.subtitle);
        }

        public String getTitle() {
            return title;
        }

        public String getSubtitle() {
            return subtitle;
        }
    }

    public static class VerseParameter extends VerseGroupParameter {
        private String verseNumber;
        private String content;

        public VerseParameter(String verseNumber, String content) {
            this.verseNumber = verseNumber;
            this.content = content;
        }

        public VerseParameter() {
        }

        @Override
        public InputParagraph toInputParagraph() {
            return new VerseInputParagraph(this.verseNumber, content);
        }

        public String getVerseNumber() {
            return verseNumber;
        }

        public String getContent() {
            return content;
        }
    }
}
