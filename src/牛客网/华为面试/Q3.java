/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.华为面试;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int v = Integer.parseInt(sc.nextLine());
        int[] array = new int[a.length()];
        for (int i = 0; i < a.length(); ++i) {
            array[i] = Math.abs(a.charAt(i) - b.charAt(i));
        }

        int max = 0;

        for (int i = 0; i < array.length; ++i) {
            int curSum = 0;
            int count = 0;
            for (int j = i; j < array.length; ++j) {
                if (curSum + array[j] > v) {
                    break;
                } else {
                    curSum += array[j];
                    count++;
                }
            }
            max = Math.max(count, max);
        }
        System.out.println(max);
    }
}
