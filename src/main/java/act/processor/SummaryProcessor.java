package act.processor;

import act.processor.contentchain.*;
import model.input.SummaryInputParagraph;
import model.process.Paragraph;
import model.process.SummaryParagraph;

public class SummaryProcessor implements Processor<SummaryInputParagraph>{
    private final FixAndConvertChains fixAndConvertChains;

    private SummaryProcessor() {
        this.fixAndConvertChains = FixAndConvertChains.getInstance();
    }

    private static class LazyHolder {
        public static final SummaryProcessor INSTANCE = new SummaryProcessor();
    }

    public static SummaryProcessor getInstance() {
        return SummaryProcessor.LazyHolder.INSTANCE;
    }

    public Paragraph process(SummaryInputParagraph inputParagraph) {
        return new SummaryParagraph(this.fixAndConvertChains.getChain().process(inputParagraph.getSubtitle()),
                this.fixAndConvertChains.getChain().process(inputParagraph.getTitle()));
    }

    @Override
    public Class getMyProcessType() {
        return SummaryInputParagraph.class;
    }
}
