package all_problems;

import java.util.TreeSet;

public class P1087_BraceExpansion {
    public String[] expand(String s) {
        // TreeSet to sort
        TreeSet<String> set = new TreeSet<>();
        if (s.length() == 0) {
            return new String[]{""};
        } else if (s.length() == 1) {
            return new String[]{s};
        }
        if (s.charAt(0) == '{') {
            int i = 0; // keep track of content in the "{content}"
            while (s.charAt(i) != '}') {
                i++;
            }
            String sub = s.substring(1, i);
            String[] subs = sub.split(",");
            String[] strs = expand(s.substring(i + 1)); // dfs
            for (int j = 0; j < subs.length; j++) {
                for (String str : strs) {
                    set.add(subs[j] + str);
                }
            }
        } else {
            String[] strs = expand(s.substring(1));
            for (String str : strs) {
                set.add(s.charAt(0) + str);
            }
        }
        return set.toArray(new String[0]);
    }
}
