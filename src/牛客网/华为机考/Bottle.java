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
public class Bottle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            if (n != 0) {
                int res = 0;
                while (n >= 3) {
                    int newBottle = n / 3;
                    res += newBottle;
                    n = newBottle + n % 3;
                }
                if (n == 2) {
                    res++;
                }
                System.out.println(res);
            }
        }
    }
}
