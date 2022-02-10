package act.processor;

import act.processor.versechain.*;
import model.input.VerseInputParagraph;
import model.process.VerseParagraph;

public class VerseProcessor implements Processor<VerseInputParagraph>{
    private final VerseConvertorChain startChanVerseConvertorChain;

    private VerseProcessor(ConvertShapSign convertShapSign,
                           ConvertQuoteSign convertQuoteSign,
                           ConvertSquareBrackets convertSquareBrackets,
                           ConvertParenthesisToHyphen convertParenthesisToHyphen,
                           ConvertSemiCloneToRest convertSemiCloneToRest) {
        this.startChanVerseConvertorChain = convertShapSign;
        convertShapSign.setNext(convertQuoteSign);
        convertQuoteSign.setNext(convertSquareBrackets);
        convertSquareBrackets.setNext(convertParenthesisToHyphen);
        convertParenthesisToHyphen.setNext(convertSemiCloneToRest);
    }

    private static class LazyHolder {
        public static final VerseProcessor INSTANCE =
                new VerseProcessor(act.processor.versechain.ConvertShapSign.getInstance(),
                        act.processor.versechain.ConvertQuoteSign.getInstance(),
                        act.processor.versechain.ConvertSquareBrackets.getInstance(),
                        act.processor.versechain.ConvertParenthesisToHyphen.getInstance(),
                        act.processor.versechain.ConvertSemiCloneToRest.getInstance());
    }

    public static VerseProcessor getInstance() {
        return VerseProcessor.LazyHolder.INSTANCE;
    }

    public VerseParagraph process(VerseInputParagraph inputParagraph) {
        return new VerseParagraph(this.startChanVerseConvertorChain.process(inputParagraph.getValue()),
                inputParagraph.getNum());
    }

    @Override
    public Class getMyProcessType() {
        return VerseInputParagraph.class;
    }
}
