package act;

import org.apache.commons.lang3.StringUtils;

public class ConvertParenthesisToHyphen implements Processor {
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
		return StringUtils.remove(StringUtils.replace(value, "(", "-"), ")");
	}
}
