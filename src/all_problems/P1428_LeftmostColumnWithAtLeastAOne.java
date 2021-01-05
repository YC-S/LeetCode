package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */
interface BinaryMatrix {

    List<Integer> dimensions();

    int get(int row, int col);
}

public class P1428_LeftmostColumnWithAtLeastAOne {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimen = binaryMatrix.dimensions();
        int m = dimen.get(0), n = dimen.get(1);
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (existOneInColumn(binaryMatrix, m, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    boolean existOneInColumn(BinaryMatrix binaryMatrix, int m, int c) {
        for (int r = 0; r < m; r++) {
            if (binaryMatrix.get(r, c) == 1) {
                return true;
            }
        }
        return false;
    }
}
