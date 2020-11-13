/*
 * Copyright (c) 2020. Yuanchen
 */

package algocast;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/12
 */
public class P153NumSqauresDP {

    public static void main(String[] args) {
        P153NumSqauresDP solution = new P153NumSqauresDP();
        System.out.println(solution.numSquaresMath(12));
        System.out.println(solution.numSquaresDP(12));
    }

    //    给一个正整数，计算最少可以分解成多少个完全平方数的和。
//    完全平方数是1， 4， 9， 16，。。。
//
//        5=1+4
//        12=4+4+4
//
//    OK了
    public int numSquaresDP(int n) {
        int[] d = new int[n + 1];
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            d[i] = i;
            for (int j = 1; j * j <= i; j++) {
                d[i] = Math.min(d[i], d[i - j * j] + 1);
            }
        }
        return d[n];
    }

    // helper check if 完全平方数字 O（1）
    private boolean isSquare(int n) {
        int x = (int) Math.sqrt(n);
        return x * x == n;


    }

    // 主方法 4^a*(8b+7) != 0 => 3
    public int numSquaresMath(int n) {
        if (isSquare(n)) {
            return 1;
        }
        for (int i = 1; i * i <= n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 != 7) {
            return 3;
        }
        return 4;
    }

}
