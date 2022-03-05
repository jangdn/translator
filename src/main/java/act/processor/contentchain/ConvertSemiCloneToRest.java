package act.processor.contentchain;

import org.apache.commons.lang3.StringUtils;

public class ConvertSemiCloneToRest implements ContentConvertorChain {
    private ContentConvertorChain nextChain;

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
        String result = StringUtils.replace(value, ";", ",");

        return nextChain.process(result);
    }

    @Override
    public void setNext(ContentConvertorChain contentConvertorChain) {
        this.nextChain = contentConvertorChain;
    }
}
