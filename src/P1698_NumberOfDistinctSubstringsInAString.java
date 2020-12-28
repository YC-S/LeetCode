import java.util.HashSet;
import java.util.Set;

public class P1698_NumberOfDistinctSubstringsInAString {
    public static int countDistinct(String s) {
        char[] arr = s.toCharArray();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < arr.length; j++) {
                sb.append(arr[j]);
                set.add(sb.toString());
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(countDistinct("aabbaba"));
    }
}
