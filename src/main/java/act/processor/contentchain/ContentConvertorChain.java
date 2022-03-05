package act.processor.contentchain;

public interface ContentConvertorChain {
	String process(String value);
	void setNext(ContentConvertorChain contentConvertorChain);
}
