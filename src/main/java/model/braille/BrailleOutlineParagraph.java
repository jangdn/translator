package model.braille;

import model.view.Outline;

public class BrailleOutlineParagraph extends BrailleParagraph implements Outline {
	public BrailleOutlineParagraph(String value) {
		this.value = value;
	}

	private String value;

	@Override
	protected String internalToString() {
		return this.value;
	}
}
