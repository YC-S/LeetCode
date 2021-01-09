/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_may;

/**
 * @author shiyuanchen
 * @created 2020/05/02
 * @project LeetCode
 */
public class P2JewelsAndStones {

    public static int numJewelsInStones(String J, String S) {
        char[] j = J.toCharArray();
        char[] s = S.toCharArray();
        int count = 0;
        for (char c : s) {
            for (char c1 : j) {
                count = c == c1 ? count + 1 : count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }

}
