package all_problems;

public class P1844_ReplaceAllDigitsWithCharacters {
  public String replaceDigits(String s) {
    char[] charArr = s.toCharArray();
    for (int i = 1; i < charArr.length; i += 2) {
      charArr[i] = (char) (charArr[i - 1] + charArr[i] - '0');
    }
    return String.valueOf(charArr);
  }
}
