package model.process;

import model.view.Chapter;

public class ChapterParagraph extends Paragraph implements Chapter {
	public ChapterParagraph(String num) {
		this.num = num;
	}

	public String getNum() {
		return num;
	}

	private String num;

	@Override
	protected String internalToString() {
		return this.num.toString();
	}
}
