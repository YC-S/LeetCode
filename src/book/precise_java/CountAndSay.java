/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/21
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(11));
        System.out.println(countAndSay(1));
    }

    public static String countAndSay(int n) {
        String oldString = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char[] oldChars = oldString.toCharArray();

            for (int i = 0; i < oldChars.length; i++) {
                int count = 1;
                while ((i + 1) < oldChars.length && oldChars[i] == oldChars[i + 1]) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + oldChars[i]);
            }
            oldString = sb.toString();
        }

        return oldString;
    }
}
