package all_problems;

import java.util.Arrays;

public class P1564_PutBoxesIntoTheWarehouseI {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int m = boxes.length;
        int n = warehouse.length;
        int res = 0;
        for (int i = 0; i < m & res < n; i++) {
            if (boxes[m - i - 1] <= warehouse[res]) {
                res++;
            }
        }
        return res;
    }
}
