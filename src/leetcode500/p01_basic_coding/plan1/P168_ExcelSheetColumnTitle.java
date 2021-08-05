package leetcode500.p01_basic_coding.plan1;

public class P168_ExcelSheetColumnTitle {
  public static String convertToTitle(int columnNumber) {
    StringBuilder sb = new StringBuilder();
    while (columnNumber != 0) {
      if (columnNumber % 26 == 0) {
        sb.append("Z");
        columnNumber -= 26;
      } else {
        sb.append((char) (columnNumber % 26 - 1 + 'A'));
      }
      columnNumber /= 26;
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(convertToTitle(1));
    System.out.println(convertToTitle(28));
    System.out.println(convertToTitle(701));
    System.out.println(convertToTitle(2147483647));
  }
}
