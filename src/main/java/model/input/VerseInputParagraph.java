package model.input;

public class VerseInputParagraph extends InputParagraph {
	public VerseInputParagraph(Integer num, String value) {
		this.value = value;
		this.num = num;
	}

	public String getValue() {
		return value;
	}

	public Integer getNum() {
		return num;
	}

	private String value;

	private Integer num;
}
