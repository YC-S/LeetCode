package all_problems;

public class P1562_FindLatestGroupOfSizeM {
    public int findLatestStep(int[] arr, int m) {
        int res = -1, n = arr.length;
        int[] length = new int[n + 2], count = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int a = arr[i], left = length[a - 1], right = length[a + 1];
            length[a] = length[a - left] = length[a + right] = left + right + 1;
            count[left]--;
            count[right]--;
            count[length[a]]++;
            if (count[m] > 0)
                res = i + 1;
        }
        return res;
    }
}
