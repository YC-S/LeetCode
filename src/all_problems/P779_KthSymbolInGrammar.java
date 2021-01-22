package all_problems;

public class P779_KthSymbolInGrammar {
    public int kthGrammar(int N, int K) {
        return Integer.bitCount(K - 1) % 2;
    }
}
