package model.braille;

import model.view.Subtitle;

public class BrailleSubtitleParagraph extends BrailleParagraph implements Subtitle {
	public BrailleSubtitleParagraph(String value) {
		this.value = value;
	}

	private String value;

	@Override
	protected String internalToString() {
		return this.value;
	}
}
