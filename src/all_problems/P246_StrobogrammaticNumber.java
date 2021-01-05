package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/01
 */
public class P246_StrobogrammaticNumber {

  public boolean isStrobogrammatic(String num) {
    // write your code here
    Map<Character, Character> map = new HashMap<Character, Character>();
    map.put('6', '9');
    map.put('9', '6');
    map.put('0', '0');
    map.put('1', '1');
    map.put('8', '8');
    int i = 0;
    int j = num.length() - 1;
    while (i <= j) {
      if (!map.containsKey(num.charAt(i)) || map.get(num.charAt(i)) != num
        .charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
