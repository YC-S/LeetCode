package laicode.cross_trainingIV;

public class MajorityNumberI {
  public int majority(int[] array) {
    int candidate = array[0];
    int count = 1;
    for (int i = 1; i < array.length; i++) {
      if (count == 0) {
        count++;
        candidate = array[i];
      } else if (candidate == array[i]) count++;
      else count--;
    }
    return candidate;
  }
}
