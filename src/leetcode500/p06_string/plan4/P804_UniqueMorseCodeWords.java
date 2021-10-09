package leetcode500.p06_string.plan4;

import java.util.HashSet;
import java.util.Set;

public class P804_UniqueMorseCodeWords {
  public int uniqueMorseRepresentations(String[] words) {
    String[] arr = {
      ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
      "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };
    Set<String> set = new HashSet<>();
    for (String word : words) {
      StringBuilder sb = new StringBuilder();
      for (char c : word.toCharArray()) {
        sb.append(arr[c - 'a']);
      }
      set.add(sb.toString());
    }
    return set.size();
  }
}
