/*
 * Copyright (c) 2020. Yuanchen
 */

package company.amazon.amazon_oa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/03
 */
public class MinimumDistanceToRemoveObstacle {
    // time complexity: O(mn)
    // space complexity: O(mn)

    public static int remove(List<List<Integer>> lot, int numColumns, int numRows) {
        if (lot == null || lot.size() == 0) {
            return -1;
        }
        boolean[] visited = new boolean[numRows * numColumns];
        Queue<Integer> q = new LinkedList<>();

        if (numRows * numColumns == 1) {
            return 1;
        }
        if (lot.get(0).get(0) == 0 || lot.get(0).get(0) == 9) {
            return 0;
        }

        q.add(0);
        visited[0] = true;
        int steps = 0;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curP = q.poll();
                int curX = curP / numColumns;
                int curY = curP % numColumns;
                if (lot.get(curX).get(curY) == 9) {
                    return steps;
                }
                for (int[] direction : directions) {
                    int newX = curX + direction[0];
                    int newY = curY + direction[1];
                    int newP = newX * numColumns + newY;
                    if (newX >= 0 && newX < numRows && newY >= 0 && newY < numColumns
                        && !visited[newP] && lot.get(newX).get(newY) != 0) {
                        visited[newP] = true;
                        q.offer(newP);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> lot = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(0);
        l1.add(0);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(0);
        l2.add(0);
        List<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l3.add(9);
        l3.add(1);
        lot.add(l1);
        lot.add(l2);
        lot.add(l3);
        System.out.println(remove(lot, 3, 3));
    }
}
