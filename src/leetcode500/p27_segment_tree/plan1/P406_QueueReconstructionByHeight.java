package leetcode500.p27_segment_tree.plan1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P406_QueueReconstructionByHeight {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(
        people,
        ((o1, o2) -> {
          if (o1[0] == o2[0]) {
            return o1[1] - o2[1];
          } else {
            return o2[0] - o1[0];
          }
        }));
    List<int[]> resultList = new LinkedList<>();
    for (int[] cur : people) {
      resultList.add(cur[1], cur);
    }
    return resultList.toArray(new int[people.length][]);
  }
}
