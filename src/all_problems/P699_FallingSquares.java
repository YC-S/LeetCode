package all_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P699_FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        int[] ends = new int[positions.length * 2];
        for (int i = 0; i < positions.length; i++) {
            ends[i * 2 + 0] = positions[i][0];
            ends[i * 2 + 1] = positions[i][0] + positions[i][1];
        }
        Arrays.sort(ends);

        int[] ceilings = new int[ends.length - 1];
        int maxAll = 0;
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            int X = positions[i][0];
            int x = Arrays.binarySearch(ends, X);
            assert x >= 0;
            int maxCeiling = 0;
            int Y = X + positions[i][1];
            for (int y = x; ends[y] < Y; y++)
                maxCeiling = Math.max(maxCeiling, ceilings[y]);
            maxCeiling += (Y - X);
            for (int y = x; ends[y] < Y; y++)
                ceilings[y] = maxCeiling;
            maxAll = Math.max(maxAll, maxCeiling);
            results.add(maxAll);
        }
        return results;
    }
}
