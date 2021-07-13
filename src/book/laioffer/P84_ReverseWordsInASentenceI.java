package book.laioffer;

public class P84_ReverseWordsInASentenceI {
  public static String reverseWords(String input) {
    if (input == null || input.length() == 0) return input;
    input = reverse(input);
    String[] array = input.split(" ");
    for (int i = 0; i < array.length; i++) {
      array[i] = reverse(array[i]);
    }
    return String.join(" ", array);
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
    System.out.println(reverseWords("I Love Google"));
  }
}
