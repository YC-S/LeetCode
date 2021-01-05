package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/29
 */
public class P1668_MaximumRepeatingSubstring {

    public static int maxRepeating(String sequence, String word) {
        String find = "";
        while (sequence.contains(find)) find += word;
        return (find.length() - word.length()) / word.length();
    }

    public static void main(String[] args) {
        System.out.println(maxRepeating("ababc", "ab"));
        System.out.println(maxRepeating("a", "a"));
    }

}
