package book.laioffer;

public class P397_RightShiftByNCharacters {
  public static String rightShift(String input, int n) {
    if (input == null || input.length() == 0 || n == 0) return input;
    int m = input.length();
    n = n % m;
    String left = reverse(input.substring(0, m - n));
    String right = reverse(input.substring(m - n));
    return reverse(left + right);
  }

  private static String reverse(String input) {
    char[] array = input.toCharArray();
    for (int i = 0, j = array.length - 1; i < j; i++, j--) {
      char tmp = array[i];
      array[i] = array[j];
      array[j] = tmp;
    }
    return new String(array);
  }

  public static void main(String[] args) {
    System.out.println(rightShift("abcdefg", 3));
  }
}
