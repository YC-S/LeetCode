package all_problems;

public class P1739_BuildingBoxes {
    public int minimumBoxes(int n) {
        int k = findBase(n);
        int m = firstLE(n - (int) n3(k), 0, k + 1);
        return n2(k) + m;
    }

    private int firstLE(int n, int left, int right) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (n2(mid) >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return n2(left) >= n ? left : right;
    }

    private int findBase(int n) {
        long left = 1;
        long right = 2000;
        while (left < right - 1) {
            long mid = left + (right - left) / 2;
            if (n3(mid) <= n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return n3(right) <= n ? (int) right : (int) left;
    }

    private int n2(int n) {
        return n * (n + 1) / 2;
    }

    private long n3(long n) {
        return n * (n + 1) * (n + 2) / 6;
    }
}
