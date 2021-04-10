package algoexpert;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RiverSizes {
    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j]) {
                    helper(res, matrix, i, j, visited);
                }
            }
        }
        return res;
    }

    private static void helper(List<Integer> res, int[][] matrix, int i, int j, boolean[][] visited) {
        int cur = 0;
        Deque<Integer[]> stack = new ArrayDeque<>();
        stack.offerFirst(new Integer[]{i, j});
        while (!stack.isEmpty()) {
            Integer[] curNode = stack.pollFirst();
            i = curNode[0];
            j = curNode[1];
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            if (matrix[i][j] == 0) {
                continue;
            }
            cur++;
            List<Integer[]> unvisitedNeighbors = getNeighbors(i, j, matrix, visited);
            for (Integer[] neightbor : unvisitedNeighbors) {
                stack.offerFirst(neightbor);
            }
        }
        if (cur > 0) {
            res.add(cur);
        }
    }

    private static List<Integer[]> getNeighbors(int i, int j, int[][] matrix, boolean[][] visited) {
        List<Integer[]> unvisitedNeighbors = new ArrayList<Integer[]>();
        if (i > 0 && !visited[i - 1][j]) {
            unvisitedNeighbors.add(new Integer[]{i - 1, j});
        }
        if (i < matrix.length - 1 && !visited[i + 1][j]) {
            unvisitedNeighbors.add(new Integer[]{i + 1, j});
        }
        if (j > 0 && !visited[i][j - 1]) {
            unvisitedNeighbors.add(new Integer[]{i, j - 1});
        }
        if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
            unvisitedNeighbors.add(new Integer[]{i, j + 1});
        }
        return unvisitedNeighbors;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}};
        System.out.println(riverSizes(matrix));
    }
}
