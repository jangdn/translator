package model.parameter;

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
        private Integer chapterNumber;
        private List<VerseParameter> verses;

        public ChapterParameter(Integer chapterNumber, List<VerseParameter> verses) {
            this.chapterNumber = chapterNumber;
            this.verses = verses;
        }

        public ChapterParameter() {
        }

        public Integer getChapterNumber() {
            return chapterNumber;
        }

        public List<VerseParameter> getVerses() {
            return verses;
        }
    }


    public static class VerseParameter {
        private Integer verseNumber;
        private String content;

        public VerseParameter(Integer verseNumber, String content) {
            this.verseNumber = verseNumber;
            this.content = content;
        }

        public VerseParameter() {
        }

        public Integer getVerseNumber() {
            return verseNumber;
        }

        public String getContent() {
            return content;
        }
    }
}
