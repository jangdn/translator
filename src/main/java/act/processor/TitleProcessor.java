package act.processor;

import model.input.TitleInputParagraph;
import model.process.TitleParagraph;

public class TitleProcessor implements Processor<TitleInputParagraph> {
    private TitleProcessor() {
    }

    private static class LazyHolder {
        public static final TitleProcessor INSTANCE = new TitleProcessor();
    }

    public static TitleProcessor getInstance() {
        return TitleProcessor.LazyHolder.INSTANCE;
    }

    @Override
    public TitleParagraph process(TitleInputParagraph inputParagraph) {
        return new TitleParagraph(inputParagraph.getValue());
    }

    @Override
    public Class getMyProcessType() {
        return TitleInputParagraph.class;
    }
}
