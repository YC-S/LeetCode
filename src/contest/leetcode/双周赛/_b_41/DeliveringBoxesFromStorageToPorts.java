package contest.leetcode.双周赛._b_41;

import java.util.HashMap;
import java.util.Map;

public class DeliveringBoxesFromStorageToPorts {
    Map<Integer, Integer> dp = new HashMap<Integer, Integer>();

    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        return dfs(boxes, 0, maxBoxes, maxWeight);
    }

    private int dfs(int[][] boxes, int start, int maxBoxes, int maxWeight) {
        if (dp.get(start) != null) return dp.get(start);
        if (start == boxes.length) return 0;

        int portCount = 1, prevPort = boxes[start][0], fullLoadedIndex = start, weight = 0, i = start;
        for (; i < boxes.length && i < start + maxBoxes; i++) {
            weight += boxes[i][1];
            if (weight > maxWeight) break;

            if (boxes[i][0] != prevPort) {
                portCount++;
                fullLoadedIndex = i;
            }

            prevPort = boxes[i][0];
        }

        int result = dfs(boxes, i, maxBoxes, maxWeight) + portCount + 1;
        if (i < boxes.length && boxes[i][0] == prevPort && fullLoadedIndex > start) {
            result = Math.min(result, dfs(boxes, fullLoadedIndex, maxBoxes, maxWeight) + portCount);
        }

        dp.put(start, result);

        return result;
    }
}
