package act.processor;

import model.input.OutlineInputParagraph;
import model.process.OutlineParagraph;

public class OutlineProcessor implements Processor<OutlineInputParagraph> {
    private OutlineProcessor() {
    }

    private static class LazyHolder {
        public static final OutlineProcessor INSTANCE = new OutlineProcessor();
    }

    public static OutlineProcessor getInstance() {
        return OutlineProcessor.LazyHolder.INSTANCE;
    }

    @Override
    public OutlineParagraph process(OutlineInputParagraph inputParagraph) {
        return new OutlineParagraph(inputParagraph.getValue());
    }

    @Override
    public Class getMyProcessType() {
        return OutlineInputParagraph.class;
    }
}
