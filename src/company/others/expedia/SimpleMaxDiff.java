package company.others.expedia;

import java.util.Arrays;
import java.util.List;

public class SimpleMaxDiff {
    public static int maxDifference(List<Integer> px) {
        if (px.size() == 0) {
            return -1;
        }
        int max = -1;
        int soFarMin = px.get(0);
        for (Integer i : px) {
            if (i > soFarMin) {
                max = Math.max(max, i - soFarMin);
            } else {
                soFarMin = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxDifference(Arrays.asList(7, 9, 5, 6, 3, 2)));
        System.out.println(maxDifference(Arrays.asList(0)));
        System.out.println(maxDifference(Arrays.asList(1)));
    }
}