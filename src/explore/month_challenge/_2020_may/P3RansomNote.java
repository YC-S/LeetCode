/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_may;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @created 2020/05/03
 * @project LeetCode
 */
public class P3RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        char[] magazineArray = magazine.toCharArray();
        for (char c : magazineArray) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> ransomNoteMap = new HashMap<>();
        char[] ransomNoteArray = ransomNote.toCharArray();
        for (char c : ransomNoteArray) {
            ransomNoteMap.put(c, ransomNoteMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : ransomNoteMap.entrySet()) {
            if (!magazineMap.containsKey(entry.getKey())
                || magazineMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }
}
