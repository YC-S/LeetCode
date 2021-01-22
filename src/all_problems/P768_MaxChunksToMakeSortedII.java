package all_problems;

public class P768_MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        int[] min = new int[arr.length];
        int[] max = new int[arr.length];

        min[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            min[i] = Math.min(arr[i], min[i + 1]);
        }
        max[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max[i] = Math.max(arr[i], max[i - 1]);
        }

        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (min[i] >= max[i - 1]) {
                cnt++;
            }
        }
        return cnt;
    }
}
