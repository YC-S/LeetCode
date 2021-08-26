package geeksforgeeks.beginner.basics;

public class P11_ForLoopPrimeCheck {
  static void isPrime(int n) {
    boolean check = true;
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        check = false;
      }
    }
    if (check) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
