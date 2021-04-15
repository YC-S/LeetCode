package algoexpert;

public class RemoveIslands {
    public static int[][] removeIslands(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int[][] copyGrid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                copyGrid[i][j] = matrix[i][j];
            }
        }
        DFS(matrix, copyGrid, visited, 0, 0);
        return copyGrid;
    }

    private static void DFS(int[][] grid, int[][] copyGrid, boolean[][] visited, int i, int j) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= columns || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (i > 0 && grid[i - 1][j] == 1 && i < rows - 1 && grid[i + 1][j] == 1 && j > 0 && grid[i][j - 1] == 1
                && j < columns - 1 && grid[i][j + 1] == 1) {
            copyGrid[i][j] = 0;
        }
        DFS(grid, copyGrid, visited, i + 1, j);
        DFS(grid, copyGrid, visited, i - 1, j);
        DFS(grid, copyGrid, visited, i, j + 1);
        DFS(grid, copyGrid, visited, i, j - 1);
    }
}
