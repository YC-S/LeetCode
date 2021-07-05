package book.epi_java.scenario1;

import java.util.Arrays;
import java.util.List;

public class P5_1 {
  public static void evenOdd(List<Integer> A) {
    int left = 0, right = A.size() - 1;
    while (left <= right) {
      if (A.get(left) % 2 == 0) {
        left++;
      } else {
        swap(A, left, right--);
      }
    }
  }

  private static void swap(List<Integer> A, int a, int b) {
    int tmp = A.get(a);
    A.set(a, A.get(b));
    A.set(b, tmp);
  }

  public static void dutchFlag(List<Integer> list) {
    int left = 0, mid = 0, right = list.size() - 1;
    while (mid <= right) {
      if (list.get(mid) == -1) {
        swap(list, left++, mid++);
      } else if (list.get(mid) == 0) {
        mid++;
      } else {
        swap(list, mid, right--);
      }
    }
  }

  public static void main(String[] args) {
    List<Integer> A = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 10);
    evenOdd(A);
    System.out.println(A);
    List<Integer> list = Arrays.asList(-1, -1, 0, 1, 0, 1, -1, -1, 1, 0);
    dutchFlag(list);
    System.out.println(list);
  }
}
