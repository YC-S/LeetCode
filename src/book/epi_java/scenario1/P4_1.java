package book.epi_java.scenario1;

public class P4_1 {
  public static byte parity(int num) {
    byte count1 = 0;
    while (num != 0) {
      count1 ^= (num & 1);
      num >>>= 1;
    }
    return count1;
  }

  public static void main(String[] args) {
    System.out.println(parity(0b1011));
    System.out.println(parity(0b10001000));
  }
}
