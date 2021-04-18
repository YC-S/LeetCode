package algoexpert;

import java.util.ArrayList;
import java.util.Collections;

public class SunsetViews {
    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        // Write your code here.
        ArrayList<Integer> res = new ArrayList<>();
        int curMax = 0;
        if (direction.equals("EAST")) {
            for (int i = buildings.length - 1; i >= 0; i--) {
                if (buildings[i] > curMax) {
                    res.add(i);
                    curMax = buildings[i];
                }
            }
            Collections.reverse(res);
        } else {
            for (int i = 0; i < buildings.length; i++) {
                if (buildings[i] > curMax) {
                    res.add(i);
                    curMax = buildings[i];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sunsetViews(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "WEST"));
    }
}
