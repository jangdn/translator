package act.processor.versechain;

import org.apache.commons.lang3.StringUtils;

public class ConvertSemiCloneToRest implements VerseConvertorChain {
    private VerseConvertorChain nextChain;

    private ConvertSemiCloneToRest() {
    }

    private static class LazyHolder {
        public static final ConvertSemiCloneToRest INSTANCE = new ConvertSemiCloneToRest();
    }

    public static ConvertSemiCloneToRest getInstance() {
        return ConvertSemiCloneToRest.LazyHolder.INSTANCE;
    }

    @Override
    public String process(String value) {
        if (nextChain == null) {
            return StringUtils.remove(value, "#");
        }

        return nextChain.process(StringUtils.replace(value, ";", ","));
    }

    @Override
    public void setNext(VerseConvertorChain verseConvertorChain) {
        this.nextChain = verseConvertorChain;
    }
}
