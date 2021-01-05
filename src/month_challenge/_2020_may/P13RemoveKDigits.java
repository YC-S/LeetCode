/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_may;

/**
 * @author shiyuanchen
 * @created 2020/05/13
 * @project LeetCode
 */
public class P13RemoveKDigits {

    public static String removeKDigits(String num, int k) {
        char[] list = new char[num.length()];

        int len = num.length() - k;
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            while (top > 0 && k > 0 && num.charAt(i) < list[top - 1]) {
                top--;
                k--;
            }
            list[top++] = num.charAt(i);
        }

        int number = 0;
        while (number < len && list[number] == '0') {
            number++;
        }
        return number == len ? "0" : new String(list, number, len - number);
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("1432219", 3));
        System.out.println(removeKDigits("10200", 1));
        System.out.println(removeKDigits("10", 2));
    }
}
