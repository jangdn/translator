package act;

import org.apache.commons.lang3.StringUtils;

public class ConvertQuoteSign implements Processor {
	private ConvertQuoteSign() {
	}

	private static class LazyHolder {
		public static final ConvertQuoteSign INSTANCE = new ConvertQuoteSign();
	}

	public static ConvertQuoteSign getInstance() {
		return ConvertQuoteSign.LazyHolder.INSTANCE;
	}

	@Override
	public String process(String value) {
		return StringUtils.remove(StringUtils.remove(value, "«"), ")");
	}
}
