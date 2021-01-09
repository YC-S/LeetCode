/*
 * Copyright (c) 2020. Yuanchen
 */

package contest.code_forces;

import java.util.Scanner;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/12
 */
public class P1ATheatreSquare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        long m = Long.parseLong(arr[0]);
        long n = Long.parseLong(arr[0]);
        long a = Long.parseLong(arr[0]);
        long x = m % a == 0 ? m / a : m / a + 1;
        long y = n % a == 0 ? n / a : n / a + 1;
        System.out.println(x * y);
    }

}
