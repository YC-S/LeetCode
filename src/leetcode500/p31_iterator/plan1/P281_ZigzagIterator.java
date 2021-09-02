package leetcode500.p31_iterator.plan1;

import java.util.List;

public class P281_ZigzagIterator {
  int currentV1;
  int currentV2;
  List<Integer> v1;
  List<Integer> v2;
  private boolean isV1;

  public P281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    this.v1 = v1;
    this.v2 = v2;
    currentV1 = 0;
    currentV2 = 0;
    this.isV1 = true;
  }

  public int next() {
    if (isV1) {
      Integer toReturn;
      if (currentV1 < v1.size()) {
        toReturn = v1.get(currentV1);
        currentV1++;
      } else {
        toReturn = v2.get(currentV2);
        currentV2++;
      }
      isV1 = false;
      return toReturn;
    } else {
      Integer toReturn;
      if (currentV2 < v2.size()) {
        toReturn = v2.get(currentV2);
        currentV2++;
      } else {
        toReturn = v1.get(currentV1);
        currentV1++;
      }
      isV1 = true;
      return toReturn;
    }
  }

  public boolean hasNext() {
    return currentV1 < v1.size() || currentV2 < v2.size();
  }
}
