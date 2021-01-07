package all_problems;

public class P434_NumberOfSegmentsInAString {
    public int countSegments(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                res++;
            }
        return res;
    }
}
