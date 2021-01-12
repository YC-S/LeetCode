package all_problems;

public class P521_LongestUNcommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
