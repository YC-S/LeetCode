/*
 * Copyright (c) 2020. Yuanchen
 */

package may_challenge;

/**
 * @author shiyuanchen
 * @created 2020/05/04
 * @project LeetCode
 */
public class P4NumberComplement {

    public static int findComplement(int num) {
        int flag = num >= 0 ? 1 : -1;
        num = Math.abs(num);
        int res = 0;
        int bit = 0;
        while (num != 0) {
            int tmp = num & 1;
            res += tmp == 1 ? 0 : 1 << bit;
            bit++;
            num >>= 1;
        }
        return res * flag;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
        System.out.println(findComplement(2));
        System.out.println();
    }
}
