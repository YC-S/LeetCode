package geeksforgeeks.beginner;

public class P6_PreciseFormat {
  static void printInFormat(float a, float b) {
    float result = a / b;
    System.out.print(result + " ");
    System.out.printf("%.3f", result);
  }
}
