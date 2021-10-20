package leetcode500.p03_array.plan6;

public class P768_MaxChunkToMakeSortedII {
  public int maxChunksToSorted(int[] arr) {
    // Algorithm: Iterate through the array, each time all elements to the left are smaller (or
    // equal) to all elements to the right, there is a new chunck.
    // Use two arrays to store the left max and right min to achieve O(n) time complexity. Space
    // complexity is O(n) too.
    int[] min = new int[arr.length];
    int[] max = new int[arr.length];

    min[arr.length - 1] = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--) {
      min[i] = Math.min(arr[i], min[i + 1]);
    }
    max[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      max[i] = Math.max(arr[i], max[i - 1]);
    }

    int cnt = 1;
    for (int i = 1; i < arr.length; i++) {
      if (min[i] >= max[i - 1]) {
        cnt++;
      }
    }
    return cnt;
  }
}
