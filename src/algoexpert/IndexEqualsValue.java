package algoexpert;

public class IndexEqualsValue {
  public int indexEqualsValue(int[] array) {
    for (int index = 0; index < array.length; index++) {
      int value = array[index];
      if (index == value) {
        return index;
      }
    }
    return -1;
  }
}
