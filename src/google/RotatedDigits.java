/*
 * Copyright (c) 2020. Yuanchen
 */

package google;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/12
 */
public class RotatedDigits {

    public static void main(String[] args) {
        RotatedDigits solution = new RotatedDigits();
        System.out.println(solution.rotatedDigits(857));
    }

    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (helper(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean helper(int n) {

        int tmp = n;
        int flip = 0;
        int digit = 0;
        while (tmp != 0) {
            int last = tmp % 10;
            tmp = tmp / 10;
            if (last == 1) {
                last = 1;
            } else if (last == 0) {
                last = 0;
            } else if (last == 2) {
                last = 5;
            } else if (last == 5) {
                last = 2;
            } else if (last == 6) {
                last = 9;
            } else if (last == 9) {
                last = 6;
            } else if (last == 8) {
                last = 8;
            } else {
                return false;
            }
            flip += last * Math.pow(10, digit);
            digit++;
        }
        return flip != n;
    }
}
