package leetcode500.p20_topological_order.plan1;

import java.util.LinkedList;
import java.util.Queue;

public class P207_CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses == 0 || prerequisites.length == 0) return true;
    int[] indegree = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      indegree[prerequisites[i][0]]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }
    int canFinishCount = queue.size();
    while (!queue.isEmpty()) {
      int prerequisite = queue.remove();
      for (int i = 0; i < prerequisites.length; i++) {
        if (prerequisites[i][1] == prerequisite) {
          indegree[prerequisites[i][0]]--;
          if (indegree[prerequisites[i][0]] == 0) {
            canFinishCount++;
            queue.add(prerequisites[i][0]);
          }
        }
      }
    }
    return canFinishCount == numCourses;
  }
}
