package model.braille;

import model.view.Chapter;

public class BrailleChapterParagraph extends BrailleParagraph implements Chapter {
	public BrailleChapterParagraph(String num) {
		this.num = num;
	}

	private String num;

	@Override
	protected String internalToString() {
		return num.toString();
	}
}
