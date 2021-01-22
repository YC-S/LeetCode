package all_problems;

public class P852_PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i + 1 < arr.length; ++i) if (arr[i] > arr[i + 1]) return i;
        // for (int i = A.length - 1; i > 0; --i) if (A[i] > A[i - 1]) return i;
        return 0;
    }
}
