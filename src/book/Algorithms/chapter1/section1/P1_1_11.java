package book.Algorithms.chapter1.section1;

public class P1_1_11 {
    public static void main(String[] args) {
        boolean[][] matrix = {{true, true, false, false, true}, {false, true, false, true, false}};
        twoDArray(matrix);
    }

    public static void twoDArray(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
