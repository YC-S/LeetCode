package all_problems;

public class P1111_MaximumNestingDepthOfTwoValidParenthesesStrings {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        for (int i = 0; i < n; ++i)
            res[i] = seq.charAt(i) == '(' ? i & 1 : (1 - i & 1);
        return res;
    }
}
