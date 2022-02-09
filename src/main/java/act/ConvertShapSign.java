package act;

import org.apache.commons.lang3.StringUtils;

public class ConvertShapSign implements Processor {
	private ConvertShapSign() {
	}

	private static class LazyHolder {
		public static final ConvertShapSign INSTANCE = new ConvertShapSign();
	}

	public static ConvertShapSign getInstance() {
		return ConvertShapSign.LazyHolder.INSTANCE;
	}

	@Override
	public String process(String value) {
		return StringUtils.remove(value, "#");
	}
}
