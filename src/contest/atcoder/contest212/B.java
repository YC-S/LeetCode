package contest.atcoder.contest212;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    String[] pins = str.split("");
    String[] weak =
        new String[] {
          "0123", "9012", "8901", "7890", "1234", "2345", "3456", "4567", "5678", "6789"
        };
    boolean isWeak = false;
    for (int i = 1; i < pins.length; i++) {
      if (pins[i].equals(pins[i - 1])) {
        isWeak = true;
        break;
      }
    }
    Set<String> set = new HashSet<>(Arrays.asList(weak));
    if (set.contains(str)) isWeak = true;
    if (isWeak) {
      System.out.println("Weak");
    } else {
      System.out.println("Strong");
    }
  }
}
