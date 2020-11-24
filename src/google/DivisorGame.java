/*
 * Copyright (c) 2020. Yuanchen
 */

package google;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/23
 */
public class DivisorGame {

    public static boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(2));
        System.out.println(divisorGame(3));
        System.out.println(divisorGame(4));
    }
}
