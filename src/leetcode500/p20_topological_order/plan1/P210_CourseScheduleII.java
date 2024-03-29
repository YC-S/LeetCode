package leetcode500.p20_topological_order.plan1;

import java.util.LinkedList;
import java.util.Queue;

public class P210_CourseScheduleII {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (numCourses == 0) return null;
    int[] indegree = new int[numCourses];
    int[] order = new int[numCourses];
    int index = 0;
    for (int[] ints : prerequisites) {
      indegree[ints[0]]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        order[index++] = i;
        queue.offer(i);
      }
    }
    while (!queue.isEmpty()) {
      int prerequisite = queue.poll();
      for (int i = 0; i < prerequisites.length; i++) {
        if (prerequisites[i][1] == prerequisite) {
          indegree[prerequisites[i][0]]--;
          if (indegree[prerequisites[i][0]] == 0) {
            order[index++] = prerequisites[i][0];
            queue.offer(prerequisites[i][0]);
          }
        }
      }
    }
    return index == numCourses ? order : new int[0];
  }
}
