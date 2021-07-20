package laicode.cross_trainingI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestAndSecondLargest {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(new LargestAndSecondLargest().largestAndSecond(new int[] {2, 1, 5, 4, 3})));
  }

  public int[] largestAndSecond(int[] array) {
    Element[] helper = convert(array);
    int largerLength = array.length;
    while (largerLength > 1) {
      compareAndSwap(helper, largerLength);
      largerLength = (largerLength + 1) / 2;
    }
    return new int[] {helper[0].value, largest(helper[0].comparedValues)};
  }

  private Element[] convert(int[] array) {
    Element[] helper = new Element[array.length];
    for (int i = 0; i < array.length; i++) {
      helper[i] = new Element(array[i]);
    }
    return helper;
  }

  private void compareAndSwap(Element[] helper, int largerLength) {
    for (int i = 0; i < largerLength / 2; i++) {
      if (helper[i].value < helper[largerLength - 1 - i].value)
        swap(helper, i, largerLength - i - 1);
      helper[i].comparedValues.add(helper[largerLength - i - 1].value);
    }
  }

  private void swap(Element[] helper, int left, int right) {
    Element tmp = helper[left];
    helper[left] = helper[right];
    helper[right] = tmp;
  }

  private int largest(List<Integer> list) {
    int max = list.get(0);
    for (int num : list) {
      max = Math.max(max, num);
    }
    return max;
  }

  class Element {
    int value;
    List<Integer> comparedValues;

    public Element(int value) {
      this.value = value;
      this.comparedValues = new ArrayList<>();
    }
  }
}
