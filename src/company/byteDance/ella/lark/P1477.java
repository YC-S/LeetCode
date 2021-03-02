package company.byteDance.ella.lark;

import java.util.HashMap;
import java.util.Map;

public class P1477 {
    // First traverse through the array once and store the (key,value) pair
    // as (sum(arr[0:i+1]),i) for 0<=i<size of arr. Put, (0,-1) in hashmap as default.
    // Now traverse through the array again, and for every i, find the minimum value of
    // length of sub-array on the left or starting with i whose value is equal to target.
    // Find another sub-array starting with i+1, whose sum is target.
    // Update the result with the minimum value of the sum of both the sub-array.
    // This is possible because all values are positive and the value of sum is strictly increasing.
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, lsize = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            map.put(sum, i); // stores key as sum upto index i, and value as i.
        }
        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.get(sum - target) != null) {
                lsize = Math.min(lsize, i - map.get(sum - target));
                // stores minimum length of sub-array ending with index <= i with sum target.
                // This ensures non- overlapping property.
            }
            //map.get(sum+target) searches for any sub-array starting with index i+1 with sum target.
            if (map.get(sum + target) != null && lsize < Integer.MAX_VALUE) {
                result = Math.min(result, map.get(sum + target) - i + lsize);
                // updates the result only if both left and right sub-array exists.
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    // left[i] is the size of the min size subarray in arr[0, i] that sums up to target. Is Integer.MAX_VALUE if there is no subarray that sums up to target.
    // right[i] is the size of the min size subarray in arr[i, arr.length - 1] that sums up to target.
    // for (int i = 1; i < arr.length; ++i) result = Math.min(result, left[i - 1] + right[i]);
    public int minSumOfLengths2(int[] arr, int target) {
        int[] left = new int[arr.length];
        int sum = 0, best = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                best = Math.min(best, i - map.get(sum - target));
            }
            left[i] = best;
            map.put(sum, i);
        }

        int[] right = new int[arr.length];
        sum = 0;
        best = Integer.MAX_VALUE;
        map = new HashMap<>();
        map.put(0, arr.length);
        for (int i = arr.length - 1; i >= 0; --i) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                best = Math.min(best, map.get(sum - target) - i);
            }
            right[i] = best;
            map.put(sum, i);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; ++i) {
            if (left[i - 1] != Integer.MAX_VALUE && right[i] != Integer.MAX_VALUE) {
                result = Math.min(result, left[i - 1] + right[i]);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
