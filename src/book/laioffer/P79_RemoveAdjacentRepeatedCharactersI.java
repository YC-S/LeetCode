package book.laioffer;

public class P79_RemoveAdjacentRepeatedCharactersI {
  public static String deDup(String input) {
    char[] array = input.toCharArray();
    int i = 1, j = 1;
    while (j < array.length) {
      if (array[j] != array[j - 1]) {
        array[i++] = array[j];
      }
      j++;
    }
    return new String(array, 0, i);
  }

  public static void main(String[] args) {
    System.out.println(deDup("aaaabbbc"));
    System.out.println(deDup("abc"));
  }
}
