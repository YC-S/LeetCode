package book.laioffer;

public class P75_NumberOfDifferentBits {
  public int diffBits(int a, int b) {
    int c = a ^ b;
    int count = 0;
    while (c != 0) {
      count++;
      c &= (c - 1);
    }
    return count;
  }
}
