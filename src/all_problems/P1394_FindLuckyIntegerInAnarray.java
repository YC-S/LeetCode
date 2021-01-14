package all_problems;

public class P1394_FindLuckyIntegerInAnarray {
    public int findLucky(int[] arr) {
        int[] cnt = new int[501];
        for (int a : arr) {
            ++cnt[a];
        }
        for (int i = 500; i > 0; --i) {
            if (cnt[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
