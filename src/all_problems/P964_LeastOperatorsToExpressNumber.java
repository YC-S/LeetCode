package all_problems;

public class P964_LeastOperatorsToExpressNumber {
    public int leastOpsExpressTarget(int x, int target) {
        int pos = 0, neg = 0, k = 0, pos2, neg2, cur;
        while (target > 0) {
            cur = target % x;
            target /= x;
            if (k > 0) {
                pos2 = Math.min(cur * k + pos, (cur + 1) * k + neg);
                neg2 = Math.min((x - cur) * k + pos, (x - cur - 1) * k + neg);
                pos = pos2;
                neg = neg2;
            } else {
                pos = cur * 2;
                neg = (x - cur) * 2;
            }
            k++;
        }
        return Math.min(pos, k + neg) - 1;
    }
}
