package algoexpert;

import java.util.ArrayList;
import java.util.Stack;

public class RemoveIslands {
    public int[][] removeIslands(int[][] matrix) {
        boolean[][] onesConnectedToBorder = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            onesConnectedToBorder[i][matrix[0].length - 1] = false;
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                boolean rowIsBorder = row == 0 || row == matrix.length - 1;
                boolean colIsBorder = col == 0 || col == matrix[0].length - 1;
                boolean isBorder = rowIsBorder || colIsBorder;

                if (!isBorder) {
                    continue;
                }

                if (matrix[row][col] != 1) {
                    continue;
                }
                findOnesConnectedToBorder(matrix, row, col, onesConnectedToBorder);
            }
        }
        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[0].length - 1; col++) {
                if (onesConnectedToBorder[row][col]) {
                    continue;
                }
                matrix[row][col] = 0;
            }
        }
        return matrix;
    }

    public void findOnesConnectedToBorder(int[][] matrix, int startRow, int startCol, boolean[][] onesConnectedToBorder) {
        Stack<int[]> stack = new Stack<int[]>();
        stack.push(new int[]{startRow, startCol});
        while (stack.size() > 0) {
            int[] currentPosition = stack.pop();
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];

            boolean alreadyVisited = onesConnectedToBorder[currentRow][currentCol];
            if (alreadyVisited) {
                continue;
            }
            onesConnectedToBorder[currentRow][currentCol] = true;
            int[][] neighbors = getNeighbors(matrix, currentRow, currentCol);
            for (int[] neighbor : neighbors) {
                int row = neighbor[0];
                int col = neighbor[1];
                if (matrix[row][col] != 1) {
                    continue;
                }
                stack.push(neighbor);
            }
        }
    }

    public int[][] getNeighbors(int[][] matrix, int row, int col) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        ArrayList<int[]> temp = new ArrayList<>();
        if (row - 1 >= 0) {
            temp.add(new int[]{row - 1, col});
        }
        if (row + 1 < numRows) {
            temp.add(new int[]{row + 1, col});
        }
        if (col - 1 >= 0) {
            temp.add(new int[]{row, col - 1});
        }
        if (col + 1 < numCols) {
            temp.add(new int[]{row, col + 1});
        }
        int[][] neighbors = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            neighbors[i] = temp.get(i);
        }
        return neighbors;
    }
}
