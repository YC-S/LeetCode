package leetcode500.p06_string.plan5;

import java.util.ArrayDeque;
import java.util.Deque;

public class P394_DecodeString {
  public String decodeString(String s) {
    StringBuilder currentString = new StringBuilder();
    Deque<Integer> countStack = new ArrayDeque<>();
    Deque<StringBuilder> stringStack = new ArrayDeque<>();
    int i = 0;
    char[] array = s.toCharArray();
    int count = 0;
    while (i < array.length) {
      if (Character.isDigit(array[i])) {
        count = count * 10 + array[i] - '0';
      } else if (array[i] == '[') {
        countStack.offerFirst(count);
        stringStack.offerFirst(currentString);
        currentString = new StringBuilder();
        count = 0;
      } else if (array[i] == ']') {
        StringBuilder decodeString = stringStack.pollFirst();
        for (int j = countStack.pollFirst(); j > 0; j--) {
          decodeString.append(currentString);
        }
        currentString = decodeString;
      } else {
        currentString.append(array[i]);
      }
      i++;
    }
    return currentString.toString();
  }
}
