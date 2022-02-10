package act.processor.versechain;

import org.apache.commons.lang3.StringUtils;

public class ConvertShapSign implements VerseConvertorChain {
	private VerseConvertorChain nextChain;

	private ConvertShapSign() { }

	private static class LazyHolder {
		public static final ConvertShapSign INSTANCE = new ConvertShapSign();
	}

	public static ConvertShapSign getInstance() {
		return ConvertShapSign.LazyHolder.INSTANCE;
	}

	@Override
	public String process(String value) {
		if (nextChain == null) {
			return StringUtils.remove(value, "#");
		}

		return nextChain.process(StringUtils.remove(value, "#"));
	}

	@Override
	public void setNext(VerseConvertorChain verseConvertorChain) {
		this.nextChain = verseConvertorChain;
	}
}
