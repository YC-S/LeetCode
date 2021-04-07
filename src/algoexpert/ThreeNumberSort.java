package algoexpert;

import java.util.Arrays;

public class ThreeNumberSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = new int[]{0, 1, -1};
        ThreeNumberSort solution = new ThreeNumberSort();
        System.out.println(Arrays.toString(solution.threeNumberSort(array, order)));
    }

    public int[] threeNumberSort(int[] array, int[] order) {
        // Write your code here.
        int i = 0, j = 0, k = array.length - 1;
        while (j <= k) {
            if (array[j] == order[2]) {
                swap(array, j, k--);
            } else if (array[j] == order[1]) {
                j++;
            } else {
                swap(array, i, j);
                i++;
                j++;
            }
        }
        return array;
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
