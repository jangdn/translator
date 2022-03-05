package act.translator;

import act.translator.character.CharacterElement;
import act.translator.character.CharacterGetter;
import act.translator.character.CharacterList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TranslateDictionary {
    public static final Map<String, String> specialSignDictionaryUni = new HashMap<String, String>() {
        {
            // special sign
            put(".", "\u2832");
            put(",", "\u2802");
            put(":", "\u2812");
            put("–", "\u2824");
            put("-", "\u2824");
            put("!", "\u2816");
            put("?", "\u2822");
            put("[", "\u2820\u2836");
            put("]", "\u2836\u2820");
            put("\u201E", "\u2820\u2826");
            put("\u201C", "\u2834\u2804");
        }
    };
    public static final Map<String, CharacterGetter> specialSignDictionaryAsc = new HashMap<String, CharacterGetter>() {
        {
            // special sign
            put(".", new CharacterElement((char) 0x34)); // ⠲
            put(",", new CharacterElement((char) 0x31)); // ⠂
            put(":", new CharacterElement((char) 0x33)); // ⠒
            put("-", new CharacterElement((char) 0x2D)); // - ⠤
            put("!", new CharacterElement((char) 0x36)); // ⠖
            put("?", new CharacterElement((char) 0x35)); // ⠢
            put("[", new CharacterList((Character[]) Arrays.asList((char) 0x2C, (char) 0x37).toArray())); // ⠠⠶
            put("]", new CharacterList((Character[]) Arrays.asList((char) 0x37, (char) 0x2C).toArray())); // ⠶⠠
            put("\u201E", new CharacterList((Character[]) Arrays.asList((char) 0x2C, (char) 0x38).toArray())); // ⠠⠦
            put("\u201C", new CharacterList((Character[]) Arrays.asList((char) 0x30, (char) 0x27).toArray())); // ⠴⠄
        }
    };

    public static final String START_NUMBER_SIGN = "\u283c";
    public static final CharacterGetter START_NUMBER_SIGN_ASC = new CharacterElement((char) 0x23);
    public static final Map<String, String> numberDictionaryUni = new HashMap<String, String>() {
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
    public static final Map<String, CharacterGetter> numberDictionaryAsc = new HashMap<String, CharacterGetter>() {
        {
            // number
            put("1", new CharacterElement((char) 0x31));
            put("2", new CharacterElement((char) 0x32));
            put("3", new CharacterElement((char) 0x33));
            put("4", new CharacterElement((char) 0x34));
            put("5", new CharacterElement((char) 0x35));
            put("6", new CharacterElement((char) 0x36));
            put("7", new CharacterElement((char) 0x37));
            put("8", new CharacterElement((char) 0x38));
            put("9", new CharacterElement((char) 0x39));
            put("0", new CharacterElement((char) 0x30));

        }
    };


    public static final String START_BIG_ALPHABET_SIGN = "\u2828";
    public static final Map<String, String> bigAlphabetDictionaryUni = new HashMap<String, String>() {
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
    public static final Map<String, CharacterGetter> bigAlphabetDictionaryAsc = new HashMap<String, CharacterGetter>() {
        {
            // alphabet
            put("\u0430", new CharacterElement((char) 0x41));
            put("\u04d9", new CharacterElement((char) 0x3E));
            put("\u0431", new CharacterElement((char) 0x42));
            put("\u0432", new CharacterElement((char) 0x57));
            put("\u0433", new CharacterElement((char) 0x47));
            put("\u0434", new CharacterElement((char) 0x44));
            put("\u0493", new CharacterElement((char) 0x5D));
            put("\u0435", new CharacterElement((char) 0x45));
            put("\u0451", new CharacterElement((char) 0x2A));
            put("\u0436", new CharacterElement((char) 0x4A));
            put("\u0437", new CharacterElement((char) 0x5A));
            put("\u0438", new CharacterElement((char) 0x49));
            put("\u0439", new CharacterElement((char) 0x26));
            put("\u043a", new CharacterElement((char) 0x4B));
            put("\u049b", new CharacterElement((char) 0x59));
            put("\u043b", new CharacterElement((char) 0x4C));
            put("\u043c", new CharacterElement((char) 0x4D));
            put("\u043d", new CharacterElement((char) 0x4E));
            put("\u04a3", new CharacterElement((char) 0x25));
            put("\u043e", new CharacterElement((char) 0x4F));
            put("\u04e9", new CharacterElement((char) 0x3C));
            put("\u043f", new CharacterElement((char) 0x50));
            put("\u0440", new CharacterElement((char) 0x52));
            put("\u0441", new CharacterElement((char) 0x53));
            put("\u0442", new CharacterElement((char) 0x54));
            put("\u04af", new CharacterElement((char) 0x2F));
            put("\u0443", new CharacterElement((char) 0x55));
            put("\u045e", new CharacterElement((char) 0x56));
            put("\u0444", new CharacterElement((char) 0x46));
            put("\u0445", new CharacterElement((char) 0x48));
            put("\u04b3", new CharacterElement((char) 0x3F));
            put("\u0446", new CharacterElement((char) 0x43));
            put("\u0447", new CharacterElement((char) 0x51));
            put("\u0448", new CharacterElement((char) 0x3A));
            put("\u0449", new CharacterElement((char) 0x58));
            put("\u044a", new CharacterElement((char) 0x28));
            put("\u044b", new CharacterElement((char) 0x21));
            put("\u044c", new CharacterElement((char) 0x29));
            put("\u044d", new CharacterElement((char) 0x5B));
            put("\u044e", new CharacterElement((char) 0x5C));
            put("\u044f", new CharacterElement((char) 0x24));
        }
    };


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
    public static final Map<String, CharacterGetter> smallAlphabetDictionaryAsc = new HashMap<String, CharacterGetter>() {
        {
            // alphabet
            put("\u0410", new CharacterElement((char) 0x41));  // А  : ⠁
            put("\u04d8", new CharacterElement((char) 0x3E)); // Ә  : ⠜
            put("\u0411", new CharacterElement((char) 0x42));  // Б  : ⠃
            put("\u0412", new CharacterElement((char) 0x57));  // В  : ⠺
            put("\u0413", new CharacterElement((char) 0x47));  // Г  : ⠛
            put("\u0414", new CharacterElement((char) 0x44));  // Д  : ⠙
            put("\u0492", new CharacterElement((char) 0x5D));  // Ғ  : ⠻
            put("\u0415", new CharacterElement((char) 0x45));  // Е  : ⠑
            put("\u0401", new CharacterElement((char) 0x2A));  // Ё  : ⠡
            put("\u0416", new CharacterElement((char) 0x4A));  // Ж  : ⠚
            put("\u0417", new CharacterElement((char) 0x5A));  // З  : ⠵
            put("\u0418", new CharacterElement((char) 0x49));  // И  : ⠊
            put("\u0419", new CharacterElement((char) 0x26));  // Й  : ⠯
            put("\u041a", new CharacterElement((char) 0x4B));  // К  : ⠅
            put("\u049a", new CharacterElement((char) 0x59));  // Қ  : ⠽
            put("\u041b", new CharacterElement((char) 0x4C));  // Л  : ⠇
            put("\u041c", new CharacterElement((char) 0x4D));  // М  : ⠍
            put("\u041d", new CharacterElement((char) 0x4E));  // Н  : ⠝
            put("\u04a2", new CharacterElement((char) 0x25));  // Ң  : ⠩
            put("\u041e", new CharacterElement((char) 0x4F));  // О  : ⠕
            put("\u04e8", new CharacterElement((char) 0x3C));  // Ө  : ⠣
            put("\u041f", new CharacterElement((char) 0x50));  // П  : ⠏
            put("\u0420", new CharacterElement((char) 0x52));  // Р  : ⠗
            put("\u0421", new CharacterElement((char) 0x53));  // С  : ⠎
            put("\u0422", new CharacterElement((char) 0x54));  // Т  : ⠞
            put("\u04ae", new CharacterElement((char) 0x2F));  // Ү  : ⠌
            put("\u0423", new CharacterElement((char) 0x55));  // У  : ⠥
            put("\u040e", new CharacterElement((char) 0x56));  // Ў  : ⠧
            put("\u0424", new CharacterElement((char) 0x46));  // Ф  : ⠋
            put("\u0425", new CharacterElement((char) 0x48));  // Х  : ⠓
            put("\u04b2", new CharacterElement((char) 0x3F));  // Ҳ  : ⠹
            put("\u0426", new CharacterElement((char) 0x43));  // Ц  : ⠉
            put("\u0427", new CharacterElement((char) 0x51));  // Ч  : ⠟
            put("\u0428", new CharacterElement((char) 0x3A));  // Ш  : ⠱
            put("\u0429", new CharacterElement((char) 0x58));  // Щ  : ⠭
            put("\u042a", new CharacterElement((char) 0x28));  // Ъ  : ⠷
            put("\u042b", new CharacterElement((char) 0x21));  // Ы  : ⠮
            put("\u042c", new CharacterElement((char) 0x29));  // Ь  : ⠾
            put("\u042d", new CharacterElement((char) 0x5B));  // Э  : ⠪
            put("\u042e", new CharacterElement((char) 0x5C));  // Ю  : ⠳
            put("\u042f", new CharacterElement((char) 0x24));  // Я  : ⠫
        }
    };

    public static final Map<String, String> totalDictionary = new HashMap<String, String>() {
        {
            put(" ", " ");
            this.putAll(specialSignDictionaryUni);
            this.putAll(numberDictionaryUni);
            this.putAll(smallAlphabetDictionaryUni);
            this.putAll(bigAlphabetDictionaryUni);
        }
    };
    public static final Map<String, CharacterGetter> totalDictionaryAsc = new HashMap<String, CharacterGetter>() {
        {
            put(" ", new CharacterElement(' '));
            this.putAll(specialSignDictionaryAsc);
            this.putAll(numberDictionaryAsc);
            this.putAll(smallAlphabetDictionaryAsc);
            this.putAll(bigAlphabetDictionaryAsc);
        }
    };
}
