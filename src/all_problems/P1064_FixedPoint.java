package all_problems;

public class P1064_FixedPoint {
    public int fixedPoint(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] - m < 0)
                l = m + 1;
            else
                r = m;
        }
        return arr[l] == l ? l : -1;
    }

}
