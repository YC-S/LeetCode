/*
 * Copyright (c) 2020. Yuanchen
 */

package company.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/22
 */
public class Q36CourseScheduleII {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] res = new int[numCourses];
    int[] indegree = new int[numCourses];

    for (int[] pre : prerequisites) {
      indegree[pre[0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }

    int i = 0;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      res[i++] = cur;
      for (int[] pre : prerequisites) {
        if (pre[1] == cur) {
          indegree[pre[0]]--;
          if (indegree[pre[0]] == 0) {
            queue.offer(pre[0]);
          }
        }
      }
    }

    return numCourses == i ? res : new int[]{};
  }
}
