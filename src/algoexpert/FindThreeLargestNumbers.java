package algoexpert;

import java.util.Arrays;

public class FindThreeLargestNumbers {
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int a = array[0];
        int b = array[1];
        int c = array[2];
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (a > c) {
            int tmp = a;
            a = c;
            c = tmp;
            tmp = b;
            b = c;
            c = tmp;
        } else {
            if (b > c) {
                int tmp = b;
                b = c;
                c = tmp;
            }
        }
        for (int i = 3; i < array.length; i++) {
            if (array[i] >= c) {
                a = b;
                b = c;
                c = array[i];
            } else if (array[i] >= b) {
                a = b;
                b = array[i];
            } else if (array[i] >= a) {
                a = array[i];
            }
        }
        return new int[]{a, b, c};
    }


    public static void main(String[] args) {
        int[] arr = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        System.out.println(Arrays.toString(findThreeLargestNumbers(arr)));
    }
}
