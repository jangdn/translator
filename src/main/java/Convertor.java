import act.parse.ParameterParser;
import act.processor.ProcessorHandler;
import act.translator.CharArrayTranslator;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.input.InputParagraph;
import model.parameter.InputParameterParagraph;
import model.process.Paragraph;
import model.view.ViewPattern;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Convertor {

    private static final String DEFINED_CONVERT_TARGET = "main-test.json";

    public static void main(String[] args) throws IOException {
        convert(args[0]);
    }

    public static void convert(String title) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = Convertor.class.getClassLoader();
        File file = new File(classLoader.getResource(DEFINED_CONVERT_TARGET).getFile());


        long startTime = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - startTime);
        List<InputParagraph> inputParagraphs = ParameterParser.getInstance()
                .parse(objectMapper.readValue(file, InputParameterParagraph.class));

        ProcessorHandler processorHandler = ProcessorHandler.getInstance();
        List<Paragraph> paragraphs = inputParagraphs.parallelStream()
                .map(inputParagraph -> processorHandler.process(inputParagraph))
                .collect(Collectors.toList());

        System.out.println(System.currentTimeMillis() - startTime);
        StringBuilder paragraphBuilder = new StringBuilder();
        IntStream.range(0, paragraphs.size())
                .forEach(i -> {
                    Optional<Paragraph> beforeParagraph = getBefore(paragraphs, i);
                    Optional<Paragraph> afterParagraph = getAfter(paragraphs, i);
                    Paragraph paragraph = paragraphs.get(i);
                    paragraphBuilder.append(paragraph.toString(beforeParagraph, afterParagraph));
                });
        for (Paragraph paragraph : paragraphs) {
            paragraphBuilder.append(paragraph.toString());
        }

        String paragraphString = paragraphBuilder.toString();
        try (FileWriter myWriter = new FileWriter(title + " view.txt")) {
            myWriter.write(paragraphString);
        }

        System.out.println(System.currentTimeMillis() - startTime);

        String translateParagraph = CharArrayTranslator.translate(paragraphString);

        try (FileWriter myWriter = new FileWriter(title + " braille.txt")) {
            myWriter.write(LineConverter.convert(translateParagraph));
        }
    }

    public static Optional<Paragraph> getBefore(List<Paragraph> paragraphs, int i) {
        if (i > 0) {
            return Optional.of(paragraphs.get(i - 1));
        }
        return Optional.empty();
    }

    public static Optional<Paragraph> getAfter(List<Paragraph> paragraphs, int i) {
        if (i < paragraphs.size() - 2) {
            return Optional.of(paragraphs.get(i + 1));
        }
        return Optional.empty();
    }
}
