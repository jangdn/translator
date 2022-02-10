package act.processor.versechain;

import org.apache.commons.lang3.StringUtils;

public class ConvertQuoteSign implements VerseConvertorChain {

	private VerseConvertorChain nextChain;

	private ConvertQuoteSign() { }

	private static class LazyHolder {
		public static final ConvertQuoteSign INSTANCE = new ConvertQuoteSign();
	}

	public static ConvertQuoteSign getInstance() {
		return ConvertQuoteSign.LazyHolder.INSTANCE;
	}

	@Override
	public String process(String value) {

		if (nextChain == null) {
			return StringUtils.remove(value, "#");
		}

		return nextChain.process(StringUtils.remove(StringUtils.remove(value, "«"), ")"));
	}

	@Override
	public void setNext(VerseConvertorChain verseConvertorChain) {
		this.nextChain = verseConvertorChain;
	}
}
