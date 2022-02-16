package model.process;

import model.view.Subtitle;

public class SubtitleParagraph extends Paragraph implements Subtitle {
	public SubtitleParagraph(String value) {
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
