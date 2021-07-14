package book.laioffer;

public class P626_ReverseBitsOf32BitInteger {
  public static long reverseBits(long n) {
    for (int i = 0, j = 31; i < j; i++, j--) {
      long left = (n >> i) & 1L;
      long right = (n >> j) & 1L;
      if (left != right) {
        n ^= (1L << i) | (1L << j);
      }
    }
    return n;
  }

  public static void main(String[] args) {
    System.out.println(reverseBits(2));
  }
}
