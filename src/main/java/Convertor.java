import java.util.ArrayList;
import java.util.List;

import act.Parser;
import act.Processor;
import model.input.*;

public class Convertor {
	public static void main(String[] args) {
		Parser parser = new Parser();
		List<InputParagraph> inputParagraphs = new ArrayList<InputParagraph>();
		inputParagraphs.add(new TitleInputParagraph("마가복음"));
		inputParagraphs.add(new OutlineInputParagraph("마가복음은 이러저러하다."));
		inputParagraphs.add(new ChapterInputParagraph(1));
		inputParagraphs.add(new VerseInputParagraph(1, "하나님의 아들 예수 그리스도 복음의 시작이라"));
		inputParagraphs.add(new VerseInputParagraph(2, "선지자 이사야의 글에 보라 내가 내 사자를 네 앞에 보내노니 저가 네 길을 예비하리라"));

		Processor processor = new Processor();
		processor.
	}
}
