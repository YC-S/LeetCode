package all_problems;

public class P1624_LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] arr = new int[26];
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            max = Math.max((arr[s.charAt(i) - 'a'] - i - 1), max);
        }
        return max;
    }
}
