import java.util.HashMap;
import java.util.Map;

public class Transliterator {
	private static Map<Character, String> romanMap;
	
	/*
	 * This function will scan each character and transliterate
	 * it to corresponding value, as described in map
	 */
	public String LatexRoman(String str) {
		StringBuilder temp = new StringBuilder();
		String[] strs = str.trim().split(" ");
		int length = 0;
		for (String st : strs) {
			st += " ";
			length = st.length();
			for (int i = 0; i < length - 1; i++) {
				// if the character is consonant then -a should be added at the end
				// so if the character falls between these characters default -a
				// at the end is added
				if ((st.charAt(i) >= '\u0915' && st.charAt(i) <= '\u093B')
						&& !(st.charAt(i + 1) >= '\u093E' && st.charAt(i + 1) <= '\u094D')) {
					temp.append(romanMap.get(st.charAt(i)) + "a");

				// The text can contain the characters that are not
				// available in map
				// e.g. English words,then they are appended as it is.
				} else if (!romanMap.containsKey(st.charAt(i))) {
					temp.append(st.charAt(i));

				// else we transliterate using map value
				} else {
					temp.append(romanMap.get(st.charAt(i)));
				}
			}
			temp.append(" ");
		}
		return temp.toString();
	}

	// initialize map with all the transliteration values
	{
		romanMap = new HashMap<Character, String>();
		romanMap.put('अ', "a");
		romanMap.put('आ', "aa");
		romanMap.put('ा', "A");
		romanMap.put('इ', "i");
		romanMap.put('ि', "i");
		romanMap.put('ई', "ii");
		romanMap.put('ी', "I");
		romanMap.put('उ', "u");
		romanMap.put('ु', "u");
		romanMap.put('ऊ', "uu");
		romanMap.put('ू', "U");
		romanMap.put('\u090B', ".r"); // ऋ
		romanMap.put('\u0943', ".r"); // ृ
		romanMap.put('\u0960', ".R"); // ॠ
		romanMap.put('\u0944', ".R"); // ॄ
		romanMap.put('\u090C', ".l"); // ऌ
		romanMap.put('\u0962', ".l"); // ॢ
		romanMap.put('\u0961', ".L"); // ॡ
		romanMap.put('\u0963', ".L"); // ॣ
		romanMap.put('ए', "e");
		romanMap.put('े', "e");
		romanMap.put('ऐ', "E");
		romanMap.put('ै', "E");
		romanMap.put('ओ', "o");
		romanMap.put('ो', "o");
		romanMap.put('औ', "au");
		romanMap.put('ौ', "O");
		romanMap.put('्', "");

		// k, kha part
		romanMap.put('क', "k");
		romanMap.put('ख', "K");
		romanMap.put('ग', "g");
		romanMap.put('घ', "G");
		romanMap.put('ङ', "\"n"); //
		romanMap.put('च', "c");
		romanMap.put('छ', "C");
		romanMap.put('ज', "j");
		romanMap.put('झ', "J");
		romanMap.put('ञ', "~n");
		romanMap.put('ट', ".t");
		romanMap.put('ठ', ".T");
		romanMap.put('ड', ".d");
		romanMap.put('ढ', ".D");
		romanMap.put('ण', ".n");
		romanMap.put('त', "t");
		romanMap.put('थ', "T");
		romanMap.put('द', "d");
		romanMap.put('ध', "D");
		romanMap.put('न', "n");
		romanMap.put('प', "p");
		romanMap.put('फ', "P");
		romanMap.put('ब', "b");
		romanMap.put('भ', "B");
		romanMap.put('म', "m");
		romanMap.put('य', "y");
		romanMap.put('र', "r");
		romanMap.put('ल', "l");
		romanMap.put('\u0933', "L"); // ळ
		romanMap.put('व', "v");
		romanMap.put('श', "\"s"); //
		romanMap.put('\u0937', ".s"); // ष
		romanMap.put('स', "s");
		romanMap.put('ह', "h");
		romanMap.put('\u095C', "R"); // ड़
		romanMap.put('\u095D', "Rh"); // ढ़

		// numerals
		romanMap.put('१', "1");
		romanMap.put('२', "2");
		romanMap.put('३', "3");
		romanMap.put('४', "4");
		romanMap.put('५', "5");
		romanMap.put('६', "6");
		romanMap.put('७', "7");
		romanMap.put('८', "8");
		romanMap.put('९', "9");
		romanMap.put('०', "0");

		// other characters
		romanMap.put('\u095E', "f"); // फ़
		romanMap.put('\u095B', "z"); // ज़
		romanMap.put('\u0959', ".K"); // ख़
		romanMap.put('\u095A', ".g"); // ग़
		romanMap.put('\u0958', "q"); // क़
		romanMap.put('ॐ', ".o");
		romanMap.put('\u093D', ".a"); // ऽ
		// romanMap.put('-', "k");
		// romanMap.put('-', "k");
		romanMap.put('ं', "M");
		romanMap.put('ँ', "/");
		romanMap.put('ः', "H");
		romanMap.put('।', "|");
		romanMap.put('॥', "||");
		romanMap.put('\u0970', "@"); // ॰
		romanMap.put('\u0971', "#"); // ॱ
		romanMap.put('.', "..");
	}

}
