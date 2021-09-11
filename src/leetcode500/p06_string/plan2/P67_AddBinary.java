package leetcode500.p06_string.plan2;

public class P67_AddBinary {
  public static String addBinary(String a, String b) {
    int i = a.length() - 1, j = b.length() - 1;
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    while (i >= 0 && j >= 0) {
      if (a.charAt(i) == '1' && b.charAt(j) == '1' && carry == 0) {
        sb.append(0);
        carry = 1;
      } else if (a.charAt(i) == '1' && b.charAt(j) == '1' && carry == 1) {
        sb.append(1);
      } else if (a.charAt(i) == '0' && b.charAt(j) == '0') {
        if (carry == 0) {
          sb.append(0);
        } else {
          sb.append(1);
          carry = 0;
        }
      } else {
        if (carry == 0) {
          sb.append(1);
        } else {
          sb.append(0);
        }
      }
      i--;
      j--;
    }
    while (i >= 0) {
      if (a.charAt(i) == '1' && carry == 1) {
        sb.append(0);
      } else if (a.charAt(i) == '0' && carry == 0) {
        sb.append(a.charAt(i));
      } else if (a.charAt(i) == '0' && carry == 1) {
        sb.append(1);
        carry = 0;
      } else {
        sb.append(1);
      }
      i--;
    }
    while (j >= 0) {
      if (b.charAt(j) == '1' && carry == 1) {
        sb.append(0);
      } else if (b.charAt(j) == '0' && carry == 0) {
        sb.append(b.charAt(j));
      } else if (b.charAt(j) == '0' && carry == 1) {
        sb.append(1);
        carry = 0;
      } else {
        sb.append(1);
      }
      j--;
    }
    if (carry == 1) {
      sb.append(1);
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(addBinary("1111", "1111"));
  }
}
