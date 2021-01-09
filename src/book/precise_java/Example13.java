/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/21
 */
public class Example13 {

    public static void main(String[] args) {
        String res = String.format("|%1$s|%1$7s|%1$-7s|", "Oslo");
        System.out.println(res);
    }

}
