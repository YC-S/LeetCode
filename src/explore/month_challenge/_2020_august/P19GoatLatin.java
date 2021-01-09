/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_august;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/19
 */
public class P19GoatLatin {

  public static String toGoatLatin(String S) {
    String[] strings = S.split(" ");
    List<String> list = new ArrayList<>();
    for (int i = 0; i < strings.length; i++) {
      String first_char = strings[i].substring(0, 1).toLowerCase();
      if (first_char.equals("a") || first_char.equals("e") || first_char
        .equals("i")
        || first_char.equals("o") || first_char.equals("u")) {
        String tmp = strings[i] + "ma";
        for (int j = 0; j <= i; j++) {
          tmp += "a";
        }
        list.add(tmp);
      } else {
        String tmp = strings[i].substring(1) + strings[i].charAt(0) + "ma";
        for (int j = 0; j <= i; j++) {
          tmp += "a";
        }
        list.add(tmp);
      }
    }
    String result = "";
    for (int i = 0; i < list.size(); i++) {
      if (i != list.size() - 1) {
        result += list.get(i);
        result += " ";
      } else {
        result += list.get(i);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out
      .println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
  }
}
