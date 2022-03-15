package act.processor.contentchain;

import act.processor.OutlineProcessor;

public class FixAndConvertChains {
    private final ContentConvertorChain startChanContentConvertorChain;

    private FixAndConvertChains(ConvertShapSign convertShapSign,
                                ConvertQuoteSign convertQuoteSign,
                                ConvertSquareBrackets convertSquareBrackets,
                                ConvertParenthesisToHyphen convertParenthesisToHyphen,
                                ConvertSemiCloneToRest convertSemiCloneToRest,
                                ConvertHyphenToBaseHyphen convertHyphenToBaseHyphen,
                                FixStrangeString fixStrangeString,
                                FixStrangeLastNewLine fixStrangeLastNewLine) {
        this.startChanContentConvertorChain = convertShapSign;
        convertShapSign.setNext(convertQuoteSign);
        convertQuoteSign.setNext(convertSquareBrackets);
        convertSquareBrackets.setNext(convertParenthesisToHyphen);
        convertParenthesisToHyphen.setNext(convertSemiCloneToRest);
        convertSemiCloneToRest.setNext(convertHyphenToBaseHyphen);
        convertHyphenToBaseHyphen.setNext(fixStrangeString);
        fixStrangeString.setNext(fixStrangeLastNewLine);
    }

    private static class LazyHolder {
        public static final FixAndConvertChains INSTANCE =
                new FixAndConvertChains(ConvertShapSign.getInstance(),
                        ConvertQuoteSign.getInstance(),
                        ConvertSquareBrackets.getInstance(),
                        ConvertParenthesisToHyphen.getInstance(),
                        ConvertSemiCloneToRest.getInstance(),
                        ConvertHyphenToBaseHyphen.getInstance(),
                        FixStrangeString.getInstance(),
                        FixStrangeLastNewLine.getInstance());
    }

    public static FixAndConvertChains getInstance() {
        return FixAndConvertChains.LazyHolder.INSTANCE;
    }

    public ContentConvertorChain getChain() {
        return this.startChanContentConvertorChain;
    }
}
