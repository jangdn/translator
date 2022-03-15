package act.processor.contentchain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FixAndConvertTest {
    @Test
    public void lineRemover() {
        String removedNewLineString = FixStrangeLastNewLine.getInstance().process("is last newLine removed?\n\n\n");

        assertThat(removedNewLineString, is("is last newLine removed?"));
    }
}