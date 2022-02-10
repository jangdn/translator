package act.processor.versechain;

import org.apache.commons.lang3.StringUtils;

public class ConvertSquareBrackets implements VerseConvertorChain {
    private VerseConvertorChain nextChain;

    private ConvertSquareBrackets() {
    }

    private static class LazyHolder {
        public static final ConvertSquareBrackets INSTANCE = new ConvertSquareBrackets();
    }

    public static ConvertSquareBrackets getInstance() {
        return ConvertSquareBrackets.LazyHolder.INSTANCE;
    }

    @Override
    public String process(String value) {
        if (nextChain == null) {
            return StringUtils.remove(value, "#");
        }

        return nextChain.process(StringUtils.remove(StringUtils.remove(value, "]"), "["));
    }

    @Override
    public void setNext(VerseConvertorChain verseConvertorChain) {
        this.nextChain = verseConvertorChain;
    }
}
