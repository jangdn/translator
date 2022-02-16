package act.translator;

import model.braille.BrailleTitleParagraph;
import model.process.TitleParagraph;

public class TitleTranslator implements Translator<TitleParagraph> {
    private TitleTranslator() {
    }

    private static class LazyHolder {
        public static final TitleTranslator INSTANCE = new TitleTranslator();
    }

    public static TitleTranslator getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public BrailleTitleParagraph translate(TitleParagraph paragraph) {
        return new BrailleTitleParagraph(CharArrayTranslator.translate(paragraph.getValue()));
    }

    @Override
    public Class getMyTranslateType() {
        return TitleParagraph.class;
    }
}
