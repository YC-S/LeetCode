/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.企业真题;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/04
 */
public class NSystem {

    public static String solve(int M, int N) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Character> map = new HashMap<>();
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');
        boolean negative = false;
        if (M < 0) {
            negative = true;
            M = -M;
        }
        while (M != 0) {
            int lastDigit = M % N;
            if (lastDigit >= 10) {
                sb.append(map.get(lastDigit));
            } else {
                sb.append(lastDigit);
            }
            M /= N;
        }
        if (negative) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solve(-4, 3));
    }

}
