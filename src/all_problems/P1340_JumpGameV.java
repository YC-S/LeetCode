package all_problems;

public class P1340_JumpGameV {
    public int maxJumps(int[] arr, int d) {
        Integer[] memo = new Integer[arr.length];
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, maxJumps(arr, d, i, memo));
        }
        return max;
    }

    private int maxJumps(int[] arr, int d, int index, Integer[] memo) {
        if (index < 0 || index > arr.length) return 0;
        if (memo[index] != null) return memo[index];
        int count = 0;
        for (int i = 1; i <= d; i++) {
            if (index - i < 0 || arr[index - i] >= arr[index]) {
                break;
            }
            count = Math.max(count, maxJumps(arr, d, index - i, memo));
        }
        for (int i = 1; i <= d; i++) {
            if (index + i >= arr.length || arr[index + i] >= arr[index]) {
                break;
            }
            count = Math.max(count, maxJumps(arr, d, index + i, memo));
        }
        memo[index] = count + 1;
        return memo[index];
    }
}
