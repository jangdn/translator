package act.translator;

public class CharArrayTranslator {
    public static String translate(String input) {
        if(input.isEmpty()) {
            return "";
        }

        char beforeValue = input.charAt(0);
        StringBuilder builder = new StringBuilder();
        appendBraille(builder, beforeValue);
        char[] chars = input.substring(1).toCharArray();
        for (char c : chars) {
            if (isNumber(c)) {
                if (isContinuouslyNumber(beforeValue, c)) {
                    builder.append(TranslateDictionary.totalDictionary.get(String.valueOf(c)));
                    continue;
                }
                builder.append(TranslateDictionary.START_NUMBER_SIGN);
                builder.append(TranslateDictionary.totalDictionary.get(String.valueOf(c)));
            }
            builder.append(TranslateDictionary.totalDictionary.get(String.valueOf(c)));
        }
        return builder.toString();
    }

    private static void appendBraille(StringBuilder builder, char c) {
        if (isNumber(c)) {
            builder.append(TranslateDictionary.START_NUMBER_SIGN);
            builder.append(TranslateDictionary.totalDictionary.get(String.valueOf(c)));
            return ;
        }
        builder.append(TranslateDictionary.totalDictionary.get(String.valueOf(c)));
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isContinuouslyNumber(char beforeValue, char c) {
        return beforeValue >= '0' && beforeValue <= '9' && c >= '0' && c <= '9';
    }
}
