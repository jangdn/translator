package act.processor.contentchain;

import org.apache.commons.lang3.StringUtils;

public class ConvertQuoteSign implements ContentConvertorChain {

	private ContentConvertorChain nextChain;

	private ConvertQuoteSign() { }

	private static class LazyHolder {
		public static final ConvertQuoteSign INSTANCE = new ConvertQuoteSign();
	}

	public static ConvertQuoteSign getInstance() {
		return ConvertQuoteSign.LazyHolder.INSTANCE;
	}

	@Override
	public String process(String value) {
		String result = StringUtils.remove(StringUtils.remove(value, "\u00AB"), "\u00BB");

		return nextChain == null ? result : nextChain.process(result);
	}

	@Override
	public void setNext(ContentConvertorChain contentConvertorChain) {
		this.nextChain = contentConvertorChain;
	}
}
