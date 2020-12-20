/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.程序员代码面试指南;

import java.util.Scanner;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */
public class CD1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(" ");
        int n = Integer.parseInt(array[0]);
        int m = Integer.parseInt(array[1]);
        int k = Integer.parseInt(array[2]);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; ++i) {
            String[] tmp = sc.nextLine().split(" ");
            for (int j = 0; j < m; ++j) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int i = 0;
        int j = m - 1;
        boolean found = false;
        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (arr[i][j] == k) {
                found = true;
                break;
            } else if (arr[i][j] < k) {
                i++;
            } else if (arr[i][j] > k) {
                j--;
            }
        }
        if (found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
