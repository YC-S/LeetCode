package company.didi;

import java.util.HashSet;
import java.util.Set;

public class TwoDifferentNumbers {
  public static int solution(int[] A) {
    Set<Integer> set = new HashSet<>();
    if (A == null || A.length == 0) return 0;
    if (A.length == 1) return 1;
    int n = A.length;
    int i = 0, j = 1, max = 1;
    set.add(A[0]);
    while (j < n) {
      if (set.contains(A[j])) {
        max = Math.max(max, j - i + 1);
        j++;
      } else if (set.size() < 2) {
        set.add(A[j]);
        max = Math.max(max, j - i + 1);
        j++;
      } else {
        int tmp = A[i];
        for (int k = i; k < j; k++) {
          if (A[k] == tmp) {
            i = k + 1;
          }
        }
        set.remove(tmp);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    //    int[] A = {4, 2, 4, 2, 3, 4, 2};
    //    int[] B = {4,2,2,4,2};
    //    int[] C = {1,2,3,2};
    //    int[] D = {0,5,4,4,5,12};
    //    int[] E = {4,4};
    //    int[] F = {Integer.MIN_VALUE, Integer.MAX_VALUE, 0, Integer.MIN_VALUE};
    int[] G = {1, 3, 3, 1, 4, 5, 5, 5, 5, 5};
    //    System.out.println(solution(A));
    //    System.out.println(solution(B));
    //    System.out.println(solution(C));
    //    System.out.println(solution(D));
    //    System.out.println(solution(E));
    //    System.out.println(solution(F));
    System.out.println(solution(G));
  }
}
