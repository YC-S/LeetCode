/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.华为机考;

import java.util.Scanner;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/19
 */
public class CountNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int letter = 0;
            int space = 0;
            int digit = 0;
            int other = 0;
            for (int c : str.toCharArray()) {
                if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                    letter++;
                } else if (c >= '0' && c <= '9') {
                    digit++;
                } else if (c == ' ') {
                    space++;
                } else {
                    other++;
                }
            }
            System.out.println(letter);
            System.out.println(space);
            System.out.println(digit);
            System.out.println(other);
        }
    }
}
