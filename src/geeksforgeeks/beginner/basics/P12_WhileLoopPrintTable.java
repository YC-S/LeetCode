package geeksforgeeks.beginner.basics;

public class P12_WhileLoopPrintTable {
  static void printTable(int n) {
    int multiplier = 10;
    while (multiplier > 0) {
      System.out.println(n * multiplier);
      multiplier--;
    }
  }

  public static void main(String[] args) {
    printTable(1);
  }
}
