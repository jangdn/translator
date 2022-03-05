package act.processor;

import act.processor.contentchain.*;
import model.input.VerseInputParagraph;
import model.process.VerseParagraph;

public class VerseProcessor implements Processor<VerseInputParagraph> {
    private final ContentConvertorChain startChanContentConvertorChain;

    private VerseProcessor(ConvertShapSign convertShapSign,
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
        public static final VerseProcessor INSTANCE =
                new VerseProcessor(ConvertShapSign.getInstance(),
                        ConvertQuoteSign.getInstance(),
                        ConvertSquareBrackets.getInstance(),
                        ConvertParenthesisToHyphen.getInstance(),
                        ConvertSemiCloneToRest.getInstance(),
                        ConvertHyphenToBaseHyphen.getInstance(),
                        FixStrangeString.getInstance());
    }

    public static VerseProcessor getInstance() {
        return VerseProcessor.LazyHolder.INSTANCE;
    }

    public VerseParagraph process(VerseInputParagraph inputParagraph) {
        return new VerseParagraph(this.startChanContentConvertorChain.process(inputParagraph.getValue()),
                inputParagraph.getNum());
    }

    @Override
    public Class getMyProcessType() {
        return VerseInputParagraph.class;
    }
}
