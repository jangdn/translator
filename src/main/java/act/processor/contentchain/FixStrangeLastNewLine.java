package act.processor.contentchain;

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
        StringBuilder builder = new StringBuilder();
        builder.append(value);
        String result = removeLastNewLineRecursive(builder, value.length()-1).toString();

        return nextChain == null ? result : nextChain.process(result);
    }

    public static StringBuilder removeLastNewLineRecursive(StringBuilder builder, int index) {
        if (index == -1)
            return builder;

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
