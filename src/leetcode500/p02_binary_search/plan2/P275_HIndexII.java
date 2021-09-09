package leetcode500.p02_binary_search.plan2;

public class P275_HIndexII {
  public int hIndex(int[] citations) {
    int len = citations.length;
    int left = 0, right = len - 1;
    while (left <= right) {
      int mid = (right + left) >>> 1;
      if (citations[mid] == len - mid) {
        return len - mid;
      } else if (citations[mid] < len - mid) {
        left = mid + 1;
      } else {
        // (citations[med] > len-med), med qualified as a hIndex,
        // but we have to continue to search for a higher one.
        right = mid - 1;
      }
    }
    return len - left;
  }
}
