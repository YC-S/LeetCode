package all_problems;

public class P930_BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int psum = 0;
        int res = 0;
        int[] count = new int[A.length + 1];
        count[0] = 1;
        for (int i : A) {
            psum += i;
            if (psum >= S)
                res += count[psum - S];
            count[psum]++;
        }
        return res;
    }
}
