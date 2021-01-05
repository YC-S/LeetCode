package contest.leetcode.单周赛._222;

import java.util.Arrays;

public class P1710_MaximumUnitsOnATruck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> (o2[1] - o1[1]));
        int total = 0;
        for (int i = 0, curSize = 0; curSize <= truckSize && i < boxTypes.length; i++) {
            int[] box = boxTypes[i];
            int cur = Math.min(truckSize - curSize, box[0]);
            curSize += cur;
            total += cur * box[1];
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9}};
        System.out.println(maximumUnits(boxTypes, 10));
    }
}
