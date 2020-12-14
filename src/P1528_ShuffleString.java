/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/29
 */
public class P1528_ShuffleString {

    public static void main(String[] args) {
        P1528_ShuffleString solution = new P1528_ShuffleString();
        String s = "codeleet";
        int[] indices = new int[]{4, 5, 6, 7, 0, 2, 1, 3};
        String s1 = "abc";
        int[] indices2 = {0, 1, 2};
        String s2 = "aiohn";
        int[] indices3 = {3, 1, 4, 2, 0};
        System.out.println(solution.restoreString(s, indices));
    System.out.println(solution.restoreString(s1, indices2));
    System.out.println(solution.restoreString(s2, indices3));
  }

  public String restoreString(String s, int[] indices) {
    StringBuilder str = new StringBuilder();
    str.setLength(s.length());

    for (int i = 0; i < str.length(); i++) {
      str.setCharAt(indices[i], s.charAt(i));
    }

    return str.toString();
  }
}
