public class P1687_DeliveringBoxesFromStorageToPorts {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;

        boolean[] C = new boolean[n]; // consecutive ports are different or not
        for (int i = 0; i < n - 1; i++) {
            if (boxes[i][0] != boxes[i + 1][0]) C[i] = true;
        }

        int[] dp = new int[n + 1];
        int sum = 0; // total current weight on the ship
        int start = 0; // load all boxes from start to i in one voyage
        int diff = 0; // # different consecutive ports between start and i

        for (int i = 0; i < n; i++) {
            if (i - start == maxBoxes) { // drop 1 box because of # boxes constraint
                sum -= boxes[start][1];
                if (C[start]) diff--;
                start++;
            }

            // Add box i, update current weight and diff
            sum += boxes[i][1];
            if (i > 0 && C[i - 1]) diff++;

            while (sum > maxWeight) { // drop more boxex because of weight constraint
                sum -= boxes[start][1];
                if (C[start]) diff--;
                start++;
            }

            while (start < i && dp[start] == dp[start + 1]) {
                // drop more boxes if there is no point to carry them
                sum -= boxes[start][1];
                if (C[start]) diff--;
                start++;
            }

            dp[i + 1] = diff + 2 + dp[start];
        }
        return dp[n];
    }
}
