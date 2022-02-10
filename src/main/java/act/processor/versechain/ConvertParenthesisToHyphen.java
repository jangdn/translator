package act.processor.versechain;

import org.apache.commons.lang3.StringUtils;

public class ConvertParenthesisToHyphen implements VerseConvertorChain {
    private VerseConvertorChain nextChain;

    private ConvertParenthesisToHyphen() {
    }

    private static class LazyHolder {
        public static final ConvertParenthesisToHyphen INSTANCE = new ConvertParenthesisToHyphen();
    }

    public static ConvertParenthesisToHyphen getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public String process(String value) {
        if (nextChain == null) {
            return StringUtils.remove(value, "#");
        }

        return nextChain.process(StringUtils.remove(StringUtils.replace(value, "(", "-"), ")"));
    }

    @Override
    public void setNext(VerseConvertorChain verseConvertorChain) {
        this.nextChain = verseConvertorChain;
    }
}
