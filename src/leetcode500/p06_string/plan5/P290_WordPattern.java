package leetcode500.p06_string.plan5;

import java.util.HashMap;
import java.util.Map;

public class P290_WordPattern {
  public boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    if (pattern.length() != words.length) return false;
    Map<Character, String> map = new HashMap<>();
    Map<String, Character> map2 = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      if (!map.containsKey(pattern.charAt(i))) {
        map.put(pattern.charAt(i), words[i]);
      } else {
        if (!map.get(pattern.charAt(i)).equals(words[i])) return false;
      }
    }
    for (int i = 0; i < pattern.length(); i++) {
      if (!map2.containsKey(words[i])) {
        map2.put(words[i], pattern.charAt(i));
      } else {
        if (map2.get(words[i]) != pattern.charAt(i)) return false;
      }
    }
    return true;
  }
}
