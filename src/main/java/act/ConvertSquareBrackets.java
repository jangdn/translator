package act;

import org.apache.commons.lang3.StringUtils;

import model.input.VerseInputParagraph;

public class ConvertSquareBrackets implements Processor {
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
		return StringUtils.remove(StringUtils.remove(value, "]"), "[");
	}
}
