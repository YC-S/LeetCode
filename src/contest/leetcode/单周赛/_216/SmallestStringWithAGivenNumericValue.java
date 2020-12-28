package contest.leetcode.单周赛._216;

import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue {
    public static String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');
        int idx = n - 1;
        while (k > n) {
            arr[idx--] += 25;
            n += 25;
        }
        arr[idx + 1] -= n - k;
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(getSmallestString(3, 27));
    }
}
