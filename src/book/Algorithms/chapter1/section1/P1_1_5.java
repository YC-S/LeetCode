package book.Algorithms.chapter1.section1;

public class P1_1_5 {
    public static void main(String[] args) {
        System.out.println(check(1.0, 0.3));
    }

    public static boolean check(double x, double y) {
        return 0 <= x && x <= 1 && 0 <= y && y <= 1;
    }
}
