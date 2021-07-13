package book.laioffer;

import java.util.HashMap;
import java.util.Map;

public class P253_LongestSubstringWithoutRepeatingCharacters {
  public static int longest(String input) {
    Map<Character, Integer> map = new HashMap<>();
    int max = 0;
    char[] array = input.toCharArray();
    int left = 0;
    for (int i = 0; i < array.length; i++) {
      if (!map.containsKey(array[i])) {
        map.put(array[i], 1);
      } else {
        int index = input.indexOf(array[i], left);
        for (int j = left; j < index; j++) {
          map.remove(input.charAt(j));
        }
        left = index + 1;
      }
      max = Math.max(max, map.size());
    }
    return max;
  }

  public static void main(String[] args) {
    //    System.out.println(longest("bcdfbd"));
    System.out.println(longest("abcabcbbcda"));
    //    System.out.println(longest("aaaaa"));
  }
  // bcdfbd
  // bcdf
  // i   b
}
