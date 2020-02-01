package strings;

// String to Integer (atoi)
// Implement atoi which converts a string to an integer.
//
// The function first discards as many whitespace characters as necessary until the first
// non-whitespace character is found. Then, starting from this character, takes an optional initial
// plus or minus sign followed by as many numerical digits as possible, and interprets them as a
// numerical value.
//
// The string can contain additional characters after those that form the integral number, which are
// ignored and have no effect on the behavior of this function.
//
// If the first sequence of non-whitespace characters in str is not a valid integral number, or if
// no such sequence exists because either str is empty or it contains only whitespace characters, no
// conversion is performed.
//
// If no valid conversion could be performed, a zero value is returned.
//
// Note:
//
// Only the space character ' ' is considered as whitespace character.
// Assume we are dealing with an environment which could only store integers within the 32-bit
// signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of
// representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
// Example 1:
//
// Input: "42"
// Output: 42
// Example 2:
//
// Input: "   -42"
// Output: -42
// Explanation: The first non-whitespace character is '-', which is the minus sign.
//             Then take as many numerical digits as possible, which gets 42.
// Example 3:
//
// Input: "4193 with words"
// Output: 4193
// Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
// Example 4:
//
// Input: "words and 987"
// Output: 0
// Explanation: The first non-whitespace character is 'w', which is not a numerical
//             digit or a +/- sign. Therefore no valid conversion could be performed.
// Example 5:
//
// Input: "-91283472332"
// Output: -2147483648
// Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
//             Therefore INT_MIN (−231) is returned.
public class Atoi {

  public static int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    int res = 0;
    boolean negative = false;
    str = str.trim();
    if (str.startsWith("[^1-9]")) {
      return 0;
    }

    int i = 0;
    if (str.charAt(i) == '-') {
      negative = true;
      i++;
    }

    char[] array = str.toCharArray();
    while (i < str.length() && (str.charAt(i) - '0') >= 0 && str.charAt(i) - '0' <= 9) {
      int tmp = array[i] - ('0');
      if (negative
        && ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && tmp > 8))) {
        return 0;
      } else if (!negative
        && ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && tmp > 7))) {
        return 0;
      } else {
        res *= 10;
        res += tmp;
      }
      i++;
    }
    return negative ? res * (-1) : res;
  }

  public static void main(String[] args) {
    System.out.println(myAtoi("-123"));
    System.out.println(myAtoi("-91283472332"));
    System.out.println(myAtoi("words and 987"));
    System.out.println(myAtoi("4193 with words"));
    System.out.println(myAtoi("   -42"));
  }
}
