package algoexpert;

import java.util.Arrays;
import java.util.Collections;

public class TandemBicycle {
    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        int sum = 0;
        int n = redShirtSpeeds.length;
        if (fastest) {
            Arrays.sort(redShirtSpeeds);
            blueShirtSpeeds = Arrays.stream(blueShirtSpeeds).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
            for (int i = 0; i < n; i++) {
                sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }
        } else {
            Arrays.sort(redShirtSpeeds);
            Arrays.sort(blueShirtSpeeds);
            for (int i = 0; i < n; i++) {
                sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] g1 = {5, 5, 3, 9, 2};
        int[] g2 = {3, 6, 7, 2, 1};
        System.out.println(tandemBicycle(g1, g2, false));

    }
}
