import act.parse.ParameterParser;
import act.processor.ProcessorHandler;
import act.translator.TranslateHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.braille.BrailleParagraph;
import model.input.*;
import model.parameter.InputParameterParagraph;
import model.process.Paragraph;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {

    private static final String DEFINED_CONVERT_TARGET = "main-test.json";

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = Convertor.class.getClassLoader();
        File file = new File(classLoader.getResource(DEFINED_CONVERT_TARGET).getFile());

        List<InputParagraph> inputParagraphs = ParameterParser.getInstance()
                .parse(objectMapper.readValue(file, InputParameterParagraph.class));

        ProcessorHandler processorHandler = ProcessorHandler.getInstance();
        List<Paragraph> paragraphs = inputParagraphs.parallelStream()
                .map(inputParagraph -> processorHandler.process(inputParagraph))
                .collect(Collectors.toList());

        StringBuilder paragraphBuilder = new StringBuilder();
        for (Paragraph paragraph : paragraphs) {
            paragraphBuilder.append(paragraph.toString());
        }

        try(FileWriter myWriter = new FileWriter("sourceParagraphs.txt")) {
            myWriter.write(paragraphBuilder.toString());
        }

        TranslateHandler translateHandler = TranslateHandler.getInstance();
        List<BrailleParagraph> brailleParagraphs = paragraphs.parallelStream()
                .map(paragraph -> translateHandler.translate(paragraph))
                .collect(Collectors.toList());

        StringBuilder brailleBuilder = new StringBuilder();
        for (BrailleParagraph brailleParagraph : brailleParagraphs) {
            brailleBuilder.append(brailleParagraph.toString());
        }

        try(FileWriter myWriter = new FileWriter("brailleParagraphs.txt")) {
            myWriter.write(brailleBuilder.toString());
        }

        System.out.println(brailleParagraphs);

    }
}
