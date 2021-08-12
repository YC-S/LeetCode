package triplebyte.general;

import java.util.ArrayList;
import java.util.List;

public class C {
  public static void func(int a, List<Integer> b) {
    a += 1;
    b.add(1);
  }

  public static void main(String[] args) {
    int a = 0;
    List<Integer> b = new ArrayList<>();
    func(a, b);
    System.out.println(a + b.toString());
  }
}
