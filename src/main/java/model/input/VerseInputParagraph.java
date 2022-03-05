package model.input;

public class VerseInputParagraph extends InputParagraph {
	public VerseInputParagraph(String num, String value) {
		this.value = value;
		this.num = num;
	}

	public String getValue() {
		return value;
	}

	public String getNum() {
		return num;
	}

	private String value;

	private String num;
}
