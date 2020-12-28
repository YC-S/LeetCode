package contest.leetcode.单周赛._221;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1 {
    public boolean halvesAreAlike(String s) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int count1 = 0;
        int count2 = 0;
        for (char c : s1.toCharArray()) {
            if (set.contains(c)) {
                count1++;
            }
        }
        for (char c : s2.toCharArray()) {
            if (set.contains(c)) {
                count2++;
            }
        }
        return count1 == count2;
    }
}
