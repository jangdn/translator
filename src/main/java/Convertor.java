import act.parse.ParameterParser;
import act.processor.ProcessorHandler;
import act.translator.CharArrayTranslator;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.input.InputParagraph;
import model.parameter.InputParameterParagraph;
import model.process.Paragraph;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {

    private static final String DEFINED_CONVERT_TARGET = "32JON.json";

    public static void main(String[] args) throws IOException {
        convert();
    }

    public static void convert() throws IOException {
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
        for (Paragraph paragraph : paragraphs) {
            paragraphBuilder.append(paragraph.toString());
        }

        String paragraphString = paragraphBuilder.toString();
        try(FileWriter myWriter = new FileWriter("sourceParagraphs.txt")) {
            myWriter.write(paragraphString);
        }

        System.out.println(System.currentTimeMillis() - startTime);

        String translateParagraph = CharArrayTranslator.translate(paragraphString);

        try(FileWriter myWriter = new FileWriter("brailleParagraphs.txt")) {
            myWriter.write(LineConverter.convert(translateParagraph));
        }
    }
}
