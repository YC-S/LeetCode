package all_problems;

public class P666_PathSumIV {
    public int pathSum(int[] nums) {
        int[][] m = new int[5][8];
        for (int n : nums) {
            int i = n / 100; // i is 1 based index;
            int j = (n % 100) / 10 - 1; // j used 0 based index;
            int v = n % 10;
            m[i][j] = m[i - 1][j / 2] + v;
        }

        int sum = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 4 || m[i][j] != 0 && m[i + 1][j * 2] == 0 && m[i + 1][j * 2 + 1] == 0) {
                    sum += m[i][j];
                }
            }
        }
        return sum;
    }
}
