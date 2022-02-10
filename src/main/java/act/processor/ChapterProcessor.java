package act.processor;

import act.processor.versechain.*;
import model.input.ChapterInputParagraph;
import model.process.ChapterParagraph;

public class ChapterProcessor implements Processor<ChapterInputParagraph> {
    private ChapterProcessor() {
    }

    private static class LazyHolder {
        public static final ChapterProcessor INSTANCE = new ChapterProcessor();
    }

    public static ChapterProcessor getInstance() {
        return ChapterProcessor.LazyHolder.INSTANCE;
    }

    @Override
    public ChapterParagraph process(ChapterInputParagraph inputParagraph) {
        return new ChapterParagraph(inputParagraph.getNum());
    }

    @Override
    public Class getMyProcessType() {
        return ChapterInputParagraph.class;
    }
}
