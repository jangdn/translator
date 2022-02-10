package act.translator;

import act.processor.*;
import model.braille.BrailleParagraph;
import model.input.InputParagraph;
import model.process.Paragraph;

import java.util.ArrayList;
import java.util.List;

public class TranslateHandler {
	private final List<Translator> translators;

	private TranslateHandler() {
		translators = new ArrayList<>();
		this.translators.add(VerseTranslator.getInstance());
		this.translators.add(ChapterTranslator.getInstance());
		this.translators.add(OutlineTranslator.getInstance());
		this.translators.add(SubtitleTranslator.getInstance());
		this.translators.add(TitleTranslator.getInstance());
	}

	private static class LazyHolder {
		public static final TranslateHandler INSTANCE = new TranslateHandler();
	}

	public static TranslateHandler getInstance() {
		return TranslateHandler.LazyHolder.INSTANCE;
	}

	public BrailleParagraph translate(Paragraph paragraph) {
		for (Translator translator : this.translators) {
			if (translator.getMyProcessType().equals(paragraph.getClass())) {
				return translator.translate(paragraph);
			}
		}
		throw new IllegalArgumentException();
	}
}
