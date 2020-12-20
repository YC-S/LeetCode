/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.华为机考;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */
public class HexToDec {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
        while (sc.hasNext()) {
            String input = sc.nextLine().substring(2);
            int res = 0;
            for (int i = 0; i < input.length(); i++) {
                int cur = 0;
                if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    cur = input.charAt(i) - '0';
                } else {
                    cur = map.get(input.charAt(i));
                }
                res = 16 * res + cur;
            }
            System.out.println(res);
        }
    }
}
