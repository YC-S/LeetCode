package leetcode500.p02_binary_search.plan3;

import java.util.LinkedList;
import java.util.List;

public class P658_FindKClosestElements {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int n = arr.length, l = 0, r = n - 1;
    LinkedList<Integer> res = new LinkedList<>();
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (arr[mid] == x) {
        l = mid;
        break;
      } else if (arr[mid] < x) l = mid + 1;
      else r = mid;
    }
    int hi = l, lo = l - 1;
    while (k-- > 0) {
      if (lo >= 0 && hi < n) {
        if (Math.abs(arr[lo] - x) <= Math.abs(arr[hi] - x)) res.addFirst(arr[lo--]);
        else res.addLast(arr[hi++]);
      } else if (lo < 0 && hi >= n) break;
      else if (lo >= 0) res.addFirst(arr[lo--]);
      else res.addLast(arr[hi++]);
    }
    return res;
  }
}
