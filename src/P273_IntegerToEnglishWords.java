/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/19
 */
public class P273_IntegerToEnglishWords {

    public static void main(String[] args) {
        P273_IntegerToEnglishWords solution = new P273_IntegerToEnglishWords();
        System.out.println(solution.numberToWords(123));
        System.out.println(solution.numberToWords(0));
        System.out.println(solution.numberToWords(10));
        System.out.println(solution.numberToWords(100));
        System.out.println(solution.numberToWords(1000));
        System.out.println(solution.numberToWords(12345));
        System.out.println(solution.numberToWords(1234567));
        System.out.println(solution.numberToWords(123456789));
    }

    public String numberToWords(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        int billion = num / (int) (Math.pow(10, 9));
        num %= (int) (Math.pow(10, 9));
        if (billion != 0) {
            sb.append(helper(billion, map));
            sb.append("Billion ");
        }
        int million = num / (int) (Math.pow(10, 6));
        num %= (int) (Math.pow(10, 6));
        if (million != 0) {
            sb.append(helper(million, map));
            sb.append("Million ");
        }
        int thousand = num / (int) (Math.pow(10, 3));
        num %= (int) (Math.pow(10, 3));
        if (thousand != 0) {
            sb.append(helper(thousand, map));
            sb.append("Thousand ");
        }

        sb.append(helper(num, map));

        return sb.toString().trim();
    }

    private String helper(int num, Map<Integer, String> map) {
        StringBuilder sb = new StringBuilder();
        int hundred = num / 100;
        if (hundred != 0) {
            sb.append(map.get(hundred) + " " + "Hundred" + " ");
        }
        num %= 100;
        int tens = num / 10;
        int ones = num % 10;
        if (tens >= 2) {
            sb.append(map.get(tens * 10) + " ");
            if (ones != 0) {
                sb.append(map.get(ones) + " ");
            }
        } else {
            if (num != 0) {
                sb.append(map.get(num) + " ");
            }
        }
        return sb.toString();
    }
}
