import java.util.HashSet;
import java.util.Set;

public class P202HappyNumber {
    public boolean isHappy(int n) {
        if (n < 0) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        while (n != 1) {
            n = transform(n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    private int transform(int n) {
        int res = 0;
        while (n != 0) {
            int tmp = n % 10;
            res += tmp * tmp;
            n /= 10;
        }
        return res;
    }
}
