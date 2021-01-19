package all_problems;

public class P1037_ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        int determinant = 0;

        determinant = (points[0][0]) * (points[1][1] - points[2][1]) - (points[1][0]) * (points[0][1] - points[2][1]) + (points[2][0]) * (points[0][1] - points[1][1]);

        return determinant != 0;
    }
}
