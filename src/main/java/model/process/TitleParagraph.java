package model.process;

import model.view.Title;

public class TitleParagraph extends Paragraph implements Title {
	public String getValue() {
		return value;
	}

	private String value;

	public TitleParagraph(String value) {
		this.value = value;
	}

	@Override
	protected String internalToString() {
		return this.value;
	}
}
