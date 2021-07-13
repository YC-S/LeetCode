package book.laioffer;

public class P396_ReverseString {
  public String reverse(String input) {
    char[] array = input.toCharArray();
    for (int i = 0, j = array.length - 1; i < j; i++, j--) {
      char tmp = array[i];
      array[i] = array[j];
      array[j] = tmp;
    }
    return new String(array);
  }
}
