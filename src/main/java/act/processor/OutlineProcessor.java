package act.processor;

import act.processor.contentchain.*;
import model.input.OutlineInputParagraph;
import model.process.OutlineParagraph;

public class OutlineProcessor implements Processor<OutlineInputParagraph> {
    private final ContentConvertorChain startChanContentConvertorChain;

    private OutlineProcessor(ConvertShapSign convertShapSign,
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
        public static final OutlineProcessor INSTANCE =
                new OutlineProcessor(ConvertShapSign.getInstance(),
                        ConvertQuoteSign.getInstance(),
                        ConvertSquareBrackets.getInstance(),
                        ConvertParenthesisToHyphen.getInstance(),
                        ConvertSemiCloneToRest.getInstance(),
                        ConvertHyphenToBaseHyphen.getInstance(),
                        FixStrangeString.getInstance());
    }

    public static OutlineProcessor getInstance() {
        return OutlineProcessor.LazyHolder.INSTANCE;
    }

    @Override
    public OutlineParagraph process(OutlineInputParagraph inputParagraph) {
        return new OutlineParagraph(this.startChanContentConvertorChain.process(inputParagraph.getValue()));
    }

    @Override
    public Class getMyProcessType() {
        return OutlineInputParagraph.class;
    }
}
