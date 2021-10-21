package leetcode500.p06_string.plan6;

public class P482_LicenseKeyFormatting {
  public String licenseKeyFormatting(String s, int k) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '-') {
        if (Character.isLetter(s.charAt(i))) {
          if ('a' <= s.charAt(i) && 'z' >= s.charAt(i)) {
            sb.append((char) (s.charAt(i) + 'A' - 'a'));
          } else {
            sb.append(s.charAt(i));
          }
        } else {
          sb.append(s.charAt(i));
        }
      }
    }
    StringBuilder res = new StringBuilder();
    for (int i = sb.length() - 1; i >= 0; i--) {
      res.append(sb.charAt(i));
      if ((sb.length() - i) % k == 0 && i != 0) {
        res.append('-');
      }
    }
    return res.reverse().toString();
  }
}
