package algoexpert;

public class MaxSubsetSumNoAdjacent {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return 1;
        int[] maxSum = array.clone();
        maxSum[1] = Math.max(array[1], array[0]);
        for (int i = 2; i < array.length; i++) {
            maxSum[i] = Math.max(maxSum[i - 1], maxSum[i - 2] + array[i]);
        }
        return maxSum[array.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxSubsetSumNoAdjacent(new int[]{75, 105, 120, 75, 90, 135}));
    }
}
