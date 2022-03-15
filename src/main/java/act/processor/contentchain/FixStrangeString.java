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
        StringBuilder builder = new StringBuilder();
        builder.append(value);
        String result = removeLastNewLineRecursive(builder, value.length()-1).toString();

        return nextChain == null ? result : nextChain.process(result);
    }

    public static StringBuilder removeLastNewLineRecursive(StringBuilder builder, int index) {
        if (!isNewLine(builder.charAt(index))) {
            return builder;
        }

        return removeLastNewLineRecursive(builder.deleteCharAt(index), index-1);
    }

    private static boolean isNewLine(char c) {
        return c == '\n';
    }

    @Override
    public void setNext(ContentConvertorChain contentConvertorChain) {
        this.nextChain = contentConvertorChain;
    }
}
