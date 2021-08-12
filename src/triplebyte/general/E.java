package triplebyte.general;

import java.util.function.Function;

class Recursive<I> {
  public I func;
}

public class E {
  public static void main(String[] args) {
    Recursive<Function<Integer, Integer>> recurse = new Recursive<>();
    recurse.func = (n) -> n <= 1 ? 1 : n * recurse.func.apply(n - 1);
    int g = recurse.func.apply(4);
    System.out.println(g);
  }
}
