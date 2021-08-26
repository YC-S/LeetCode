package geeksforgeeks.beginner.arrays;

public class P8_ThePatternMatcher {
  public static void follPatt(String s) {
    int n = s.length();
    int c = 0;
    char ch = 'x';
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == 'x' && ch == 'x') {
        c++;
      } else {
        c--;
        if (c == 0) {
          ch = 'x';
        } else {
          ch = 'y';
        }
      }
    }
    if (c == 0) {
      System.out.println("1");
    } else {
      System.out.println("0");
    }
  }
}
