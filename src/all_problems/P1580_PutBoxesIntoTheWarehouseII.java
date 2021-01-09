package all_problems;

import java.util.Arrays;

public class P1580_PutBoxesIntoTheWarehouseII {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int p1 = 0;
        int p2 = warehouse.length - 1;
        Arrays.sort(boxes);
        int res = 0;
        for (int i = boxes.length - 1; i >= 0 && p1 <= p2; i--) {
            if (boxes[i] <= warehouse[p1]) {
                p1++;
                res++;
            } else if (boxes[i] <= warehouse[p2]) {
                p2--;
                res++;
            }
        }
        return res;
    }
}
