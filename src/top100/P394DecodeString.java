/*
 * Copyright (c) 2020. Yuanchen
 */

package top100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/08
 */
public class P394DecodeString {

  public String decodeString(String s) {
    Deque<String> strings = new ArrayDeque<>();
    Deque<Integer> mult = new ArrayDeque<>();
    StringBuilder res = new StringBuilder();
    int idx = 0;

    while (idx < s.length()) {
      //if find a digit we need to build it up to the exact count
      if (Character.isDigit(s.charAt(idx))) {
        int count = 0;
        while (Character.isDigit(s.charAt(idx))) {
          count = (10 * count) + (s.charAt(idx) - '0');
          idx++;
        }
        mult.push(count);
        //We need to save the current state of res when we hit an opening brace
        //don't forget to reset res as well.
      } else if (s.charAt(idx) == '[') {
        strings.push(res.toString());
        res.setLength(0);
        idx++;
        //we know that we've jus finished traversing an encoded sequence
        //so we need to print res k times
      } else if (s.charAt(idx) == ']') {
        int count = mult.pop();
        StringBuilder temp = new StringBuilder(strings.pop());
        for (int i = 0; i < count; i++) {
          temp.append(res.toString());
        }
        res = temp;
        idx++;
        //we arbitrarily add any letter to res when we see it
      } else {
        res.append(s.charAt(idx));
        idx++;
      }
    }
    return res.toString();
  }
}
