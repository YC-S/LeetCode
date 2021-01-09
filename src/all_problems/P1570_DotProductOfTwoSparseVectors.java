package all_problems;

import java.util.HashMap;
import java.util.Map;

public class P1570_DotProductOfTwoSparseVectors {
    Map<Integer, Integer> indexMap = new HashMap<>();
    int n = 0;

    P1570_DotProductOfTwoSparseVectors(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                indexMap.put(i, nums[i]);
        n = nums.length;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(P1570_DotProductOfTwoSparseVectors vec) {
        if (indexMap.size() == 0 || vec.indexMap.size() == 0) return 0;
        if (indexMap.size() > vec.indexMap.size())
            return vec.dotProduct(this);
        int productSum = 0;
        for (Map.Entry<Integer, Integer> entry : indexMap.entrySet()) {
            int index = entry.getKey();
            Integer vecValue = vec.indexMap.get(index);
            if (vecValue == null) continue;
            productSum += (entry.getValue() * vecValue);
        }
        return productSum;
    }
}
