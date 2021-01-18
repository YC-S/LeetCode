package all_problems;

public class P1009_ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return X - N;
    }
}
