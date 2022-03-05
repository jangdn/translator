package act.processor.contentchain;

import org.apache.commons.lang3.StringUtils;

public class ConvertHyphenToBaseHyphen implements ContentConvertorChain {
    private ContentConvertorChain nextChain;
    private ConvertHyphenToBaseHyphen() {
    }

    private static class LazyHolder {
        public static final ConvertHyphenToBaseHyphen INSTANCE = new ConvertHyphenToBaseHyphen();
    }

    public static ConvertHyphenToBaseHyphen getInstance() {
        return ConvertHyphenToBaseHyphen.LazyHolder.INSTANCE;
    }

    @Override
    public String process(String value) {
        String result = StringUtils.replace(value, "\u2013", "\u002D");

        return nextChain == null ? result : nextChain.process(result);
    }

    @Override
    public void setNext(ContentConvertorChain contentConvertorChain) {
        this.nextChain = contentConvertorChain;
    }
}
