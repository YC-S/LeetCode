package book.laioffer;

import java.util.ArrayList;
import java.util.List;

public class P652_CommonNumbersOfTwoSortedArrays {
  public List<Integer> common(int[] A, int[] B) {
    List<Integer> res = new ArrayList<>();
    if (A.length == 0 || B.length == 0) return res;
    int i = 0, j = 0;
    while (i < A.length && j < B.length) {
      if (A[i] == B[j]) {
        res.add(A[i]);
        i++;
        j++;
      } else if (A[i] < B[j]) {
        i++;
      } else {
        j++;
      }
    }
    return res;
  }
}
