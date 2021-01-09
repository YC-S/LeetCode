/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_july;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/15
 */
public class P15ReverseWordsInAString {

  public String reverseWords(String s) {
    String[] words = s.split("\\s+");
    String res = "";
    for (int i = 0; i < words.length; i++) {
      String word = reverse(words[i]).trim();
      res += word.trim() + " ";
    }
    return reverse(res).trim();

  }

  private String reverse(String s) {
    char[] array = s.toCharArray();
    for (int i = 0; i < array.length / 2; i++) {
      char tmp = array[array.length - i - 1];
      array[array.length - i - 1] = array[i];
      array[i] = tmp;
    }
    return new String(array);
  }
}
