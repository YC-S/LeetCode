/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_may;

/**
 * @author shiyuanchen
 * @created 2020/05/01
 * @project LeetCode
 */
public class P1FirstBadVersion {

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isBadVersion(left)) {
            return left;
        } else if (isBadVersion(right)) {
            return right;
        } else {
            return -1;
        }
    }

    private static boolean isBadVersion(int n) {
        int num = 11123412;
        return n >= num;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }
}
