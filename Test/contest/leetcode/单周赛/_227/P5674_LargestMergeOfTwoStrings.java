package contest.leetcode.单周赛._227;

public class P5674_LargestMergeOfTwoStrings {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) < word2.charAt(j)) {
                sb.append(word2.charAt(j));
                j++;
            } else if (word1.charAt(i) > word2.charAt(j)) {
                sb.append(word1.charAt(i));
                i++;
            } else {
                int a = i;
                int b = j;
                while (a < word1.length() && b < word2.length()) {
                    if (word1.charAt(a) == word2.charAt(b)) {
                        a++;
                        b++;
                    } else {
                        if (word1.charAt(a) < word2.charAt(b)) {
                            sb.append(word2, j, b + 1);
                            j = b + 1;
                        } else {
                            sb.append(word1, i, a + 1);
                            i = a + 1;
                        }
                        break;
                    }
                }
                if (a == word1.length()) {
                    sb.append(word1, i, a);
                    i = a;
                }
                if (b == word2.length()) {
                    sb.append(word2, j, b);
                    j = b;
                }
            }
        }
        while (i < word1.length()) {
            sb.append(word1.charAt(i++));
        }
        while (j < word2.length()) {
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}
