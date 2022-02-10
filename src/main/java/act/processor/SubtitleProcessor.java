package act.processor;

import model.input.SubtitleInputParagraph;
import model.process.SubtitleParagraph;

public class SubtitleProcessor implements Processor<SubtitleInputParagraph> {
    private SubtitleProcessor() {
    }

    private static class LazyHolder {
        public static final SubtitleProcessor INSTANCE = new SubtitleProcessor();
    }

    public static SubtitleProcessor getInstance() {
        return SubtitleProcessor.LazyHolder.INSTANCE;
    }

    @Override
    public SubtitleParagraph process(SubtitleInputParagraph inputParagraph) {
        return new SubtitleParagraph(inputParagraph.getValue());
    }

    @Override
    public Class getMyProcessType() {
        return SubtitleInputParagraph.class;
    }
}
