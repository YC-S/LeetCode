package leetcode500.p06_string.plan1;

public class P405_ConvertANumberToHexadecimal {
  public static String toHex(int num) {
    if (num == 0) return "0";
    long longNum = num;
    if (longNum < 0) longNum += (2L << 31);
    char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    StringBuilder sb = new StringBuilder();
    while (longNum > 0) {
      sb.append(arr[(int) (longNum & 0b1111)]);
      longNum >>>= 4;
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(toHex(-1));
    System.out.println(toHex(26));
  }
}
