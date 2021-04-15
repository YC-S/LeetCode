package algoexpert;

public class KadaneAlgorithm {
    public static int kadanesAlgorithm(int[] array) {
        // Write your code here.
        int cur = array[0], res = cur;
        for (int i = 1; i < array.length; i++) {
            cur = Math.max(array[i], array[i] + cur);
            res = Math.max(res, cur);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println(kadanesAlgorithm(array));
    }
}
