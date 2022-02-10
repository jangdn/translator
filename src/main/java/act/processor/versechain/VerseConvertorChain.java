package act.processor.versechain;

public interface VerseConvertorChain {
	String process(String value);
	void setNext(VerseConvertorChain verseConvertorChain);
}
