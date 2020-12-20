/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.华为面试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] array = sc.nextLine().split(" ");
        int[] input = new int[n];
        for (int i = 0; i < n; ++i) {
            input[i] = Integer.parseInt(array[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            boolean check = false;
            for (int j = i + 1; j < input.length; j++) {

                if (input[j] > input[i]) {
                    res.add(j);
                    check = true;
                    break;
                }
            }
            if (!check) {
                res.add(0);
            }
        }

        for (int i = 0; i < n; ++i) {
            System.out.print(res.get(i) + " ");
        }
    }

}
