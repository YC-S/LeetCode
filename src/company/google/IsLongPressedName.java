/*
 * Copyright (c) 2020. Yuanchen
 */

package company.google;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/11
 */
public class IsLongPressedName {
    // Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long
    // pressed, and the character will be typed 1 or more times.
    //
    // You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name,
    // with some characters (possibly none) being long pressed.
    // 'alex' = 'aaleex'
    // 'saeed' != 'ssaaedd'
    // 'leelee' = 'lleeeleee'
    // 'laiden' = 'laiden'

    public static void main(String[] args) {
        IsLongPressedName solution = new IsLongPressedName();
        System.out.println(solution.isLongPressedName("alex", "aaleex"));
        System.out.println(solution.isLongPressedName("saeed", "ssaaedd"));
        System.out.println(solution.isLongPressedName("pyplrz", "ppyypllr"));
        System.out.println(solution.isLongPressedName("vtkgn", "vttkgnn"));
    }

    public boolean isLongPressedName(String name, String typed) {
        if (name == null && typed == null) {
            return true;
        }
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            char a = name.charAt(i);
            char b = typed.charAt(j);
            if (a == b) {
                i++;
                j++;
            } else {
                if (i != 0 && typed.charAt(j) == name.charAt(i - 1)) {
                    j++;
                } else {
                    return false;
                }
            }
        }
        if (i == name.length() && j == typed.length()) {
            return true;
        }
        if (i == name.length()) {
            for (int k = j; k < typed.length(); k++) {
                if (typed.charAt(k) != name.charAt(i - 1)) {
                    return false;
                }
            }
        }
        return j != typed.length();
    }
}
