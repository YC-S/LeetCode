/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.华为机考;

import java.util.Scanner;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */
public class Count8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String cur = sc.nextLine();
            if (cur.length() % 8 != 0) {
                int left = 8 - cur.length() % 8;
                String tmp = "";
                for (int i = 0; i < left; ++i) {
                    tmp += "0";
                }
                cur += tmp;
            }
            int i = 0;
            while (i <= cur.length() - 8) {
                System.out.println(cur.substring(i, i + 8));
                i += 8;
            }
        }
    }
}
