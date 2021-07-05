package book.epi_java.chapter4;

public class CountBits {
  public static int countBits(int x) {
    short count = 0;
    while (x != 0) {
      count += (x & 1);
      x >>>= 1;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countBits(1));
    System.out.println(countBits(2));
    System.out.println(countBits(4));
    System.out.println(countBits(1024));
  }
}
