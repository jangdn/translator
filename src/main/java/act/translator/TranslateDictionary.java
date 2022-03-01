package act.translator;

import org.apache.commons.lang3.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TranslateDictionary {
    public static final Map<String, String> totalDictionary = new HashMap<String, String>() {
        {
            put(" ", " ");

            // special sign
            put(".", "\u2832");
            put(",", "\u2802");
            put(":", "\u2812");
            put("\u2013", "\u2824");
            put("!", "\u2816");
            put("?", "\u2822");
            put("[", "\u2820\u2836");
            put("]", "\u2836\u2820");
            put("„", "\u2820\u2826");
            put("“", "\u2834\u2804");

            put("1", "\u2801");
            put("2", "\u2803");
            put("3", "\u2809");
            put("4", "\u2819");
            put("5", "\u2811");
            put("6", "\u280b");
            put("7", "\u281b");
            put("8", "\u2813");
            put("9", "\u280a");
            put("0", "\u281a");

            put("\u0430", "\u2801");
            put("\u04d9", "\u281c");
            put("\u0431", "\u2803");
            put("\u0432", "\u283a");
            put("\u0433", "\u281b");
            put("\u0434", "\u2819");
            put("\u0493", "\u283b");
            put("\u0435", "\u2811");
            put("\u0451", "\u2821");
            put("\u0436", "\u281a");
            put("\u0437", "\u2835");
            put("\u0438", "\u280a");
            put("\u0439", "\u282f");
            put("\u043a", "\u2805");
            put("\u049b", "\u283d");
            put("\u043b", "\u2807");
            put("\u043c", "\u280d");
            put("\u043d", "\u281d");
            put("\u04a3", "\u2829");
            put("\u043e", "\u2815");
            put("\u04e9", "\u2823");
            put("\u043f", "\u280f");
            put("\u0440", "\u2817");
            put("\u0441", "\u280e");
            put("\u0442", "\u281e");
            put("\u04af", "\u280c");
            put("\u0443", "\u2825");
            put("\u045e", "\u2827");
            put("\u0444", "\u280b");
            put("\u0445", "\u2813");
            put("\u04b3", "\u2839");
            put("\u0446", "\u2809");
            put("\u0447", "\u281f");
            put("\u0448", "\u2831");
            put("\u0449", "\u282d");
            put("\u044a", "\u2837");
            put("\u044b", "\u282e");
            put("\u044c", "\u283e");
            put("\u044d", "\u282a");
            put("\u044e", "\u2833");
            put("\u044f", "\u282b");

            put("\u0410", "\u2801");
            put("\u04d8", "\u281c");
            put("\u0411", "\u2803");
            put("\u0412", "\u283a");
            put("\u0413", "\u281b");
            put("\u0414", "\u2819");
            put("\u0492", "\u283b");
            put("\u0415", "\u2811");
            put("\u0401", "\u2821");
            put("\u0416", "\u281a");
            put("\u0417", "\u2835");
            put("\u0418", "\u280a");
            put("\u0419", "\u282f");
            put("\u041a", "\u2805");
            put("\u049a", "\u283d");
            put("\u041b", "\u2807");
            put("\u041c", "\u280d");
            put("\u041d", "\u281d");
            put("\u04a2", "\u2829");
            put("\u041e", "\u2815");
            put("\u04e8", "\u2823");
            put("\u041f", "\u280f");
            put("\u0420", "\u2817");
            put("\u0421", "\u280e");
            put("\u0422", "\u281e");
            put("\u04ae", "\u280c");
            put("\u0423", "\u2825");
            put("\u040e", "\u2827");
            put("\u0424", "\u280b");
            put("\u0425", "\u2813");
            put("\u04b2", "\u2839");
            put("\u0426", "\u2809");
            put("\u0427", "\u281f");
            put("\u0428", "\u2831");
            put("\u0429", "\u282d");
            put("\u042a", "\u2837");
            put("\u042b", "\u282e");
            put("\u042c", "\u283e");
            put("\u042d", "\u282a");
            put("\u042e", "\u2833");
            put("\u042f", "\u282b");
        }
    };

    public static final Map<String, String> specialSignDictionary = new HashMap<String, String>() {
        {
            // special sign
            put(".", "\u2832");
            put(",", "\u2802");
            put(":", "\u2812");
            put("\u2013", "\u2824");
            put("!", "\u2816");
            put("?", "\u2822");
            put("[", "\u2820\u2836");
            put("]", "\u2836\u2820");
            put("„", "\u2820\u2826");
            put("“", "\u2834\u2804");
        }
    };

    public static final String START_NUMBER_SIGN = "\u283c";
    public static final Map<String, String> numberDictionary = new HashMap<String, String>() {
        {
            // number
            put("1", "\u2801");
            put("2", "\u2803");
            put("3", "\u2809");
            put("4", "\u2819");
            put("5", "\u2811");
            put("6", "\u280b");
            put("7", "\u281b");
            put("8", "\u2813");
            put("9", "\u280a");
            put("0", "\u281a");

        }
    };

    public static final String START_BIG_ALPHABET_SIGN = "\u2828";
    public static final Map<String, String> bigAlphabetDictionary = new HashMap<String, String>() {
        {
            // alphabet
            put("\u0430", "\u2801");
            put("\u04d9", "\u281c");
            put("\u0431", "\u2803");
            put("\u0432", "\u283a");
            put("\u0433", "\u281b");
            put("\u0434", "\u2819");
            put("\u0493", "\u283b");
            put("\u0435", "\u2811");
            put("\u0451", "\u2821");
            put("\u0436", "\u281a");
            put("\u0437", "\u2835");
            put("\u0438", "\u280a");
            put("\u0439", "\u282f");
            put("\u043a", "\u2805");
            put("\u049b", "\u283d");
            put("\u043b", "\u2807");
            put("\u043c", "\u280d");
            put("\u043d", "\u281d");
            put("\u04a3", "\u2829");
            put("\u043e", "\u2815");
            put("\u04e9", "\u2823");
            put("\u043f", "\u280f");
            put("\u0440", "\u2817");
            put("\u0441", "\u280e");
            put("\u0442", "\u281e");
            put("\u04af", "\u280c");
            put("\u0443", "\u2825");
            put("\u045e", "\u2827");
            put("\u0444", "\u280b");
            put("\u0445", "\u2813");
            put("\u04b3", "\u2839");
            put("\u0446", "\u2809");
            put("\u0447", "\u281f");
            put("\u0448", "\u2831");
            put("\u0449", "\u282d");
            put("\u044a", "\u2837");
            put("\u044b", "\u282e");
            put("\u044c", "\u283e");
            put("\u044d", "\u282a");
            put("\u044e", "\u2833");
            put("\u044f", "\u282b");
        }
    };
//
//    public static final Map<String, Character> smallAlphabetDictionaryAsc =
//            new HashMap<String, Character>() {
//        {
//            // alphabet
//            put("\u0410", (char) 65);  // А  : ⠁
//            put("\u04d8", (char) 3E); // Ә  : ⠜
//            put("\u0411", (char) );  // Б  : ⠃
//            put("\u0412", (char) );  // В  : ⠺
//            put("\u0413", (char) );  // Г  : ⠛
//            put("\u0414", (char) );  // Д  : ⠙
//            put("\u0492", (char) );  // Ғ  : ⠻
//            put("\u0415", (char) );  // Е  : ⠑
//            put("\u0401", (char) );  // Ё  : ⠡
//            put("\u0416", (char) );  // Ж  : ⠚
//            put("\u0417", (char) );  // З  : ⠵
//            put("\u0418", (char) );  // И  : ⠊
//            put("\u0419", (char) );  // Й  : ⠯
//            put("\u041a", (char) );  // К  : ⠅
//            put("\u049a", (char) );  // Қ  : ⠽
//            put("\u041b", (char) );  // Л  : ⠇
//            put("\u041c", (char) );  // М  : ⠍
//            put("\u041d", (char) );  // Н  : ⠝
//            put("\u04a2", (char) );  // Ң  : ⠩
//            put("\u041e", (char) );  // О  : ⠕
//            put("\u04e8", (char) );  // Ө  : ⠣
//            put("\u041f", (char) );  // П  : ⠏
//            put("\u0420", (char) );  // Р  : ⠗
//            put("\u0421", (char) );  // С  : ⠎
//            put("\u0422", (char) );  // Т  : ⠞
//            put("\u04ae", (char) );  // Ү  : ⠌
//            put("\u0423", (char) );  // У  : ⠥
//            put("\u040e", (char) );  // Ў  : ⠧
//            put("\u0424", (char) );  // Ф  : ⠋
//            put("\u0425", (char) );  // Х  : ⠓
//            put("\u04b2", (char) );  // Ҳ  : ⠹
//            put("\u0426", (char) );  // Ц  : ⠉
//            put("\u0427", (char) );  // Ч  : ⠟
//            put("\u0428", (char) );  // Ш  : ⠱
//            put("\u0429", (char) );  // Щ  : ⠭
//            put("\u042a", (char) );  // Ъ  : ⠷
//            put("\u042b", (char) );  // Ы  : ⠮
//            put("\u042c", (char) );  // Ь  : ⠾
//            put("\u042d", (char) );  // Э  : ⠪
//            put("\u042e", (char) );  // Ю  : ⠳
//            put("\u042f", (char) );  // Я  : ⠫
//        }
//    };

    public static final Map<String, String> smallAlphabetDictionaryUni = new HashMap<String, String>() {
        {
            // alphabet
            put("\u0410", "\u2801");  // А  : ⠁
            put("\u04d8", "\u281c");  // Ә  : ⠜
            put("\u0411", "\u2803");  // Б  : ⠃
            put("\u0412", "\u283a");  // В  : ⠺
            put("\u0413", "\u281b");  // Г  : ⠛
            put("\u0414", "\u2819");  // Д  : ⠙
            put("\u0492", "\u283b");  // Ғ  : ⠻
            put("\u0415", "\u2811");  // Е  : ⠑
            put("\u0401", "\u2821");  // Ё  : ⠡
            put("\u0416", "\u281a");  // Ж  : ⠚
            put("\u0417", "\u2835");  // З  : ⠵
            put("\u0418", "\u280a");  // И  : ⠊
            put("\u0419", "\u282f");  // Й  : ⠯
            put("\u041a", "\u2805");  // К  : ⠅
            put("\u049a", "\u283d");  // Қ  : ⠽
            put("\u041b", "\u2807");  // Л  : ⠇
            put("\u041c", "\u280d");  // М  : ⠍
            put("\u041d", "\u281d");  // Н  : ⠝
            put("\u04a2", "\u2829");  // Ң  : ⠩
            put("\u041e", "\u2815");  // О  : ⠕
            put("\u04e8", "\u2823");  // Ө  : ⠣
            put("\u041f", "\u280f");  // П  : ⠏
            put("\u0420", "\u2817");  // Р  : ⠗
            put("\u0421", "\u280e");  // С  : ⠎
            put("\u0422", "\u281e");  // Т  : ⠞
            put("\u04ae", "\u280c");  // Ү  : ⠌
            put("\u0423", "\u2825");  // У  : ⠥
            put("\u040e", "\u2827");  // Ў  : ⠧
            put("\u0424", "\u280b");  // Ф  : ⠋
            put("\u0425", "\u2813");  // Х  : ⠓
            put("\u04b2", "\u2839");  // Ҳ  : ⠹
            put("\u0426", "\u2809");  // Ц  : ⠉
            put("\u0427", "\u281f");  // Ч  : ⠟
            put("\u0428", "\u2831");  // Ш  : ⠱
            put("\u0429", "\u282d");  // Щ  : ⠭
            put("\u042a", "\u2837");  // Ъ  : ⠷
            put("\u042b", "\u282e");  // Ы  : ⠮
            put("\u042c", "\u283e");  // Ь  : ⠾
            put("\u042d", "\u282a");  // Э  : ⠪
            put("\u042e", "\u2833");  // Ю  : ⠳
            put("\u042f", "\u282b");  // Я  : ⠫
        }
    };

    public static void main(String[] args) throws IOException {
        System.out.println();
        try(FileWriter myWriter = new FileWriter("dictionary.txt")) {
            myWriter.write(StringUtils.join("\u282b", "\n"));
        }
    }
}
