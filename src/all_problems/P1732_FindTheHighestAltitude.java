package all_problems;

public class P1732_FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int max_alt = 0;
        int curr_alt = 0;
        for (int j : gain) {
            curr_alt += j;
            max_alt = Math.max(curr_alt, max_alt);
        }
        return max_alt;
    }
}
