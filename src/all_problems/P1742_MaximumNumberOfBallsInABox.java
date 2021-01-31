package all_problems;

import java.util.HashMap;
import java.util.Map;

public class P1742_MaximumNumberOfBallsInABox {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int d = digitSum(i);
            map.put(d, map.getOrDefault(d, 0) + 1);
            res = Math.max(res, map.get(d));
        }
        return res;
    }

    public int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}
