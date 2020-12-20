/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.华为机考;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/19
 */
public class DeleteMinimum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(deleteMinimum(str));
        }
    }

    private static String deleteMinimum(String str) {
        char[] array = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : array) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int minCount = Integer.MAX_VALUE;
        for (Entry<Character, Integer> entry : map.entrySet()) {
            minCount = Math.min(entry.getValue(), minCount);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            if (map.get(c) != minCount) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
