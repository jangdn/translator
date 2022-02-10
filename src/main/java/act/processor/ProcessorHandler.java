package act.processor;

import model.input.ChapterInputParagraph;
import model.input.InputParagraph;
import model.process.Paragraph;

import java.util.ArrayList;
import java.util.List;

public class ProcessorHandler {
    private final List<Processor> processors;

    private ProcessorHandler() {
        processors = new ArrayList<>();
        this.processors.add(VerseProcessor.getInstance());
        this.processors.add(ChapterProcessor.getInstance());
        this.processors.add(OutlineProcessor.getInstance());
        this.processors.add(SubtitleProcessor.getInstance());
        this.processors.add(TitleProcessor.getInstance());
    }

    private static class LazyHolder {
        public static final ProcessorHandler INSTANCE = new ProcessorHandler();
    }

    public static ProcessorHandler getInstance() {
        return ProcessorHandler.LazyHolder.INSTANCE;
    }
    public Paragraph process(InputParagraph inputParagraph) {
        for (Processor processor : this.processors) {
            if (processor.getMyProcessType().equals(inputParagraph.getClass())) {
                return processor.process(inputParagraph);
            }
        }
        throw new IllegalArgumentException();
    }


}
