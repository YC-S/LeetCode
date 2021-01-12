package explore.month_challenge._2021_january.week2;

import java.util.Arrays;

public class Day4MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = Arrays.copyOf(nums1, m);
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums3[i] < nums2[j]) {
                nums1[k++] = nums3[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums1[k++] = nums3[i++];
        }
        while (j < n) {
            nums1[k++] = nums2[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
