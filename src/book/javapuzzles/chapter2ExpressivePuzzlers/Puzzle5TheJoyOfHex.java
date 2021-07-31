package book.javapuzzles.chapter2ExpressivePuzzlers;

public class Puzzle5TheJoyOfHex {
  public static void main(String[] args) {
    System.out.println(Long.toHexString(0x100_000_000L + 0xcafebabeL));
  }
}
