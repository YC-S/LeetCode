package all_problems;

public class P1053_PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] arr) {
        int idx = arr.length - 2, i = arr.length - 1;
        //find the first i, that A[i] > A[i + 1]
        while (idx >= 0 && arr[idx] <= arr[idx + 1]) idx--;
        if (idx < 0) return arr;
        //find the largest A[i] and smallest i,  that make A[i] < A[idx], where i > idx;
        while (arr[i] >= arr[idx] || (i > 0 && arr[i] == arr[i - 1])) i--;
        int tmp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = tmp;
        return arr;
    }
}
