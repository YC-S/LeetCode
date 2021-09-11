package leetcode500.p06_string.plan2;

public class P165_CompareVersionNumber {
  public int compareVersion(String version1, String version2) {
    String[] array1 = version1.split("\\.");
    String[] array2 = version2.split("\\.");
    for (int i = 0; i < array1.length; i++) {
      array1[i] = removeLeadingZero(array1[i]);
    }
    for (int i = 0; i < array2.length; i++) {
      array2[i] = removeLeadingZero(array2[i]);
    }
    int i = 0;
    while (i < array1.length && i < array2.length) {
      if (Integer.parseInt(array1[i]) < Integer.parseInt(array2[i])) {
        return -1;
      } else if (Integer.parseInt(array1[i]) > Integer.parseInt(array2[i])) {
        return 1;
      }
      i++;
    }
    while (i < array1.length) {
      if (array1[i].equals("0")) {
        i++;
      } else {
        return 1;
      }
    }
    while (i < array2.length) {
      if (array2[i].equals("0")) {
        i++;
      } else {
        return -1;
      }
    }
    return 0;
  }

  private String removeLeadingZero(String s) {
    if (s.equals("0")) {
      return s;
    }
    char[] arr = s.toCharArray();
    int i = 0;
    for (; i < arr.length; i++) {
      if (arr[i] == '0') {
        continue;
      } else {
        break;
      }
    }
    if (i == arr.length) {
      return "0";
    } else {
      return s.substring(i);
    }
  }
}
