package all_problems;

import java.util.HashSet;
import java.util.Set;

public class P1100_FindKlengthSubstringsWithNoRepeatedCharacters {
    public int numKLenSubstrNoRepeats(String S, int K) {
        Set<Character> cur = new HashSet<>();
        int res = 0, i = 0;
        for (int j = 0; j < S.length(); ++j) {
            while (cur.contains(S.charAt(j)))
                cur.remove(S.charAt(i++));
            cur.add(S.charAt(j));
            res += j - i + 1 >= K ? 1 : 0;
        }
        return res;
    }
}
