package act.processor.contentchain;

import org.apache.commons.lang3.StringUtils;

public class ConvertSquareBrackets implements ContentConvertorChain {
    private ContentConvertorChain nextChain;

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
        String result = StringUtils.remove(StringUtils.remove(value, "]"), "[");

		return nextChain == null ? result : nextChain.process(result);
    }

    @Override
    public void setNext(ContentConvertorChain contentConvertorChain) {
        this.nextChain = contentConvertorChain;
    }
}
