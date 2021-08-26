package geeksforgeeks.beginner.arrays;

public class P6_ConsonantsAndVowelsCheck {
  static void checkString(String s) {
    char[] arr = s.toCharArray();
    int vowel = 0, consonant = 0;
    for (char c : arr) {
      if ("aeiou".contains(String.valueOf(c))) {
        vowel++;
      } else if (c == ' ') {
        continue;
      } else {
        consonant++;
      }
    }
    if (vowel > consonant) {
      System.out.print("Yes");
    } else if (vowel < consonant) {
      System.out.print("No");
    } else {
      System.out.print("Same");
    }
    System.out.println();
  }
}
