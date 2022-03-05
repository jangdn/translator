package act.processor.contentchain;

import org.apache.commons.lang3.StringUtils;

public class ConvertParenthesisToHyphen implements ContentConvertorChain {
    private ContentConvertorChain nextChain;

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
        String result = StringUtils.remove(StringUtils.replace(value, "(", "-"), ")");

        return nextChain == null ? result : nextChain.process(result);
    }

    @Override
    public void setNext(ContentConvertorChain contentConvertorChain) {
        this.nextChain = contentConvertorChain;
    }
}
