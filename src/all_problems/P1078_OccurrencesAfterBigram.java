package all_problems;

import java.util.ArrayList;
import java.util.List;

public class P1078_OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ans = new ArrayList<>();
        for (int i = 2; i < words.length; ++i) {
            if (first.equals(words[i - 2]) && second.equals(words[i - 1]))
                ans.add(words[i]);
        }
        return ans.toArray(new String[0]);
    }
}
