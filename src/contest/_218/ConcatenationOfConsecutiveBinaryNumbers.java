/*
 * Copyright (c) 2020. Yuanchen
 */

package contest._218;

import java.math.BigDecimal;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/05
 */
public class ConcatenationOfConsecutiveBinaryNumbers {
    /*
     * Copyright (c) 2020. Yuanchen
     */


    public static int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            sb.append(binaryNumber(i));
        }
        BigDecimal res = digitalNumber(sb);
        BigDecimal modulus = BigDecimal.valueOf(Math.pow(10, 9) + 7);
        BigDecimal remainder = res.remainder(modulus);
        return remainder.intValue();
    }

    private static String binaryNumber(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int last = n % 2;
            n /= 2;
            sb.append(last);
        }
        return sb.reverse().toString();
    }

    private static BigDecimal digitalNumber(StringBuilder sb) {
        BigDecimal res = new BigDecimal(0);
        BigDecimal two = new BigDecimal(2);
        BigDecimal one = new BigDecimal(1);
        BigDecimal zero = new BigDecimal(0);
        int i = 0;
        while (i < sb.length()) {
            res = res.multiply(two);
            if (sb.charAt(i) - '0' == 1) {
                res = res.add(one);
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(concatenatedBinary(1));
        System.out.println(concatenatedBinary(2));
        System.out.println(concatenatedBinary(42));
        System.out.println(concatenatedBinary(6812));
        //727837408
    }
}



