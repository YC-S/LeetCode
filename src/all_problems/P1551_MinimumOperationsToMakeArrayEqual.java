package all_problems;

public class P1551_MinimumOperationsToMakeArrayEqual {
    public int minOperations(int n) {
        int cnt = n / 2;
        return cnt * (cnt + n % 2);
    }
}
