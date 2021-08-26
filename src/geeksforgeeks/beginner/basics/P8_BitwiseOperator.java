package geeksforgeeks.beginner.basics;

public class P8_BitwiseOperator {
  int e;

  public static void bitWiseOp(int a, int b, int c) {
    int d = a ^ a;
    int e = c ^ b;
    int f = a & b;
    int g = c | (a ^ a);
    e = ~e;

    System.out.println(d);
    System.out.println(b ^ c);
    System.out.println(f);
    System.out.println(g);
    System.out.println(e);
  }

  public static void main(String[] args) {
    bitWiseOp(23, 25, 345);
  }
}
