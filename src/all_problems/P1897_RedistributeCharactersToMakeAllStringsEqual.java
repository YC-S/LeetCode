package all_problems;

import java.util.Arrays;

public class P1897_RedistributeCharactersToMakeAllStringsEqual {
  public boolean makeEqual(String[] words) {
    int[] counts = new int[26];
    Arrays.stream(words).forEach(w -> w.chars().forEach(c -> counts[c - 'a']++));
    return Arrays.stream(counts).allMatch(c -> c % words.length == 0);
  }
}
