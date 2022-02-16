package model.braille;

import model.process.Paragraph;
import model.view.Title;

public class BrailleTitleParagraph extends BrailleParagraph implements Title {
	private String value;

	public BrailleTitleParagraph(String value) {
		this.value = value;
	}


	@Override
	protected String internalToString() {
		return this.value;
	}
}
