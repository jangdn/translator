package act.translator;

import model.braille.BrailleOutlineParagraph;
import model.process.OutlineParagraph;

public class OutlineTranslator implements Translator<OutlineParagraph> {
    private OutlineTranslator() {
    }

    private static class LazyHolder {
        public static final OutlineTranslator INSTANCE = new OutlineTranslator();
    }

    public static OutlineTranslator getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public BrailleOutlineParagraph translate(OutlineParagraph paragraph) {
        return new BrailleOutlineParagraph(CharArrayTranslator.translate(paragraph.getValue()));
    }

    @Override
    public Class getMyTranslateType() {
        return OutlineParagraph.class;
    }
}
