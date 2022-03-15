package act.processor.contentchain;

import org.apache.commons.lang3.StringUtils;

public class FixStrangeLastNewLine implements ContentConvertorChain {
    private ContentConvertorChain nextChain;
    private FixStrangeLastNewLine() {
    }

    private static class LazyHolder {
        public static final FixStrangeLastNewLine INSTANCE = new FixStrangeLastNewLine();
    }

    public static FixStrangeLastNewLine getInstance() {
        return FixStrangeLastNewLine.LazyHolder.INSTANCE;
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
