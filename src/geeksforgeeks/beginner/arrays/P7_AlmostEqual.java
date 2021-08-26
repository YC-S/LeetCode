package geeksforgeeks.beginner.arrays;

public class P7_AlmostEqual {
  static int coutChars(String s1, String s2) {
    int[] chars = new int[26];
    for (char c : s1.toCharArray()) {
      chars[c - 97]++;
    }
    for (char c : s2.toCharArray()) {
      chars[c - 97]--;
    }
    int count = 0;
    for (int i : chars) {
      count += Math.abs(i);
    }

    return count;
  }

  public static void main(String[] args) {
    String s1 =
        "tgspevpggkapwdnxaycxutuhsmwthzvyhbllukloufrblllvjsddcoptqxxclyhbqgytuqewohvjhbwwtykejccpmvatogqnwczs";
    String s2 =
        "ectjpxpdrqlcuvqsnpownqtoveiwmgnvvbuvwoqwczzetjleyceqkhsouayuwtzapnblphcpdnuftlpctopwhgmbltftishaoykl";
    System.out.println(coutChars(s1, s2));
  }
}
