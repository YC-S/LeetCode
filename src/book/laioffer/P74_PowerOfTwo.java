package book.laioffer;

public class P74_PowerOfTwo {
  public static boolean isPowerOfTwo(int number) {
    short numberOfOne = 0;
    if (number <= 0) return false;
    while (number != 0) {
      numberOfOne++;
      number &= (number - 1);
    }
    return numberOfOne == 1;
  }

  public static void main(String[] args) {
    System.out.println(isPowerOfTwo(1));
    System.out.println(isPowerOfTwo(2));
    System.out.println(isPowerOfTwo(4));
    System.out.println(isPowerOfTwo(8));
    System.out.println(isPowerOfTwo(16));
    System.out.println(isPowerOfTwo(11));
    System.out.println(isPowerOfTwo(-2147483648));
    System.out.println(isPowerOfTwo(Integer.MIN_VALUE));
  }
}
