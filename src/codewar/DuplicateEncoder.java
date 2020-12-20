/*
 * Copyright (c) 2020. Yuanchen
 */

package codewar;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/16
 */
public class DuplicateEncoder {

    static String encode(String word) {
        StringBuilder sb = new StringBuilder();
        word = word.toLowerCase();
        int[] array = new int[128];
        for (char c : word.toCharArray()) {
            array[c]++;
        }
        for (char c : word.toCharArray()) {
            if (array[c] == 1) {
                sb.append("(");
            } else {
                sb.append(")");
            }
        }
        return sb.toString();
    }
}
