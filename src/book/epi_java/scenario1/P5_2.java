package book.epi_java.scenario1;

import java.util.ArrayList;
import java.util.List;

public class P5_2 {
  public static List<Integer> plusOne(List<Integer> A) {
    int n = A.size();
    boolean carry = true;
    for (int i = n - 1; i >= 0; i--) {
      int tmp = A.get(i);
      tmp++;
      if (tmp < 10) {
        A.set(i, tmp);
        carry = false;
        break;
      } else {
        A.set(i, 0);
        carry = true;
      }
    }
    if (carry) {
      A.add(0, 1);
    }
    return A;
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(9);
    List<Integer> list1 = new ArrayList<>();
    list1.add(9);
    list1.add(9);
    list1.add(9);
    System.out.println(plusOne(list));
    System.out.println(plusOne(list1));
  }
}
