package model.process;

import model.view.Chapter;

public class ChapterParagraph extends Paragraph implements Chapter {
	public ChapterParagraph(Integer num) {
		this.num = num;
	}

	public Integer getNum() {
		return num;
	}

	private Integer num;

	@Override
	protected String internalToString() {
		return this.num.toString();
	}
}
