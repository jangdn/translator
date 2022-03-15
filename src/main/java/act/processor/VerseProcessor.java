package act.processor;

import act.processor.contentchain.*;
import model.input.VerseInputParagraph;
import model.process.VerseParagraph;

public class VerseProcessor implements Processor<VerseInputParagraph> {
    private final FixAndConvertChains fixAndConvertChains;

    private VerseProcessor(){
        this.fixAndConvertChains = FixAndConvertChains.getInstance();
    }

    private static class LazyHolder {
        public static final VerseProcessor INSTANCE = new VerseProcessor();
    }

    public static VerseProcessor getInstance() {
        return VerseProcessor.LazyHolder.INSTANCE;
    }

    public VerseParagraph process(VerseInputParagraph inputParagraph) {
        return new VerseParagraph(this.fixAndConvertChains.getChain().process(inputParagraph.getValue()),
                inputParagraph.getNum());
    }

    @Override
    public Class getMyProcessType() {
        return VerseInputParagraph.class;
    }
}
