/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_august;

import leetcode500.p17_graph_traversal.plan2.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/29
 */
interface Robot {

  boolean move();

  void turnLeft();

  void turnRight();

  void clean();
}

public class P29RobotRoomCleaner {

  int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  Set<Pair<Integer, Integer>> visited = new HashSet();
  Robot robot;

  public void goBack() {
    robot.turnRight();
    robot.turnRight();
    robot.move();
    robot.turnRight();
    robot.turnRight();
  }

  public void backtrack(int row, int col, int d) {
    visited.add(new Pair(row, col));
    robot.clean();
    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    for (int i = 0; i < 4; ++i) {
      int newD = (d + i) % 4;
      int newRow = row + directions[newD][0];
      int newCol = col + directions[newD][1];

      if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
        backtrack(newRow, newCol, newD);
        goBack();
      }
      // turn the robot following chosen direction : clockwise
      robot.turnRight();
    }
  }

  public void cleanRoom(Robot robot) {
    this.robot = robot;
    backtrack(0, 0, 0);
  }
}
