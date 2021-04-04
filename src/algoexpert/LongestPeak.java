package algoexpert;

public class LongestPeak {
    public static int longestPeak(int[] array) {
        int curIndex = 1;
        int res = 0;
        int startIndex = 0;
        int prevIndex = 0;
        boolean decreasing = false;
        while (curIndex < array.length) {
            int prev = array[prevIndex];
            int cur = array[curIndex];
            if (cur > prev) {
                if (decreasing) {
                    startIndex = curIndex - 1;
                }
                prevIndex = curIndex;
                decreasing = false;
            } else if (cur == prev) {
                startIndex = curIndex;
                prevIndex = curIndex;
            } else if (cur < prev) {
                if (prevIndex == startIndex) {
                    startIndex = curIndex;
                    prevIndex = curIndex;
                } else {
                    res = Math.max(res, curIndex - startIndex + 1);
                    prevIndex = curIndex;
                    decreasing = true;
                }

            }
            curIndex++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println(longestPeak(array));
    }
}
