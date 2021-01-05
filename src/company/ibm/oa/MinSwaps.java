package company.ibm.oa;

import java.util.Arrays;
import java.util.List;

public class MinSwaps {
    static int findMinSwaps(List<Integer> arr) {
        int n = arr.size();
        // Array to store count of zeroes
        int[] noOfZeroes = new int[n];
        int[] noOfOnes = new int[n];
        int i, count1 = 0, count2 = 0;

        // Count number of zeroes
        // on right side of every one.
        noOfZeroes[n - 1] = 1 - arr.get(n - 1);
        for (i = n - 2; i >= 0; i--) {
            noOfZeroes[i] = noOfZeroes[i + 1];
            if (arr.get(i) == 0)
                noOfZeroes[i]++;
        }

        // Count total number of swaps by adding number
        // of zeroes on right side of every one.
        for (i = 0; i < n; i++) {
            if (arr.get(i) == 1)
                count1 += noOfZeroes[i];
        }

        noOfOnes[0] = 1 - arr.get(0);
        for (i = 1; i < n; ++i) {
            noOfOnes[i] = noOfOnes[i - 1];
            if (arr.get(i) == 1) {
                noOfOnes[i]++;
            }
        }

        for (i = 0; i < n; ++i) {
            if (arr.get(i) == 0) {
                count2 += noOfOnes[i];
            }
        }

        return Math.min(count1, count2);
    }

    // Driver Code
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(0, 0, 1, 0, 1, 0, 1, 1);
        List<Integer> arr1 = Arrays.asList(1, 1, 1, 1, 0, 0, 0, 0);
        System.out.println(findMinSwaps(arr1));
    }

}
