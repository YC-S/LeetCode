package algoexpert;

import java.util.Arrays;

public class ArrayOfProducts {
    public static int[] arrayOfProducts(int[] array) {
        int[] res = new int[array.length];
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        int cur = 1;
        for (int i = 0; i < left.length; i++) {
            cur *= array[i];
            left[i] = cur;
        }
        cur = 1;
        for (int i = right.length - 1; i >= 0; i--) {
            cur *= array[i];
            right[i] = cur;
        }
        for (int i = 0; i < res.length; i++) {
            if (i == 0) {
                res[i] = right[i + 1];
            } else if (i == res.length - 1) {
                res[i] = left[i - 1];
            } else {
                res[i] = left[i - 1] * right[i + 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayOfProducts(new int[]{5, 1, 4, 2})));
    }
}
