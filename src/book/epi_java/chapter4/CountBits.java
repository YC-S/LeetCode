package book.epi_java.chapter4;

public class CountBits {
  public static int countBits(int x) {
    x ^= x >>> 32;
    x ^= x >>> 16;
    x ^= x >>> 8;
    x ^= x >>> 4;
    x ^= x >>> 2;
    return (short) (x ^= (0x1));
  }

  public static void main(String[] args) {
    System.out.println(countBits(1));
    System.out.println(countBits(2));
    System.out.println(countBits(4));
    System.out.println(countBits(1024));
  }
}
