/*
 * Copyright (c) 2020. Yuanchen
 */

package p30daychallenge;

import java.util.List;

interface BinaryMatrix {

    int get(int x, int y);

    List<Integer> dimensions();

}

/**
 * @author shiyuanchen
 */
public class P21LeftmostColumnWithAtLeastAOne {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();

        int rows = list.get(0) - 1;
        int cols = list.get(1) - 1;

        int result = -1;

        if (rows == 0 || cols == 0) {
            return -1;
        }

        while (rows >= 0 && cols >= 0) {
            if (binaryMatrix.get(rows, cols) == 1) {
                result = cols;
                cols--;
            } else {
                rows--;
            }
        }

        return result;
    }
}
