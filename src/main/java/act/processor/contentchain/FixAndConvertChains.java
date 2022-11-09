package act.processor.contentchain;

public class FixAndConvertChains {
    private final ContentConvertorChain startChanContentConvertorChain;

    private FixAndConvertChains(ConvertShapSign convertShapSign,
                                ConvertQuoteSign convertQuoteSign,
                                ConvertSquareBrackets convertSquareBrackets,
                                ConvertParenthesisToHyphen convertParenthesisToHyphen,
                                ConvertSemiCloneToRest convertSemiCloneToRest,
                                ConvertHyphenToBaseHyphen convertHyphenToBaseHyphen,
//                                FixStrangeLastNewLine fixStrangeString,
                                FixStrangeString fixStrangeLastNewLine) {
        this.startChanContentConvertorChain = convertShapSign;
        convertShapSign.setNext(convertQuoteSign);
        convertQuoteSign.setNext(convertSquareBrackets);
        convertSquareBrackets.setNext(convertParenthesisToHyphen);
        convertParenthesisToHyphen.setNext(convertSemiCloneToRest);
        convertSemiCloneToRest.setNext(convertHyphenToBaseHyphen);
//        convertHyphenToBaseHyphen.setNext(fixStrangeString);
        convertHyphenToBaseHyphen.setNext(fixStrangeLastNewLine);
    }

    private static class LazyHolder {
        public static final FixAndConvertChains INSTANCE =
                new FixAndConvertChains(ConvertShapSign.getInstance(),
                        ConvertQuoteSign.getInstance(),
                        ConvertSquareBrackets.getInstance(),
                        ConvertParenthesisToHyphen.getInstance(),
                        ConvertSemiCloneToRest.getInstance(),
                        ConvertHyphenToBaseHyphen.getInstance(),
//                        FixStrangeLastNewLine.getInstance(),
                        FixStrangeString.getInstance());
    }

    public static FixAndConvertChains getInstance() {
        return FixAndConvertChains.LazyHolder.INSTANCE;
    }

    public ContentConvertorChain getChain() {
        return this.startChanContentConvertorChain;
    }
}
