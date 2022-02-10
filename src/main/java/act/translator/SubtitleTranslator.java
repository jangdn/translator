package act.translator;

import model.braille.BrailleOutlineParagraph;
import model.braille.BrailleSubtitleParagraph;
import model.process.OutlineParagraph;
import model.process.SubtitleParagraph;

public class SubtitleTranslator implements Translator<SubtitleParagraph> {
    private SubtitleTranslator() {
    }

    private static class LazyHolder {
        public static final SubtitleTranslator INSTANCE = new SubtitleTranslator();
    }

    public static SubtitleTranslator getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public BrailleSubtitleParagraph translate(SubtitleParagraph paragraph) {
        return new BrailleSubtitleParagraph(CharArrayTranslator.translate(paragraph.getValue()));
    }

    @Override
    public Class getMyProcessType() {
        return SubtitleParagraph.class;
    }
}
