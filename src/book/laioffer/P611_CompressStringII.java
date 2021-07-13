package book.laioffer;

public class P611_CompressStringII {
  public static String compress(String input) {
    StringBuilder sb = new StringBuilder();
    int count = 1;
    for (int i = 1; i <= input.length(); i++) {
      if (i == input.length() || input.charAt(i) != input.charAt(i - 1)) {
        sb.append(input.charAt(i - 1)).append(count);
        count = 1;
      } else {
        count++;
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(compress("abbcccdeee"));
  }
}
