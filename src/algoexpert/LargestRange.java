package algoexpert;

import java.util.Arrays;

public class LargestRange {
    public static int[] largestRange(int[] array) {
        Arrays.sort(array);
        int left = 0;
        int right = 1;
        int maxLeft = left;
        int maxRight = right;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1] + 1 || array[i] == array[i - 1]) {
                right++;
            } else {
                if ((array[right - 1] - array[left]) > (array[maxRight - 1] - array[maxLeft])) {
                    maxRight = right;
                    maxLeft = left;
                }
                left = i;
                right = i + 1;
            }
        }
        if ((array[right - 1] - array[left]) > (array[maxRight - 1] - array[maxLeft])) {
            maxRight = right;
            maxLeft = left;
        }
        return new int[]{array[maxLeft], array[maxRight - 1]};
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(largestRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6})));
//        System.out.println(Arrays.toString(largestRange(new int[]{1,1})));
//        System.out.println(Arrays.toString(largestRange(new int[]{1, 2})));
        System.out.println(Arrays.toString(largestRange(new int[]{19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7, 6, 15, 12, 12, 2, 1, 6, 13, 14})));
    }
}
