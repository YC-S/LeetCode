package all_problems;

public class P1016_BinaryStringWithSubstringsRepresenting1ToN {
    public boolean queryString(String S, int N) {
        for (int i = N; i > N / 2; --i)
            if (!S.contains(Integer.toBinaryString(i)))
                return false;
        return true;
    }
}
