package interview.year2020;

public class Q3 {
  public static String impl(String s) {
    return s;
  }

  public static String impl(StringBuffer sb) {
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(impl("null"));
  }
}
