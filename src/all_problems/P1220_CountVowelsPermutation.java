package all_problems;

public class P1220_CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        int[][] moves = {{1}, {0, 2}, {0, 1, 3, 4}, {2, 4}, {0}};
        int[] v = {1, 1, 1, 1, 1};
        while (--n > 0) {
            int[] v1 = {0, 0, 0, 0, 0};
            for (int i = 0; i < 5; ++i) {
                for (int j : moves[i])
                    v1[j] = (v1[j] + v[i]) % 1000000007;
            }
            v = v1;
        }
        return (int) (((long) v[0] + v[1] + v[2] + v[3] + v[4]) % 1000000007);
    }
}
