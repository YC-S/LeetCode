/*
 * Copyright (c) 2020. Yuanchen
 */

package code_forces;

import java.util.Scanner;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/14
 */
public class P71AWayTooLongWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            if (word.length() <= 10) {
                System.out.println(word);
            } else {
                String res = word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
                System.out.println(res);
            }
        }
    }
}
