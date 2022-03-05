package model.input;

public class SummaryInputParagraph extends InputParagraph {
	public SummaryInputParagraph(String title, String subtitle) {
		this.title = title;
		this.subtitle = subtitle;
	}

	public String getTitle() {
		return title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	private String title;

	private String subtitle;
}
