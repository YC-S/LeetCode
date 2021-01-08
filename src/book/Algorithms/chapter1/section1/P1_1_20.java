package book.Algorithms.chapter1.section1;

public class P1_1_20 {

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.log(factorial(5)));
    }
}
