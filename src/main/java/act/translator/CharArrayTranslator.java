package act.translator;

import org.apache.commons.lang3.StringUtils;

public class CharArrayTranslator {
    public static String translate(String input) {
        if(input.isEmpty()) {
            return "";
        }

        char beforeValue = input.charAt(0);
        StringBuilder builder = new StringBuilder();
        String romeNum = "";
        appendBraille(builder, beforeValue);
        char[] chars = input.substring(1).toCharArray();
        for (char c : chars) {
            if (isRomeNum(c)) {
                romeNum += c;
                continue;
            }
            if (!StringUtils.isEmpty(romeNum)) {
                translateOnString(romeNum, builder);
                romeNum="";
                continue;
            }
            translateOnChar(c, beforeValue, builder);
            beforeValue = c;
        }
        return builder.toString();
    }

    private static void translateOnString(String romeNum, StringBuilder builder) {
        builder.append(TranslateDictionary.totalDictionaryAsc.get(String.valueOf(romeNum)).getString());
    }

    public static void translateOnChar(char c, char beforeValue, StringBuilder builder) {
        if (isNumber(c)) {
            if (continuouslyNumberEscape(beforeValue, c)) {
                builder.append(TranslateDictionary.totalDictionaryAsc.get(String.valueOf(c)).getString());
                return;
            }
            builder.append(TranslateDictionary.START_NUMBER_SIGN_ASC.getString());
            builder.append(TranslateDictionary.totalDictionaryAsc.get(String.valueOf(c)).getString());
            return;
        }
        if (newLineEscape(c)) {
            builder.append(c);
            return;
        }
        builder.append(TranslateDictionary.totalDictionaryAsc.get(String.valueOf(c)).getString());
    }

    private static boolean isRomeNum(char c) {
        return TranslateDictionary.romeNumberDictionaryAsc.keySet().contains(String.valueOf(c));
    }

    private static boolean newLineEscape(char c) {
        return c == '\n';
    }

    private static void appendBraille(StringBuilder builder, char c) {
        if (isNumber(c)) {
            builder.append(TranslateDictionary.START_NUMBER_SIGN_ASC.getString());
            builder.append(TranslateDictionary.totalDictionaryAsc.get(String.valueOf(c)).getString());
            return ;
        }
        builder.append(TranslateDictionary.totalDictionaryAsc.get(String.valueOf(c)).getString());
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean continuouslyNumberEscape(char beforeValue, char c) {
        return beforeValue >= '0' && beforeValue <= '9' && c >= '0' && c <= '9';
    }
}
