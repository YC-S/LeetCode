package book.laioffer;

public class P281_RemoveSpaces {
  public String removeSpaces(String input) {
    char[] array = input.toCharArray();
    int i = 0, j = 0;
    for (; j < array.length; j++) {
      if (array[j] == ' ' && (j == 0 || array[j - 1] == ' ')) continue;
      array[i++] = array[j];
    }
    if (i > 0 && array[i - 1] == ' ') {
      i--;
    }
    return new String(array, 0, i);
  }
}
