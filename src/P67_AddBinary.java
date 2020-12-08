/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/07
 */
public class P67_AddBinary {

    public static void main(String[] args) {
        P67_AddBinary solution = new P67_AddBinary();
        System.out.println(solution.addBinary("1", "111"));
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int cur = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            if (cur > 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(cur % 2);
            i--;
            j--;
        }
        while (i >= 0) {
            int cur = a.charAt(i) - '0' + carry;
            if (cur > 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(cur % 2);
            i--;
        }
        while (j >= 0) {
            int cur = b.charAt(j) - '0' + carry;
            if (cur > 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(cur % 2);
            j--;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
