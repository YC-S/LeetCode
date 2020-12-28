package contest.leetcode.双周赛._b_42;

import java.util.Arrays;

public class Q3 {
    public static String maximumBinaryString(String binary) {
        // Find the amount of zero in the string
        // by first zero occurrence, determine the desired index to put the 0 if exist,
        // and fill the rest as 1
        char[] curr = binary.toCharArray();
        int zero = 0;
        int index = -1;
        for (int i = 0; i < curr.length; i++) {
            if (curr[i] == '0') {
                zero++;
                if (index == -1)
                    index = i;
            }
        }
        Arrays.fill(curr, '1');
        if (index != -1) {
            curr[index + zero - 1] = '0';
        }
        return new String(curr);
    }

    public static void main(String[] args) {
        System.out.println(maximumBinaryString("01111001100000110010"));
    }
}
