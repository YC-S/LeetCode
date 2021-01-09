/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_june;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/06
 */
public class P6QueueReconstructionByHeight {

  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          return o1[1] - o2[1];
        } else {
          return o2[0] - o1[0];
        }
      }
    }));
    List<int[]> resultList = new LinkedList<>();
    for (int[] cur : people) {
      resultList.add(cur[1], cur);
    }
    return resultList.toArray(new int[people.length][]);
  }
}
