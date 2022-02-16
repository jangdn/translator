package act.translator;

import act.processor.Processor;
import model.braille.BrailleTitleParagraph;
import model.braille.BrailleVerseParagraph;
import model.input.TitleInputParagraph;
import model.process.TitleParagraph;
import model.process.VerseParagraph;

public class VerseTranslator implements Translator<VerseParagraph> {
    private VerseTranslator() {
    }

    private static class LazyHolder {
        public static final VerseTranslator INSTANCE = new VerseTranslator();
    }

    public static VerseTranslator getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public BrailleVerseParagraph translate(VerseParagraph paragraph) {
        return new BrailleVerseParagraph(CharArrayTranslator.translate(paragraph.getValue()),
                CharArrayTranslator.translate(paragraph.getNum().toString()));
    }

    @Override
    public Class getMyTranslateType() {
        return VerseParagraph.class;
    }
}
