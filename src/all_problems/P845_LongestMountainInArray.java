package all_problems;

public class P845_LongestMountainInArray {
    public int longestMountain(int[] arr) {
        int N = arr.length, res = 0;
        int[] up = new int[N], down = new int[N];
        for (int i = N - 2; i >= 0; --i) if (arr[i] > arr[i + 1]) down[i] = down[i + 1] + 1;
        for (int i = 0; i < N; ++i) {
            if (i > 0 && arr[i] > arr[i - 1]) up[i] = up[i - 1] + 1;
            if (up[i] > 0 && down[i] > 0) res = Math.max(res, up[i] + down[i] + 1);
        }
        return res;
    }
}
