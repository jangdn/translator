package model.process;

import model.view.Outline;

public class OutlineParagraph extends Paragraph implements Outline {
	public OutlineParagraph(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	private String value;

	@Override
	protected String internalToString() {
		return this.value;
	}
}
