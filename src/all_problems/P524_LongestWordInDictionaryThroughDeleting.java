package all_problems;

import java.util.Collections;
import java.util.List;

public class P524_LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) : a.compareTo(b));
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray())
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
            if (i == dictWord.length()) return dictWord;
        }
        return "";
    }
}
