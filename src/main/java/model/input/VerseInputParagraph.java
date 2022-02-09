package model.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import act.*;

public class VerseInputParagraph extends InputParagraph {
	public VerseInputParagraph(Integer num, String value) {
		this.value = value;
		this.num = num;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private String value;
	private Integer num;
	private List<Processor> processors =
		Arrays.asList(ConvertParenthesisToHyphen.getInstance(),
			ConvertShapSign.getInstance(),
			ConvertSemiCloneToRest.getInstance(),
			ConvertShapSign.getInstance(),
			ConvertSquareBrackets.getInstance());

	@Override
	public String toParagraph() {
		this.processVerse();
		return null;
	}

	// TODO 미리 확인해서 processor 돌릴 내용 없으면 패스
	private String processVerse() {
		String result = this.value;
		for (Processor processor : processors) {
			result = processor.process(result);
		}
		return result;
	}
}
