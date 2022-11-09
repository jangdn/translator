package act.processor.contentchain;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FixAndConvertTest {
    @Test
    public void convertCorrect() {
        ContentConvertorChain chain = FixAndConvertChains.getInstance().getChain();

        String convertString = chain.process("– () «» ; # []");

        String targetString = "\u002D \u002D  ,  ";
        assertThat(convertString, is(targetString));
    }

    @Test
    public void convertHyphenToBaseHyphen() {
        String convertString = ConvertHyphenToBaseHyphen.getInstance().process("–");

        String targetString = StringUtils.replace(convertString, "\u2013", "\u002D");

        assertThat(convertString, is(targetString));

        assertThat(convertString, is("\u002D"));
    }

    @Test
    public void lineRemover() {
        String removedNewLineString = FixStrangeLastNewLine.getInstance().process("is last newLine removed?\n\n\n");

        assertThat(removedNewLineString, is("is last newLine removed?"));
    }
}