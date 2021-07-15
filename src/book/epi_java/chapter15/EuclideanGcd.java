package book.epi_java.chapter15;

public class EuclideanGcd {
  public static long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public static void main(String[] args) {
    System.out.println(gcd(156, 36));
  }
}
