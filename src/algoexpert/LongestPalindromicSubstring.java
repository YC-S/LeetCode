package algoexpert;

public class LongestPalindromicSubstring {
    public static String longestPalindromicSubstring(String str) {
        String longest = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String substring = str.substring(i, j + 1);
                if (substring.length() > longest.length() && helper(substring)) {
                    longest = substring;
                }
            }
        }
        return longest;
    }

    private static boolean helper(String str) {
        int begin = 0;
        int end = str.length() - 1;
        while (begin < end) {
            if (str.charAt(begin) != str.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("abaxyzzyxf"));
    }
}
