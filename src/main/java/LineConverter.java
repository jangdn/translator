public class LineConverter {
    private final static Integer START_NUM = 0;
    private final static Integer LINE_NUM = 20;
    private final static Integer SIZE_NUM = 20;

    public static String convert(String str) {
        StringBuilder builder = new StringBuilder();
        int line = 0;
        int num = 0;
        for (char cha : str.toCharArray()) {
            if (line == START_NUM && cha == '\n') {
                continue;
            }
            if (cha == '\n') {
                line++;
                num = 0;
                builder.append(cha);
                continue;
            }
            if (num == SIZE_NUM) {
                line++;
                num = 0;
                builder.append(cha);
                continue;
            }
            builder.append(cha);
            num++;
            if (line == LINE_NUM) {
                line = 0;
                num = 0;
            }
        }
        return builder.toString();
    }

    public static StringBuilder removeLastNewLineRecursive(StringBuilder builder, int index) {
        if (!isNewLine(builder.charAt(index))) {
            return builder;
        }

        return removeLastNewLineRecursive(builder.deleteCharAt(index), index-1);
    }

    private static boolean isNewLine(char c) {
        return c == '\n';
    }
}
