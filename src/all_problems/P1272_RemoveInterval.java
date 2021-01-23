package all_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1272_RemoveInterval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] i : intervals) {
            if (i[1] <= toBeRemoved[0] || i[0] >= toBeRemoved[1]) { // no overlap.
                ans.add(Arrays.asList(i[0], i[1]));
            } else { // i[1] > toBeRemoved[0] && i[0] < toBeRemoved[1].
                if (i[0] < toBeRemoved[0]) // left end no overlap.
                    ans.add(Arrays.asList(i[0], toBeRemoved[0]));
                if (i[1] > toBeRemoved[1]) // right end no overlap.
                    ans.add(Arrays.asList(toBeRemoved[1], i[1]));
            }
        }
        return ans;
    }
}
