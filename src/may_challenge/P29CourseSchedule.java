/*
 * Copyright (c) 2020. Yuanchen
 */

package may_challenge;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/05/29
 */
public class P29CourseSchedule {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashSet<Integer> visiting = new HashSet();
    HashSet<Integer> completed = new HashSet();

    ArrayList<Integer>[] graph = new ArrayList[numCourses];

    for (int i = 0; i < numCourses; ++i) {
      graph[i] = new ArrayList();
    }

    for (int i = 0; i < prerequisites.length; ++i) {
      graph[prerequisites[i][1]].add(prerequisites[i][0]);
    }

    for (int i = 0; i < numCourses; ++i) {
      if (!canCompleteCourse(graph, visiting, completed, i)) {
        return false;
      }
    }

    return true;
  }

  private boolean canCompleteCourse(ArrayList<Integer>[] graph,
    HashSet<Integer> visiting, HashSet<Integer> completed,
    int course) {
    if (visiting.contains(course)) {
      return false;
    }

    if (completed.contains(course)) {
      return true;
    }

    visiting.add(course);
    for (int i = 0; i < graph[course].size(); ++i) {
      if (!canCompleteCourse(graph, visiting, completed,
        graph[course].get(i))) {
        return false;
      }
    }
    visiting.remove(course);

    completed.add(course);

    return true;
  }
}
