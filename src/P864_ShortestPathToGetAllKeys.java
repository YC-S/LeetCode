/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/10
 */
public class P864_ShortestPathToGetAllKeys {

    public int shortestPathAllKeys(String[] grid) {

        int rows = grid.length;
        int cols = grid[0].length();
        int totalKeys = 0;

        //find stating point '@'
        int[] start = null;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i].charAt(j) == '@') {
                    start = new int[]{i, j};
                }

                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    totalKeys++;
                }
            }
        }

        if (null == start) {
            return -1;
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        //you can go to a node only with corresponding keys
        String originalKey = ".@abcdef";

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start[0], start[1], 0, originalKey, 0));
        Set<String> visited = new HashSet<>();

        //bfs from start point
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            char curChar = grid[curNode.i].charAt(curNode.j);

            //find a new key to one of the 'ABCDEF' lock
            if (curChar >= 'a' && curChar <= 'f') {
                char upperCurChar = Character.toUpperCase(curChar);
                //and currently we don't have this key
                if (curNode.keys.indexOf(upperCurChar) == -1) {
                    //hold the key at your hand
                    curNode.keys += Character.toUpperCase(curChar);
                    curNode.collectedKeys++;
                }
            }

            if (curNode.collectedKeys == totalKeys) {
                return curNode.steps;
            }

            for (int[] dir : dirs) {
                int x = curNode.i + dir[0];
                int y = curNode.j + dir[1];
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    //you can take one step only when you have the key
                    if (curNode.keys.indexOf(grid[x].charAt(y)) > -1) {
                        String key = x + "-" + y + "-" + curNode.keys;
                        if (visited.contains(key)) {
                            continue;
                        }
                        visited.add(key);
                        queue.offer(new Node(x, y, curNode.steps + 1, curNode.keys, curNode.collectedKeys));
                    }
                }
            }
        }

        return -1;
    }

    /**
     * BFS to find shortest path. Create a new Class Node to store the position.
     */

    static class Node {

        int i;
        int j;
        int steps;
        String keys;
        int collectedKeys;

        public Node(int i, int j, int steps, String keys, int collectedKeys) {
            this.i = i;
            this.j = j;
            this.steps = steps;
            this.keys = keys;
            this.collectedKeys = collectedKeys;
        }
    }


}
