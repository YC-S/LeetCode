package leetcode500.p06_string.plan6;

public class P791_CustomSortString {
  public String customSortString(String order, String s) {
    char[] orderArray = order.toCharArray();
    char[] sArray = s.toCharArray();
    int[] count = new int[order.length()];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < sArray.length; i++) {
      boolean exist = false;
      for (int j = 0; j < orderArray.length; j++) {
        if (sArray[i] == orderArray[j]) {
          count[j]++;
          exist = true;
          break;
        }
      }
      if (!exist) {
        sb.append(sArray[i]);
      }
    }

    for (int i = 0; i < count.length; i++) {
      char key = orderArray[i];
      int val = count[i];
      if (val != 0) {
        for (int j = 0; j < val; j++) {
          sb.append(key);
        }
      }
    }
    return sb.toString();
  }
}
