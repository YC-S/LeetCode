package book.laioffer;

import java.util.HashSet;
import java.util.Set;

public class P395_RemoveCertainCharacters {
  public String remove(String input, String t) {
    char[] array = input.toCharArray();
    Set<Character> set = buildSet(t);
    int i = 0, j = 0;
    while (j < array.length) {
      if (!set.contains(array[j])) {
        array[i++] = array[j];
      }
      j++;
    }
    return new String(array, 0, i);
  }

  private Set<Character> buildSet(String t) {
    char[] array = t.toCharArray();
    Set<Character> set = new HashSet<>();
    for (char c : array) set.add(c);
    return set;
  }
}
