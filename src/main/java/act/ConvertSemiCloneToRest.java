package act;

import org.apache.commons.lang3.StringUtils;

public class ConvertSemiCloneToRest implements Processor {
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
		return StringUtils.replace(value, ";", ",");
	}
}
