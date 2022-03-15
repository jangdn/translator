package act.processor;

import act.processor.contentchain.*;
import model.input.OutlineInputParagraph;
import model.process.OutlineParagraph;

public class OutlineProcessor implements Processor<OutlineInputParagraph> {
    private final FixAndConvertChains fixAndConvertChains;

    private OutlineProcessor() {
        this.fixAndConvertChains = FixAndConvertChains.getInstance();
    }

    private static class LazyHolder {
        public static final OutlineProcessor INSTANCE = new OutlineProcessor();
    }

    public static OutlineProcessor getInstance() {
        return OutlineProcessor.LazyHolder.INSTANCE;
    }

    @Override
    public OutlineParagraph process(OutlineInputParagraph inputParagraph) {
        return new OutlineParagraph(this.fixAndConvertChains.getChain().process(inputParagraph.getValue()));
    }

    @Override
    public Class getMyProcessType() {
        return OutlineInputParagraph.class;
    }
}
