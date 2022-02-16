package act.parse;

import model.input.*;
import model.parameter.InputParameterParagraph;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParameterParser {
    private ParameterParser() {
    }

    public List<InputParagraph> parse(InputParameterParagraph parameterParagraph) {
        List<InputParagraph> inputParagraphs = new java.util.ArrayList<>(Collections.emptyList());
        inputParagraphs.add(new TitleInputParagraph(parameterParagraph.getTitle()));
        inputParagraphs.add(new SubtitleInputParagraph(parameterParagraph.getSubtitle()));
        inputParagraphs.add(new OutlineInputParagraph(parameterParagraph.getDescription()));
        for (InputParameterParagraph.ChapterParameter chapter : parameterParagraph.getChapters()) {
            inputParagraphs.add(new ChapterInputParagraph(chapter.getChapterNumber()));
            for (InputParameterParagraph.VerseParameter verse : chapter.getVerses()) {
                inputParagraphs.add(new VerseInputParagraph(verse.getVerseNumber(), verse.getContent()));
            }
        }
        return inputParagraphs;
    }

    private static class LazyHolder {
        public static final ParameterParser INSTANCE = new ParameterParser();
    }

    public static ParameterParser getInstance() {
        return ParameterParser.LazyHolder.INSTANCE;
    }

}
