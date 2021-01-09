/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/22
 */
public class Example21 {

    static String replaceCharChar(String s, char c1, char c2) {
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c1) {
                res[i] = c2;
            } else {
                res[i] = s.charAt(i);
            }
        }
        return new String(res);
    }


    public static void main(String[] args) {
        System.out.println(replaceCharChar("Hello", 'e', 'o'));
    }
}
