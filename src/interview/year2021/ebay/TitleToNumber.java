package interview.year2021.ebay;

public class TitleToNumber {
  public static int titleToNumber(String s) {
    int result = 0;
    try {
      if (s == null) {
        throw new Exception();
      }
      for (int i = 0; i < s.length(); i++) {
        if (!(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
          throw new Exception();
        }
        result = result * 26 + (s.charAt(i) - 'A' + 1);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(titleToNumber("a"));
    System.out.println(titleToNumber("b"));
    System.out.println(titleToNumber("C"));
    System.out.println(titleToNumber("C"));
  }
}
