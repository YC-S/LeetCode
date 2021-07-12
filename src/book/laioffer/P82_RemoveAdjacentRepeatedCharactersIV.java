package book.laioffer;

public class P82_RemoveAdjacentRepeatedCharactersIV {
  public String deDup(String input) {
    if (input == null || input.length() <= 1) return input;
    char[] array = input.toCharArray();
    int j = 0;
    for (int i = 1; i < array.length; i++) {
      if (j == -1 || array[i] != array[j]) {
        array[++j] = array[i];
      } else {
        j--;
        while (i + 1 < array.length && array[i] == array[i + 1]) {
          i++;
        }
      }
    }
    return new String(array, 0, j + 1);
  }
}
