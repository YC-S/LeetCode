package leetcode500.p06_string.plan1;

import java.util.HashMap;
import java.util.Map;

public class P13_RomanToInteger {
  public int romanToInt(String s) {
    if (s.length() == 0) return 0;
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    int res = 0;
    char[] arr = s.toCharArray();
    int prev = map.get(arr[0]);
    res += prev;
    if (s.length() == 1) return res;
    int i = 1;
    while (i < arr.length) {
      int cur = map.get(arr[i]);
      if (prev < cur) {
        res = res + cur - prev * 2;
      } else {
        res += cur;
      }
      prev = cur;
      i++;
    }
    return res;
  }
}
