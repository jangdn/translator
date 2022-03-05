package act.processor.contentchain;

import org.apache.commons.lang3.StringUtils;

public class ConvertShapSign implements ContentConvertorChain {
	private ContentConvertorChain nextChain;

	private ConvertShapSign() { }

	private static class LazyHolder {
		public static final ConvertShapSign INSTANCE = new ConvertShapSign();
	}

	public static ConvertShapSign getInstance() {
		return ConvertShapSign.LazyHolder.INSTANCE;
	}

	@Override
	public String process(String value) {
		String result = StringUtils.remove(value, "#");

		return nextChain == null ? result : nextChain.process(result);
	}

	@Override
	public void setNext(ContentConvertorChain contentConvertorChain) {
		this.nextChain = contentConvertorChain;
	}
}
