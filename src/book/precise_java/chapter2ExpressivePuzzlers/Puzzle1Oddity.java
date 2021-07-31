package book.precise_java.chapter2ExpressivePuzzlers;

public class Puzzle1Oddity {
  public static boolean isOdd(int i) {
    return (i & 1) == 1;
  }

  public static void main(String[] args) {
    System.out.println(isOdd(-1));
    System.out.println(isOdd(-2));
    System.out.println(isOdd(0));
    System.out.println(isOdd(1));
    System.out.println(isOdd(2));
    System.out.println(isOdd(Integer.MAX_VALUE));
    System.out.println(isOdd(Integer.MIN_VALUE));
  }
}
