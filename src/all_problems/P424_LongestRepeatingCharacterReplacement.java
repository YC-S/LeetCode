package all_problems;

import java.util.HashMap;
import java.util.Map;

public class P424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int answer = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int x = i;
        int diff = 0;
        int maxFrequency = 0;
        while (x < s.length()) {
            if (map.containsKey(s.charAt(x))) {
                map.put(s.charAt(x), map.get(s.charAt(x)) + 1);
            } else {
                map.put(s.charAt(x), 1);
            }
            maxFrequency = Math.max(maxFrequency, map.get(s.charAt(x)));
            diff = ((x - i) + 1) - maxFrequency;
            if (diff <= k) {
                answer = Math.max((x - i) + 1, answer);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
            x++;
        }
        return answer;
    }
}
