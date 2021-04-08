package algoexpert;

public class NumberOfWaysToMakeChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int denom : denoms) {
            for (int i = 1; i <= n; i++) {
                if (i >= denom) {
                    ways[i] += ways[i - denom];
                }
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeChange(6, new int[]{1, 2, 3}));
    }
}
