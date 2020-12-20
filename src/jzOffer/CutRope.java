/*
 * Copyright (c) 2020. Yuanchen
 */

package jzOffer;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/15
 */
public class CutRope {

    public int cutRope(int target) {
        int a = 0;
        int c = 0;
        int maxValue = 2;
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        if (target % 3 == 0) {
            maxValue = (int) Math.pow(3, target / 3);
        } else {
            a = target - 2;
            c = a % 3;
            maxValue = maxValue * (int) Math.pow(3, a / 3);
            if (0 != c) {
                maxValue = maxValue * c;
            }
        }
        return maxValue;
    }
}
