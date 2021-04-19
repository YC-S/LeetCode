package company.others.bitgo;

import java.util.Arrays;

public class DataMerging {
    public static double[] merge(double[] nums1, double[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int p = nums1.length;
        int q = nums2.length;
        double[] array = new double[p + q];
        while (i < p && j < q) {
            if (nums1[i] < nums2[j]) {
                array[k] = nums1[i];
                i++;
            } else {
                array[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < p) {
            array[k] = nums1[i];
            k++;
            i++;
        }
        while (j < q) {
            array[k] = nums2[j];
            k++;
            j++;
        }
        return array;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new double[]{1, 2, 3}, new double[]{4, 5, 6})));
    }

}
