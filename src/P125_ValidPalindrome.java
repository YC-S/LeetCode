/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */
public class P125_ValidPalindrome {

    public static boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        for (int i = 0, j = arr.length - 1; i <= j; ) {
            if (!isAlphaNumeric(arr[i])) {
                i++;
                continue;
            }
            if (!isAlphaNumeric(arr[j])) {
                j--;
                continue;
            }
            if (arr[i] != arr[j]) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z';
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
}
