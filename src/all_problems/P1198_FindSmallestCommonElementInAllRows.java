package all_problems;

import java.util.HashMap;

public class P1198_FindSmallestCommonElementInAllRows {
    public int smallestCommonElement(int[][] mat) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (map.containsKey(mat[i][j])) {
                    int temp = map.get(mat[i][j]);
                    map.put(mat[i][j], temp + 1);
                } else {
                    map.put(mat[i][j], 1);
                }
            }
        }
        // int small = -1;
        for (int i : map.keySet()) {
            if (map.get(i) == mat.length) {
                // if(map.get(i) < ){
                return i;
                // }
            }
        }
        return -1;
    }
}
