package act.processor;

import act.processor.contentchain.*;
import model.input.SummaryInputParagraph;
import model.input.VerseInputParagraph;
import model.process.Paragraph;
import model.process.SummaryParagraph;
import model.view.Summary;

public class SummaryProcessor implements Processor<SummaryInputParagraph>{
    private final ContentConvertorChain startChanContentConvertorChain;

    private SummaryProcessor(ConvertShapSign convertShapSign,
                             ConvertQuoteSign convertQuoteSign,
                             ConvertSquareBrackets convertSquareBrackets,
                             ConvertParenthesisToHyphen convertParenthesisToHyphen,
                             ConvertSemiCloneToRest convertSemiCloneToRest,
                             ConvertHyphenToBaseHyphen convertHyphenToBaseHyphen,
                             FixStrangeString fixStrangeString) {
        this.startChanContentConvertorChain = convertShapSign;
        convertShapSign.setNext(convertQuoteSign);
        convertQuoteSign.setNext(convertSquareBrackets);
        convertSquareBrackets.setNext(convertParenthesisToHyphen);
        convertParenthesisToHyphen.setNext(convertSemiCloneToRest);
        convertSemiCloneToRest.setNext(convertHyphenToBaseHyphen);
        convertHyphenToBaseHyphen.setNext(fixStrangeString);
    }

    private static class LazyHolder {
        public static final SummaryProcessor INSTANCE =
                new SummaryProcessor(ConvertShapSign.getInstance(),
                        ConvertQuoteSign.getInstance(),
                        ConvertSquareBrackets.getInstance(),
                        ConvertParenthesisToHyphen.getInstance(),
                        ConvertSemiCloneToRest.getInstance(),
                        ConvertHyphenToBaseHyphen.getInstance(),
                        FixStrangeString.getInstance());
    }

    public static SummaryProcessor getInstance() {
        return SummaryProcessor.LazyHolder.INSTANCE;
    }

    public Paragraph process(SummaryInputParagraph inputParagraph) {
        return new SummaryParagraph(this.startChanContentConvertorChain.process(inputParagraph.getSubtitle()),
                this.startChanContentConvertorChain.process(inputParagraph.getTitle()));
    }

    @Override
    public Class getMyProcessType() {
        return SummaryInputParagraph.class;
    }
}
