package triplebyte.general;

import java.util.Arrays;
import java.util.List;

class Consumer {
  List<String> name;

  public Consumer(List<String> name) {
    this.name = name;
  }
}

public class D {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4);
    list.remove(3);
    System.out.println(list);
  }
}
