package act.translator;

import model.braille.BrailleChapterParagraph;
import model.process.ChapterParagraph;

public class ChapterTranslator implements Translator<ChapterParagraph> {
    private ChapterTranslator() {
    }

    private static class LazyHolder {
        public static final ChapterTranslator INSTANCE = new ChapterTranslator();
    }

    public static ChapterTranslator getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public BrailleChapterParagraph translate(ChapterParagraph paragraph) {
        return new BrailleChapterParagraph(CharArrayTranslator.translate(paragraph.getNum().toString()));
    }

    @Override
    public Class getMyProcessType() {
        return ChapterParagraph.class;
    }
}
