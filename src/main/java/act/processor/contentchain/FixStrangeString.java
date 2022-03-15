package act.processor.contentchain;

import org.apache.commons.lang3.StringUtils;

public class FixStrangeString implements ContentConvertorChain {
    private ContentConvertorChain nextChain;
    private FixStrangeString() {
    }

    private static class LazyHolder {
        public static final FixStrangeString INSTANCE = new FixStrangeString();
    }

    public static FixStrangeString getInstance() {
        return FixStrangeString.LazyHolder.INSTANCE;
    }

    @Override
    public String process(String value) {
        String result = StringUtils.remove(value, "\u201E");

        return nextChain == null ? result : nextChain.process(result);
    }

    @Override
    public void setNext(ContentConvertorChain contentConvertorChain) {
        this.nextChain = contentConvertorChain;
    }
}
