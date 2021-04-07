package algoexpert;

public class SearchInSortedMatrix {
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // Write your code here.
        int m = matrix[0].length;
        int n = matrix.length;

        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return new int[]{i, j};
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1, -1};
    }
}
